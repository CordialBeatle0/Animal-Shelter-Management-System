package Server;

import RMI.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
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
    private static MongoCollection<Document> volunteerTaskCollection;
    private static MongoCollection<Document> volunteerCollection;
    private static MongoCollection<Document> requestCollection;
    private static MongoCollection<Document> doctorCollection;
    private static MongoCollection<Document> courierCollection;
    private static MongoCollection<Document> subscriptionCollection;
    private static MongoCollection<Document> animalCollection;
    private static MongoCollection<Document> animal_UserCollection;
    private static MongoCollection<Document> bookingCollection;
    private static MongoCollection<Document> appointmentCollection;
    private static MongoCollection<Document> primaryKeysCollection;
    
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
        appointmentCollection = instance.getCollection("Appointment");
        primaryKeysCollection = instance.getCollection("PrimaryKeys");
    }
    
    public void close() {
        mongoClient.close();
    }
    
    private static void setPrimaryKeyTo0(String collectionName) {
        Document document = new Document("collectionName", collectionName).append("primaryKey", 0);
        primaryKeysCollection.insertOne(document);
    }
    
    private static int getPrimaryKey(String collectionName) {
        Document document = primaryKeysCollection.find(Filters.eq("collectionName", collectionName)).first();
        if (document == null) {
            setPrimaryKeyTo0(collectionName);
            return 0;
        }
        return document.getInteger("primaryKey");
    }
    
    // Training methods
    public static void uploadTrainingVideo(Training training) {
        training.setID(getPrimaryKey("Training"));
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
    
    public static TrainingDTO viewTrainingVideo(int ID) {
        Document document = trainingCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), TrainingDTO.class);
    }
    
    public static ArrayList<TrainingDTO> getAllTrainingVideos() {
        ArrayList<TrainingDTO> trainingVideos = new ArrayList<>();
        for (Document document : trainingCollection.find()) {
            trainingVideos.add(gson.fromJson(document.toJson(), TrainingDTO.class));
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
        user.setID(getPrimaryKey("User"));
        
        Document document = new Document("ID", user.getID())
                .append("name", user.getName())
                .append("account", user.getID()) // account ID = user ID
                .append("phoneNumber", user.getPhoneNumber())
                .append("address", user.getAddress())
                .append("paymentType", user.getPaymentType().getClass().getName().split("\\.")[1])
                .append("subscription", Document.parse(gson.toJson(user.getSubscription())))
                .append("trainingVideos", Document.parse(gson.toJson(user.getTrainingVideos())));
        userCollection.insertOne(Document.parse(gson.toJson(document)));
        
        Document document1 = new Document("ID", user.getID())
                .append("username", user.getAccount().getUsername())
                .append("password", user.getAccount().getPassword());
        accountCollection.insertOne(Document.parse(gson.toJson(document1)));
    }
    
    public static void addNotification(int ID, String message) {
        Document document = new Document("ID", ID).append("message", message);
        userCollection.updateOne(Filters.eq("ID", ID), Updates.addToSet("notification", document));
    }
    
    public static void removeNotification(int ID) {
        userCollection.updateOne(Filters.eq("ID", ID), Updates.set("notification", new ArrayList<>()));
    }
    
    public static ArrayList<String> getNotifications(int ID) {
        ArrayList<String> notifications = new ArrayList<>();
        for (Document document : userCollection.find(Filters.eq("ID", ID))) {
            notifications.add(document.getString("notification"));
        }
        return notifications;
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
    
    public static UserDTO userLogin(String username, String password) {
        int ID = getIDOfAccount(username, password);
        if (ID == -1) {
            return null;
        }
        
        Document document = userCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), UserDTO.class);
    }
    
    public static EmployeeDTO empLogin(String username, String password) {
        int ID = getIDOfAccount(username, password);
        if (ID == -1) {
            return null;
        }
        
        Document document = employeeCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), EmployeeDTO.class);
    }
    
    public static VolunteerDTO volunteerLogin(String username, String password) {
        int ID = getIDOfAccount(username, password);
        if (ID == -1) {
            return null;
        }
        
        Document document = volunteerCollection.find(Filters.eq("ID", ID)).first();
        if (document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), VolunteerDTO.class);
    }
    
    public static void updateUserAccount(UserDTO user, String username, String password) {
        Document document = new Document("username", username).append("password", password);
        Document updateOperation = new Document("$set", document);
        
        userCollection.updateOne(Filters.eq("ID", user.getID()), updateOperation);
        accountCollection.updateOne(Filters.eq("ID", user.getAccount().getID()), updateOperation);
    }
    
    
    public static void updateSpecialisedAccount(int specialisedID, String username, String password) {
        Document document = new Document("ID", specialisedID)
                .append("username", username)
                .append("password", password);
        Document updateOperation = new Document("$set", document);
        
        employeeCollection.updateOne(Filters.eq("ID", specialisedID), updateOperation);
        accountCollection.updateOne(Filters.eq("ID", specialisedID), updateOperation);
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
        item.setID(getPrimaryKey("SellingItem"));
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
    public static void addUtilityItem(UtilityItemDTO item) {
        // if item already exists
        Document document = utilityItemCollection.find(Filters.eq("itemName", item.getName())).first();
        if (document != null) {
            // add the quantity of the current item with the new item
            UtilityItem existingItem = gson.fromJson(document.toJson(), UtilityItem.class);
            int existingQuantity = existingItem.getQuantity();
            int newQuantity = existingQuantity + item.getQuantity();
            utilityItemCollection.updateOne(Filters.eq("itemName", item.getName()),
                    Updates.set("quantity", newQuantity));
            return;
        }
        
        // if new item
        item.setID(getPrimaryKey("UtilityItem"));
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
    
    public static ArrayList<UtilityItemDTO> viewAllUtilityItems() {
        ArrayList<UtilityItemDTO> utilityItems = new ArrayList<>();
        for (Document document : utilityItemCollection.find()) {
            utilityItems.add(gson.fromJson(document.toJson(), UtilityItemDTO.class));
        }
        return utilityItems;
    }
    
    // InStock methods
    public static void buyItem(int ID, int quantityNeeded) {
        Document document = sellingItemCollection.find(Filters.eq("ID", ID)).first();
        SellingItem item = gson.fromJson(document.toJson(), SellingItem.class);
        
        Document updatedDocument = new Document("quality", item.getQuantity() - quantityNeeded);
        Document updateOperation = new Document("$set", updatedDocument);
        
        sellingItemCollection.updateOne(Filters.eq("ID", item.getID()), updateOperation);
    }
    
    // VolunteerTask Class functions
    public static void addVolunteerTask(VolunteerTask task) {
        task.setID(getPrimaryKey("VolunteerTask"));
        Document document = Document.parse(gson.toJson(task));
        volunteerTaskCollection.insertOne(document);
    }
    
    public static void removeVolunteerTask(int taskID) {
        volunteerTaskCollection.deleteOne(Filters.eq("ID", taskID));
    }
    
    public static VolunteerTaskDTO viewVolunteerTask(int taskID) {
        Document task = volunteerTaskCollection.find(Filters.eq("ID", taskID)).first();
        
        if (task != null) {
            String json = task.toJson();
            return gson.fromJson(json, VolunteerTaskDTO.class);
        }
        
        return null;
    }
    
    // add this to the class diagram
    public static ArrayList<VolunteerTask> viewAllVolunteerTask() {
        ArrayList<VolunteerTask> allTasks = new ArrayList<>();
        for (Document taskDoc : volunteerTaskCollection.find()) {
            String json = taskDoc.toJson();
            VolunteerTask task = gson.fromJson(json, VolunteerTask.class);
            allTasks.add(task);
        }
        return allTasks;
    }
    
    // add this to the class diagram
    public static ArrayList<VolunteerTaskDTO> viewAssignedVolunteerTask(int volunteerID) {
        ArrayList<VolunteerTaskDTO> allMyTasks = new ArrayList<>();
        for (Document taskDoc : volunteerTaskCollection.find(Filters.eq("assignedVolunteer", volunteerID))) {
            String json = taskDoc.toJson();
            VolunteerTaskDTO task = gson.fromJson(json, VolunteerTaskDTO.class);
            allMyTasks.add(task);
        }
        return allMyTasks;
    }
    
    public static void recordTaskCompletion(int volunteerID) {
        volunteerTaskCollection.updateOne(Filters.eq("ID", volunteerID), Updates.set("completionStatus", true));
    }
    
    // Volunteer Class functions
    public static void signUpToVolunteering(Volunteer vol) {
        vol.setID(getPrimaryKey("Volunteer"));
        Document document = Document.parse(gson.toJson(vol));
        volunteerCollection.insertOne(document);
        
        vol.getAccount().setID(vol.getID());
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
    
    // Animal database functions
    public static void registerAnimal(AnimalDTO animal) {
        animal.setID(getPrimaryKey("Animal"));
        Document document = Document.parse(gson.toJson(animal));
        animalCollection.insertOne(document);
    }
    
    public static void removeAnimal(int animalID) {
        animalCollection.deleteOne(Filters.eq("ID", animalID));
    }
    
    public static AnimalDTO viewAnimal(AnimalDTO animal) {
        Document animalDoc = animalCollection.find(Filters.eq("ID", animal.getID())).first();
        
        if (animalDoc != null) {
            String json = animalDoc.toJson();
            return gson.fromJson(json, AnimalDTO.class);
        }
        
        return null;
    }
    
    // this function retrieves all animals. will be used by the admin
    public static ArrayList<AnimalDTO> viewAllAnimals() {
        ArrayList<AnimalDTO> allAnimals = new ArrayList<>();
        for (Document animalDoc : animalCollection.find()) {
            String json = animalDoc.toJson();
            AnimalDTO animal = gson.fromJson(json, AnimalDTO.class);
            allAnimals.add(animal);
        }
        return allAnimals;
    }
    
    // if the animalStatus is "adopted" return animals that are not adopted bas
    // if the animalStatus is "fostered" or "sponsored" return animals that are not fostered or adopted
    public static ArrayList<AnimalDTO> viewAllConditionedAnimals(String animalStatus) {
        ArrayList<AnimalDTO> allAnimals = new ArrayList<>();
        FindIterable<Document> animalDocs = animalCollection.find(Filters.eq("adopted", false));
        
        if (animalStatus.equals("fostered") || animalStatus.equals("sponsored")) {
            animalDocs = animalCollection.find(Filters.and(Filters.eq("adopted", false),
                    Filters.eq("fostered", false)));
        }
        
        for (Document animalDoc : animalDocs) {
            String json = animalDoc.toJson();
            AnimalDTO animal = gson.fromJson(json, AnimalDTO.class);
            allAnimals.add(animal);
        }
        return allAnimals;
    }
    
    
    public static void recordFeeding(AnimalDTO animal) {
        animalCollection.updateOne(Filters.eq("ID", animal.getID()),
                Updates.set("lastFeedingTime", LocalDateTime.now().toString()));
    }
    
    public static void adoptAnimal(AnimalDTO animal, UserDTO user) {
        animalCollection.updateOne(Filters.eq("ID", animal.getID()), Updates.set("adopted", true));
        Document document = new Document("animalID", animal.getID()).append("userID", user.getID())
                .append("relationshipType", "adopted");
        animal_UserCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static void fosterAnimal(AnimalDTO animal, UserDTO user) {
        animalCollection.updateOne(Filters.eq("ID", animal.getID()), Updates.set("fostered", true));
        Document document = new Document("animalID", animal.getID()).append("userID", user.getID())
                .append("relationshipType", "fostered");
        animal_UserCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static void sponsorAnimal(AnimalDTO animal, UserDTO user) {
        animalCollection.updateOne(Filters.eq("ID", animal.getID()), Updates.set("sponsored", true));
        Document document = new Document("animalID", animal.getID()).append("userID", user.getID())
                .append("relationshipType", "sponsored");
        animal_UserCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    // Booking functions 
    public static void createBooking(BookingDTO booking) {
        booking.setBookingID(getPrimaryKey("Booking"));
        Document document = Document.parse(gson.toJson(booking));
        bookingCollection.insertOne(document);
    }
    
    public static void cancelBooking(int bookingID) {
        bookingCollection.deleteOne(Filters.eq("bookingID", bookingID));
    }
    
    public static BookingDTO viewBooking(int bookingID) {
        Document bookingDoc = bookingCollection.find(Filters.eq("bookingID", bookingID)).first();
        
        if (bookingDoc != null) {
            String json = bookingDoc.toJson();
            return gson.fromJson(json, BookingDTO.class);
        }
        
        return null;
    }
    
    public static ArrayList<BookingDTO> viewAllBookings() {
        ArrayList<BookingDTO> allBookings = new ArrayList<>();
        for (Document bookingDoc : bookingCollection.find()) {
            String json = bookingDoc.toJson();
            BookingDTO booking = gson.fromJson(json, BookingDTO.class);
            allBookings.add(booking);
        }
        return allBookings;
    }
    
    //-----------------REQUEST CLASS---------------------------//
    // DONE
    public static void addRequest(RequestDTO request) {
        request.setID(getPrimaryKey("Request"));
        Document document = new Document("ID", request.getID())
                .append("ID", request.getID())
                .append("userID", request.getUserID())
                .append("userName", request.getUserName())
                .append("location", request.getLocation())
                .append("date", request.getDate());
        
        requestCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    // DONE
    public static ArrayList<RequestDTO> viewRequest(CourierDTO courier) {
        ArrayList<RequestDTO> result = new ArrayList<>();
        for (Document animalDoc : requestCollection.find(Filters.eq("location", courier.getAssignedLocation()))) {
            String json = animalDoc.toJson();
            result.add(gson.fromJson(json, RequestDTO.class));
        }
        return result;
    }
    
    // DONE
    public static void deleteRequest(RequestDTO request) {
        requestCollection.deleteOne(Filters.eq("ID", request.getID()));
    }
    
    //-----------Courier Class---------//
    // DONE
    public static void addCourier(Courier courier) {
        courier.setID(getPrimaryKey("Courier"));
        Document document = new Document("ID", courier.getID())
                .append("ID", courier.getID())
                .append("name", courier.getName())
                .append("age", courier.getAge())
                .append("gender", courier.getGender())
                .append("email", courier.getEmail())
                .append("phoneNumber", courier.getPhoneNumber())
                .append("address", courier.getAddress())
                .append("account", courier.getAccount())
                .append("salary", courier.getSalary())
                .append("maxCapacity", Courier.getMaxCapacity())
                .append("assignedLocation", courier.getAssignedLocation())
                .append("numberOfRequests", courier.getNumberOfRequests());
        
        courierCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    // DONE
    public static CourierDTO getAssignedCourier(String location) {
        Document doc = courierCollection.find(Filters.eq("assignedLocation", location)).first();
        return gson.fromJson(doc.toJson(), CourierDTO.class);
    }
    
    // DONE
    public static void updateCourierRequestNumber(CourierDTO cour, int numOfRequests) {
        courierCollection.updateOne(Filters.eq("ID", cour.getID()), Updates.set("numberOfRequests", numOfRequests));
    }
    
    public static void deleteCourier(int courierID) {
        courierCollection.deleteOne(Filters.eq("ID", courierID));
    }
    
    
    //---------------USER--------------//
    public static void addUser(User user) {
        user.setID(getPrimaryKey("User"));
        Document document = new Document("ID", user.getID())
                .append("ID", user.getID())
                .append("name", user.getName())
                .append("phoneNumber", user.getPhoneNumber())
                .append("address", user.getAddress())
                .append("outstandingFees", user.getOutstandingFees());
        
        userCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static User getUserByID(int userID) {
        Document document = userCollection.find(Filters.eq("ID", userID)).first();
        return gson.fromJson(document.toJson(), User.class);
    }
    
    public static void updateUserOutstandingFees(int userID, float outstandingFees) {
        userCollection.updateOne(Filters.eq("ID", userID), Updates.set("outstandingFees", outstandingFees));
    }
    
    //-----------DOCTOR---------------//
    public static void addDoctor(Doctor doctor) {
        doctor.setID(getPrimaryKey("Doctor"));
        Document document = new Document("ID", doctor.getID())
                .append("ID", doctor.getID())
                .append("name", doctor.getName())
                .append("age", doctor.getAge())
                .append("gender", doctor.getGender())
                .append("email", doctor.getEmail())
                .append("phoneNumber", doctor.getPhoneNumber())
                .append("address", doctor.getAddress())
                .append("salary", doctor.getSalary());
        
        doctorCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static Doctor getDoctorByID(int doctorID) {
        Document document = doctorCollection.find(Filters.eq("ID", doctorID)).first();
        return gson.fromJson(document.toJson(), Doctor.class);
    }
    
    public static void deleteDoctor(int doctorID) {
        doctorCollection.deleteOne(Filters.eq("ID", doctorID));
    }
    
    public static ArrayList<AppointmentDTO> viewDoctorAppointments(Doctor doctor) {
        ArrayList<AppointmentDTO> appointments = new ArrayList<>();
        System.out.println(Document.parse(gson.toJson(doctor)));
        for (Document document : appointmentCollection.find(Filters.eq("doctor",
                Document.parse(gson.toJson(doctor))))) {
            String jsonResult = gson.toJson(doctor);
            appointments.add(gson.fromJson(jsonResult, AppointmentDTO.class));
        }
        return appointments;
    }
    
    //-----------APPOINTMENT--------------//
    public static void addAppointment(Appointment appointment) {
        appointment.setID(getPrimaryKey("Appointment"));
        Document document = new Document("ID", appointment.getID())
                .append("ID", appointment.getID())
                .append("date", appointment.getDate().toString())
                .append("doctor", appointment.getDoctor())
                .append("price", appointment.getPrice())
                .append("description", appointment.getDescription())
                .append("animal", appointment.getAnimal());
        
        appointmentCollection.insertOne(Document.parse(gson.toJson(document)));
    }
    
    public static void deleteAppointment(Appointment appointment) {
        appointmentCollection.deleteOne(Filters.eq("ID", appointment.getID()));
    }
    
    
    public static AppointmentDTO viewAppointmentById(int appointmentID) {
        Document document = appointmentCollection.find(Filters.eq("ID", appointmentID)).first();
        AppointmentDTO appointment = gson.fromJson(document.toJson(), AppointmentDTO.class);
        System.out.println(appointmentID);
        return appointment;
    }
    
    public static void updateAppointmentDescription(Appointment appointment, String description) {
        appointmentCollection.updateOne(Filters.eq("ID", appointment.getID()), Updates.set("description", description));
    }
    
    public static void addSubscription(Subscription subscription, UserDTO user) {
        subscription.setID(getPrimaryKey("Subscription"));
        subscriptionCollection.insertOne(Document.parse(gson.toJson(subscription)));
        userCollection.updateOne(Filters.eq("ID", user.getID()), Updates.set("subscription", subscription));
    }
    
    public static void removeSubscription(Subscription subscription, UserDTO user) {
        subscriptionCollection.deleteOne(Filters.eq("ID", subscription.getID()));
        userCollection.updateOne(Filters.eq("ID", user.getID()), Updates.set("subscription.status", false));
    }
    
    // might change, actually might not be needed
    public static Subscription getSubscriptionByID(int subscriptionID) {
        Document document = subscriptionCollection.find(Filters.eq("ID", subscriptionID)).first();
        return gson.fromJson(document.toJson(), Subscription.class);
    }
}

