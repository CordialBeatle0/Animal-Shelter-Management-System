package Server;

import RMI.Observer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    // Static instance variable to hold the single instance of the class
    private static MongoDatabase instance;
    
    private static final Gson gson = new GsonBuilder()
            // Register the LocalDateAdapter class to handle LocalDateTime objects
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();
    
    private MongoClient mongoClient;
    
    // all collections
    private static MongoCollection<Document> trainingCollection;
    private static MongoCollection<Document> observerCollection;
    private static MongoCollection<Document> accountCollection;
    private static MongoCollection<Document> userCollection;
    private static MongoCollection<Document> employeeCollection;
    private static MongoCollection<Document> sellingItemCollection;
    private static MongoCollection<Document> utilityItemCollection;
    static MongoCollection<Document> volunteerTaskCollection;
    static MongoCollection<Document> volunteerCollection;

    public Database() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
        if (instance == null) {
            mongoClient = new MongoClient("localhost", 27017);
            instance = mongoClient.getDatabase("animal-shelter");
        }
        
        trainingCollection = instance.getCollection("Training");
        observerCollection = instance.getCollection("Observer");
        accountCollection = instance.getCollection("Account");
        userCollection = instance.getCollection("User");
        employeeCollection = instance.getCollection("Employee");
        sellingItemCollection = instance.getCollection("SellingItem");
        utilityItemCollection = instance.getCollection("UtilityItem");
        volunteerTaskCollection = instance.getCollection("VolunteerTask");
        volunteerCollection = instance.getCollection("Volunteer");
    }
    
    public void close() {
        mongoClient.close();
    }
    
    // Training methods
    public static void uploadTrainingVideo(Training training) {
        trainingCollection.insertOne(Document.parse(gson.toJson(training)));
    }
    
    // returns true if the training video was removed successfully
    public static void removeTrainingVideo(Training training) {
        trainingCollection.deleteOne(Filters.eq("ID", training.getID()));
    }
    
    public static ArrayList<Observer> getAllObservers() {
        ArrayList<Observer> observers = new ArrayList<>();
        for (Document document : observerCollection.find()) {
            observers.add(gson.fromJson(document.toJson(), Observer.class));
        }
        return observers;
    }
    
    public static Training getTrainingVideo(int ID) {
        Document document = trainingCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), Training.class);
    }
    
    public static ArrayList<Training> getAllTrainingVideos() {
        ArrayList<Training> trainingVideos = new ArrayList<>();
        for (Document document : trainingCollection.find()) {
            trainingVideos.add(gson.fromJson(document.toJson(), Training.class));
        }
        return trainingVideos;
    }
    
    public static void addObserver(Observer observer) {
        User user = (User) observer;
        Document document = new Document("ID", user.getID());
        observerCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static void removeObserver(Observer observer) {
        User user = (User) observer;
        observerCollection.deleteOne(Filters.eq("ID", user.getID()));
    }
    
    // User methods
    public static void signUp(User user) {
        userCollection.insertOne(Document.parse(gson.toJson(user)));
    }
    
    public static void addNotification(String message) {
        Document document = new Document("notification", message);
        observerCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    // Account methods
    private static int getIDOfAccount(String username, String password) {
        Document document = accountCollection.find(Filters.and(Filters.eq("username", username),
                Filters.eq("password", password))).first();
        if (document == null) {
            return -1;
        }
        return document.getInteger("ID");
    }
    
    public static User userLogin(String username, String password) {
        int ID = getIDOfAccount(username, password);
        if (ID == -1) {
            return null;
        }
        
        Document document = userCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), User.class);
    }
    
    public static Employee empLogin(String username, String password) {
        int ID = getIDOfAccount(username, password);
        if (ID == -1) {
            return null;
        }
        
        Document document = employeeCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), Employee.class);
    }
    
    public static Volunteer volunteerLogin(String username, String password) {
        int ID = getIDOfAccount(username, password);
        if (ID == -1) {
            return null;
        }
        // TODO: change to volunteer collection
        Document document = employeeCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), Volunteer.class);
    }
    
    public static void updateUserAccount(User user, String username, String password) {
        Document document = new Document("username", username).append("password", password);
        Document updateOperation = new Document("$set", document);
        
        userCollection.updateOne(Filters.eq("ID", user.getID()), updateOperation);
    }
    
    
    public static void updateSpecialisedAccount(Specialised specialised, String username, String password) {
        Document document = new Document("ID", specialised.getID())
                .append("username", username)
                .append("password", password);
        Document updateOperation = new Document("$set", document);
        
        employeeCollection.updateOne(Filters.eq("ID", specialised.getID()), updateOperation);
    }
    
    // Selling item methods
    public static void addSellingItem(SellingItem item) {
        // if item already exists
        Document document = sellingItemCollection.find(Filters.eq("itemName", item.getItemName())).first();
        if (document != null) {
            // add the quantity of the current item with the new item
            SellingItem existingItem = gson.fromJson(document.toJson(), SellingItem.class);
            int existingQuantity = existingItem.getQuantity();
            int newQuantity = existingQuantity + item.getQuantity();
            sellingItemCollection.updateOne(Filters.eq("itemName", item.getItemName()),
                    Updates.set("quantity", newQuantity));
            return;
        }
        
        // if new item
        sellingItemCollection.insertOne(Document.parse(gson.toJson(item)));
    }
    
    public static void removeSellingItem(Item item) {
        sellingItemCollection.deleteOne(Filters.eq("ID", item.getID()));
    }
    
    public static SellingItem viewSellingItem(int ID) {
        Document document = sellingItemCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), SellingItem.class);
    }
    
    public static ArrayList<SellingItem> viewAllSellingItems() {
        ArrayList<SellingItem> sellingItems = new ArrayList<>();
        for (Document document : sellingItemCollection.find()) {
            sellingItems.add(gson.fromJson(document.toJson(), SellingItem.class));
        }
        return sellingItems;
    }
    
    // Utility item methods
    public static void addUtilityItem(UtilityItem item) {
        // if item already exists
        Document document = utilityItemCollection.find(Filters.eq("itemName", item.getItemName())).first();
        if (document != null) {
            // add the quantity of the current item with the new item
            UtilityItem existingItem = gson.fromJson(document.toJson(), UtilityItem.class);
            int existingQuantity = existingItem.getQuantity();
            int newQuantity = existingQuantity + item.getQuantity();
            utilityItemCollection.updateOne(Filters.eq("itemName", item.getItemName()),
                    Updates.set("quantity", newQuantity));
            return;
        }
        
        // if new item
        utilityItemCollection.insertOne(Document.parse(gson.toJson(item)));
    }
    
    public static void removeUtilityItem(Item item) {
        utilityItemCollection.deleteOne(Filters.eq("ID", item.getID()));
    }
    
    public static UtilityItem viewUtilityItem(int ID) {
        Document document = utilityItemCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), UtilityItem.class);
    }
    
    public static ArrayList<UtilityItem> viewAllUtilityItems() {
        ArrayList<UtilityItem> utilityItems = new ArrayList<>();
        for (Document document : utilityItemCollection.find()) {
            utilityItems.add(gson.fromJson(document.toJson(), UtilityItem.class));
        }
        return utilityItems;
    }
    
    // InStock methods
    public static void buyItem(int ID, int quantityNeeded) {
        Document document = sellingItemCollection.find(Filters.eq("ID", ID)).first();
        SellingItem item = gson.fromJson(document.toJson(), SellingItem.class);
        
        Document updatedDocument = new Document("ID", item.getID())
                .append("itemName", item.getItemName())
                .append("quality", item.getQuantity() - quantityNeeded)
                .append("type", item.getType())
                .append("price", item.getPrice());
        Document updateOperation = new Document("$set", updatedDocument);
        
        sellingItemCollection.updateOne(Filters.eq("ID", item.getID()), updateOperation);
    }

    // VolunteerTask Class functions
    public static void addVolunteerTask(VolunteerTask task) {
        Document document = Document.parse(gson.toJson(task));
        volunteerTaskCollection.insertOne(document);
    }

    public static void removeVolunteerTask(int taskID) {
        volunteerTaskCollection.deleteOne(Filters.eq("ID", taskID));
    }

    public static VolunteerTask viewVolunteerTask(int taskID) {
        Document task = volunteerTaskCollection.find(Filters.eq("ID", taskID)).first();

        if (task != null) {
            String json = task.toJson();
            Gson gson = new Gson();
            return gson.fromJson(json, VolunteerTask.class);
        }

        return null;
    }

    // add this to the class diagram
    public static ArrayList<VolunteerTask> viewAllVolunteerTask() {
        ArrayList<VolunteerTask> allTasks = new ArrayList();
        for (Document taskDoc : volunteerTaskCollection.find()) {
            String json = taskDoc.toJson();
            VolunteerTask task = gson.fromJson(json, VolunteerTask.class);
            allTasks.add(task);
        }
        return allTasks;
    }

    public static void recordTaskCompletion(int volenteerID) {
        volunteerTaskCollection.updateOne(Filters.eq("ID", volenteerID), Updates.set("completionStatus", true));
    }

    // Volunteer Class functions
    public static void signUpToVolunteering(Volunteer vol) {
        Document document = Document.parse(gson.toJson(vol));
        volunteerCollection.insertOne(document);

        Document document1 = Document.parse(gson.toJson(vol.getAccount()));
        accountCollection.insertOne(document1);
    }

    public static void removeVolunteer(int volunteerID) {
        volunteerCollection.deleteOne(Filters.eq("ID", volunteerID));
    }

    public static void assignVolunteer(int taskID, int volunteerID) {
        volunteerTaskCollection.updateOne(
                Filters.eq("ID", taskID),
                Updates.set("assignedVolunteer", volunteerID));
    }
}
