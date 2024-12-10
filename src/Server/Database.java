package Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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
    private static final MongoCollection<Document> trainingCollection = instance.getCollection("Training");
    private static final MongoCollection<Document> observerCollection = instance.getCollection("Observer");
    private static final MongoCollection<Document> accountCollection = instance.getCollection("Account");
    private static final MongoCollection<Document> userCollection = instance.getCollection("User");
    private static final MongoCollection<Document> employeeCollection = instance.getCollection("Employee");
    private static final MongoCollection<Document> sellingItemCollection = instance.getCollection("SellingItem");
    private static final MongoCollection<Document> utilityItemCollection = instance.getCollection("UtilityItem");
    
    
    public Database() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
        if (instance == null) {
            mongoClient = new MongoClient("localhost", 27017);
            instance = mongoClient.getDatabase("animal-shelter");
        }
    }
    
    public void close() {
        mongoClient.close();
    }
    
    // Training methods
    public static void uploadTrainingVideo(Training training) {
        Document document = new Document("ID", training.getID())
                .append("url", training.getUrl())
                .append("uploadedDate", training.getUploadedDate().toString())
                .append("runtime", training.getRuntime())
                .append("description", training.getDescription());
        
        trainingCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    // returns true if the training video was removed successfully
    public static boolean removeTrainingVideo(Training training) {
        return trainingCollection.deleteOne(Filters.eq("ID", training.getID())).wasAcknowledged();
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
        Document document = new Document("ID", user.getID())
                .append("username", username)
                .append("password", password);
        userCollection.updateOne(Filters.eq("ID", user.getID()), Document.parse(gson.toJson(document)));
    }
    
    public static void updateSpecialisedAccount(Specialised specialised, String username, String password) {
        Document document = new Document("ID", specialised.getID())
                .append("username", username)
                .append("password", password);
        employeeCollection.updateOne(Filters.eq("ID", specialised.getID()), Document.parse(gson.toJson(document)));
    }
    
    // Selling item methods
    public static void addSellingItem(SellingItem item) {
        Document document = new Document("ID", item.getID())
                .append("itemName", item.getItemName())
                .append("quality", item.getQuantity())
                .append("type", item.getType())
                .append("price", item.getPrice());
        
        sellingItemCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static boolean removeSellingItem(Item item) {
        return sellingItemCollection.deleteOne(Filters.eq("ID", item.getID())).wasAcknowledged();
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
        Document document = new Document("ID", item.getID())
                .append("itemName", item.getItemName())
                .append("quality", item.getQuantity())
                .append("type", item.getType())
                .append("restockThreshold", item.getRestockThreshold());
        
        utilityItemCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static boolean removeUtilityItem(Item item) {
        return utilityItemCollection.deleteOne(Filters.eq("ID", item.getID())).wasAcknowledged();
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
        
        sellingItemCollection.updateOne(Filters.eq("ID", item.getID()), Document.parse(gson.toJson(updatedDocument)));
    }
}
