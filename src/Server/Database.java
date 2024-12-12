package Server;

import RMI.Observer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.Doc;

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
    private static MongoCollection<Document> volunteerTaskCollection;
    private static MongoCollection<Document> volunteerCollection;
    private static MongoCollection<Document> requestCollection;
    private static MongoCollection<Document> doctorCollection;
    private static MongoCollection<Document> courierCollection;
    private static MongoCollection<Document> subscriptionCollection;
    static MongoCollection<Document> animalCollection;
    static MongoCollection<Document> animal_UserCollection;
    static MongoCollection<Document> bookingCollection;
    
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
        requestCollection = instance.getCollection("Request");
        doctorCollection = instance.getCollection("Doctor");
        courierCollection = instance.getCollection("Courier");
        subscriptionCollection = instance.getCollection("Subscription");
        animalCollection = instance.getCollection("Animal");
        animal_UserCollection = instance.getCollection("Animal_User");
        bookingCollection = instance.getCollection("Booking");
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


    // Animnal database functions
    public static void registerAnimal(Animal animal) {
        Document document = Document.parse(gson.toJson(animal));
        animalCollection.insertOne(document);
    }
    
    public static void removeAnimal(int animalID) {
        animalCollection.deleteOne(Filters.eq("ID", animalID));
    }
    
    public static Animal viewAnimal(Animal animal) {
        Document animalDoc = animalCollection.find(Filters.eq("ID", animal.getID())).first();

        if (animalDoc != null) {
            String json = animalDoc.toJson();
            return gson.fromJson(json, Animal.class);
        }

        return null;
    }
    
    // this function retrieves all animals. will be used by the admin
    public static ArrayList<Animal> viewAllAnimals() {
        ArrayList<Animal> allAnimals = new ArrayList();
        for (Document animalDoc : animalCollection.find()) {
            String json = animalDoc.toJson();
            Animal animal = gson.fromJson(json, Animal.class);
            allAnimals.add(animal);
        }
        return allAnimals;
    }

    //if the animalStatus is "adopted" return animals that are not adopted bas
    //if the animalStatus is "fostered" or "sponsored" return animals that are not fostered or adopted

    public static ArrayList<Animal> viewAllConditionedAnimals(String animalStatus) {
        ArrayList<Animal> allAnimals = new ArrayList();
        FindIterable<Document> animalDocs = animalCollection.find(Filters.eq("adopted", false));
        
        if (animalStatus == "fostered" || animalStatus == "sponsored") {
            animalDocs= animalCollection.find(Filters.and(Filters.eq("adopted", false), Filters.eq("fostered", false)));
        }

        for (Document animalDoc : animalDocs) {
            String json = animalDoc.toJson();
            Animal animal = gson.fromJson(json, Animal.class);
            allAnimals.add(animal);
        }
        return allAnimals;
    }

   
    public static void recordFeeding(Animal animal) {
        animalCollection.updateOne(Filters.eq("ID", animal.getID()),
                Updates.set("lastFeedingTime", LocalDateTime.now().toString()));
    }
    
    public static void adoptAnimal(Animal animal, User user) {
        animalCollection.updateOne(Filters.eq("ID", animal.getID()), Updates.set("adopted", true));
        Document document = new Document("animalID", animal.getID()).append("userID", user.getID())
                .append("relationshipType", "adopted");
        animal_UserCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static void fosterAnimal(Animal animal, User user) {
        animalCollection.updateOne(Filters.eq("ID", animal.getID()), Updates.set("fostered", true));
        Document document = new Document("animalID", animal.getID()).append("userID", user.getID())
                .append("relationshipType", "fostered");
        animal_UserCollection.insertOne(Document.parse(gson.toJson(document)));
   
    }
    
    public static void sponsorAnimal(Animal animal, User user) {
        animalCollection.updateOne(Filters.eq("ID", animal.getID()), Updates.set("sponsored", true));
        Document document = new Document("animalID", animal.getID()).append("userID", user.getID())
                .append("relationshipType", "sponsored");
        animal_UserCollection.insertOne(Document.parse(gson.toJson(document)));

    }

    // Booking functions 
    public static void createBooking(Booking booking) {
        Document document = Document.parse(gson.toJson(booking));
        bookingCollection.insertOne(document);

    }

    public static void cancleBooking(int bookingID) {
        bookingCollection.deleteOne(Filters.eq("bookingID", bookingID));
    }
    
    public static Booking viewBooking(int bookingID) {
        Document bookingDoc = bookingCollection.find(Filters.eq("bookingID", bookingID)).first();

        if (bookingDoc != null) {
            String json = bookingDoc.toJson();
            return gson.fromJson(json, Booking.class);
        }

        return null;
    }

    public static ArrayList<Booking> viewAllBookings() {
        ArrayList<Booking> allBookings = new ArrayList();
        for (Document bookingDoc : bookingCollection.find()) {
            String json = bookingDoc.toJson();
            Booking booking = gson.fromJson(json, Booking.class);
            allBookings.add(booking);
        }
        return allBookings;
    }

    
}
    
    
    //-----------------REQUEST CLASS---------------------------//
    //DONE
    public static void addRequest(Request request) {
        Document document = new Document("ID", request.getID())
                .append("ID", request.getID())
                .append("userID", request.getuserID())
                .append("userName", request.getuserName())
                .append("location", request.getLocation())
                .append("date", request.getDate().toString());
        
        MongoCollection<Document> collection = instance.getCollection("Request");
        collection.insertOne(document);
    }
    
    //DONE
    public static ArrayList<Request> viewRequest(Courier courier) {
        ArrayList<Request> result = new ArrayList();
        MongoCollection<Document> collection = instance.getCollection("Request");
        ArrayList<Document> docs = collection.find(Filters.eq("location", courier.getAssignedLocation())).into(new ArrayList<Document>());
        for (Document document : docs) {
            result.add(gson.fromJson(document.toJson(), Request.class));
        }
        return result;
    }
    
    //DONE
    public static void deleteRequest(Request request) {
        MongoCollection<Document> collection = instance.getCollection("Request");
        collection.deleteOne(Filters.eq("ID", request.getID()));
    }
    
    //-----------Courier Class---------//
    //DONE
    public static void addCourier(Courier courier) {
        Document document = new Document("ID", courier.getID())
                .append("ID", courier.getID())
                .append("name", courier.getName())
                .append("age", courier.getAge())
                .append("gender", courier.getGender())
                .append("email", courier.getEmail())
                .append("phoneNumber", courier.getPhoneNumber())
                .append("address", courier.getAddress())
                .append("salary", courier.getSalary())
                .append("maxCapacity", Courier.getMaxCapacity())
                .append("assignedLocation", courier.getAssignedLocation())
                .append("numberOfRequests", courier.getNumberOfRequests());
        
        MongoCollection<Document> collection = instance.getCollection("Courier");
        collection.insertOne(document);
    }
    
    //DONE
    public static Courier getAssignedCourier(String location) {
        MongoCollection<Document> collection = instance.getCollection("Courier");
        Document doc = collection.find(Filters.eq("assignedLocation", location)).first();
        Courier cour = gson.fromJson(doc.toJson(), Courier.class);
        return cour;
    }
    
    //DONE
    public static void updateCourierRequestNumber(Courier cour, int numOfRequests) {
        MongoCollection<Document> collection = instance.getCollection("Courier");
        collection.updateOne(Filters.eq("ID", cour.getID()), Updates.set("numberOfRequests", numOfRequests));
    }
    
    public static void deleteCourier(Courier courier) {
        MongoCollection<Document> collection = instance.getCollection("Courier");
        collection.deleteOne(Filters.eq("ID", courier.getID()));
    }
    
    
    //---------------USER--------------//
    public static void addUser(User user) {
        Document document = new Document("ID", user.getID())
                .append("ID", user.getID())
                .append("name", user.getName())
                .append("phoneNumber", user.getPhoneNumber())
                .append("address", user.getAddress())
                .append("outstandingFees", user.getOutstandingFees());
        
        MongoCollection<Document> collection = instance.getCollection("User");
        collection.insertOne(document);
    }
    
    public static User getUserByID(int userID) {
        MongoCollection<Document> collection = instance.getCollection("User");
        Document document = collection.find(Filters.eq("ID", userID)).first();
        User user = gson.fromJson(document.toJson(), User.class);
        return user;
    }
    
    public static void updateUserOutstandingFees(User user, float outstandingFees) {
        MongoCollection<Document> collection = instance.getCollection("User");
        collection.updateOne(Filters.eq("ID", user.getID()), Updates.set("outstandingFees", outstandingFees));
    }
    
    
    //-----------DOCTOR---------------//
    public static void addDoctor(Doctor doctor) {
        Document document = new Document("ID", doctor.getID())
                .append("ID", doctor.getID())
                .append("name", doctor.getName())
                .append("age", doctor.getAge())
                .append("gender", doctor.getGender())
                .append("email", doctor.getEmail())
                .append("phoneNumber", doctor.getPhoneNumber())
                .append("address", doctor.getAddress())
                .append("salary", doctor.getSalary());
        
        MongoCollection<Document> collection = instance.getCollection("Doctor");
        collection.insertOne(document);
        
    }
    
    public static Doctor getDoctorByID(int doctorID) {
        MongoCollection<Document> collection = instance.getCollection("Doctor");
        Document document = collection.find(Filters.eq("ID", doctorID)).first();
        Doctor doctor = gson.fromJson(document.toJson(), Doctor.class);
        return doctor;
    }
    
    public static void deleteDoctor(Doctor doctor) {
        MongoCollection<Document> collection = instance.getCollection("Doctor");
        collection.deleteOne(Filters.eq("ID", doctor.getID()));
    }
    
    public static ArrayList<Appointment> viewDoctorAppointments(int doctorID) {
        ArrayList<Appointment> appointments = new ArrayList();
        MongoCollection<Document> collection = instance.getCollection("Appointments");
        ArrayList<Document> docs = collection.find(Filters.eq("doctorID", doctorID)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            appointments.add(gson.fromJson(jsonResult, Appointment.class));
        }
        return appointments;
    }
    
    //-----------APPOINTMENT--------------//
    public static void addAppointment(Appointment appointment) {
        Document document = new Document("ID", appointment.getID())
                .append("ID", appointment.getID())
                .append("date", appointment.getDate().toString())
                .append("doctorID", appointment.getAssignedDoctor().getID())
                .append("price", appointment.getPrice())
                .append("description", appointment.getDescription())
                .append("animalID", appointment.getAnimal().getID());
        
        MongoCollection<Document> collection = instance.getCollection("Appointments");
        collection.insertOne(document);
    }
    
    public static void deleteAppointment(Appointment appointment) {
        MongoCollection<Document> collection = instance.getCollection("Appointments");
        collection.deleteOne(Filters.eq("ID", appointment.getID()));
    }
    
    
    public static Appointment viewAppointmentById(int appointmentID) {
        MongoCollection<Document> collection = instance.getCollection("Appointments");
        Document document = collection.find(Filters.eq("ID", appointmentID)).first();
        Appointment appointment = gson.fromJson(document.toJson(), Appointment.class);
        return appointment;
    }
    
    public static void updateAppointmentDescription(Appointment appointment, String description) {
        MongoCollection<Document> collection = instance.getCollection("Appointments");
        collection.updateOne(Filters.eq("ID", appointment.getID()), Updates.set("description", description));
    }
    
    public static void addSubscription(Subscription subscription, User user) {
        subscriptionCollection.insertOne(Document.parse(gson.toJson(subscription)));
        userCollection.updateOne(Filters.eq("ID", user.getID()), Updates.set("subscription", subscription));
    }
    
    public static void removeSubscription(Subscription subscription, User user) {
        subscriptionCollection.deleteOne(Filters.eq("ID", subscription.getID()));
        userCollection.updateOne(Filters.eq("ID", user.getID()), Updates.set("subscription", null));
    }
    
    // might change, actually might not be needed
    public static Subscription getSubscriptionByID(int subscriptionID) {
        MongoCollection<Document> collection = instance.getCollection("Subscription");
        Document document = collection.find(Filters.eq("ID", subscriptionID)).first();
        Subscription subscription = gson.fromJson(document.toJson(), Subscription.class);
        return subscription;
    }
}

