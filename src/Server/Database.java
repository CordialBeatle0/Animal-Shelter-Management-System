package Server;

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

import javax.print.Doc;

public class Database {
    // Static instance variable to hold the single instance of the class
    private static MongoDatabase instance;
    
    private static final Gson gson = new GsonBuilder()
            // Register the LocalDateAdapter class to handle LocalDateTime objects
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();
    
    private MongoClient mongoClient;
    
    public Database() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
        
        if (instance == null) {
            mongoClient = new MongoClient("localhost", 27017);
            instance = mongoClient.getDatabase("animal-shelter");

            //TODO: REMOVE BEFORE PUSH
            instance.createCollection("Request");
            instance.createCollection("Courier");
            instance.createCollection("User");
            instance.createCollection("Doctor");

        }
    }
    
    public void close() {
        mongoClient.close();
    }
    
    public static void uploadTrainingVideo(Training training) {
        Document document = new Document("ID", training.getID())
                .append("url", training.getUrl())
                .append("uploadedDate", training.getUploadedDate().toString())
                .append("runtime", training.getRuntime())
                .append("description", training.getDescription());
        
        MongoCollection<Document> collection = instance.getCollection("Training");
        Document document1 = Document.parse(gson.toJson(training));
        collection.insertOne(document1);
    }



    //-----------------REQUEST CLASS---------------------------//
   //DONE
    public static void addRequest(Request request){
        Document document = new Document("ID",request.getID())
        .append("ID", request.getID())
        .append("userID", request.getuserID())
        .append("userName", request.getuserName())
        .append("location",request.getLocation())
        .append("date", request.getDate().toString());

        MongoCollection<Document> collection = instance.getCollection("Request");
        collection.insertOne(document);
    }

    //DONE
    public static ArrayList<Request> viewRequest(Courier courier){
       ArrayList <Request> result = new ArrayList();
       MongoCollection<Document> collection = instance.getCollection("Request");
       ArrayList<Document> docs = collection.find(Filters.eq("location", courier.getAssignedLocation())).into(new ArrayList<Document>());
       for (Document document : docs) {
        result.add(gson.fromJson(document.toJson(), Request.class));
       }
       return result;
    }

    //DONE
    public static void deleteRequest(Request request){
       MongoCollection<Document> collection = instance.getCollection("Request");
       collection.deleteOne(Filters.eq("ID",request.getID()));
    }

    //-----------Courier Class---------//
    //DONE
    public static void addCourier(Courier courier){
        Document document = new Document("ID",courier.getID())
        .append("ID", courier.getID())
        .append("name", courier.getName())
        .append("age",courier.getAge())
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
    public static Courier getAssignedCourier(String location){
        MongoCollection<Document> collection = instance.getCollection("Courier");
        Document doc = collection.find(Filters.eq("assignedLocation", location)).first();
        Courier cour = gson.fromJson(doc.toJson(), Courier.class);
        return cour;
    }

    //DONE
    public static void updateCourierRequestNumber(Courier cour, int numOfRequests){
        MongoCollection<Document> collection = instance.getCollection("Courier");
        collection.updateOne(Filters.eq("ID", cour.getID()),Updates.set("numberOfRequests", numOfRequests));
    }

    public static void deleteCourier(Courier courier){
        MongoCollection<Document> collection = instance.getCollection("Courier");
        collection.deleteOne(Filters.eq("ID", courier.getID()));
    }
   

    //---------------USER--------------//
    public static void addUser(User user){
        Document document = new Document("ID",user.getID())
        .append("ID", user.getID())
        .append("name", user.getName())
        .append("phoneNumber", user.getPhoneNumber())
        .append("address", user.getAddress())
        .append("outstandingFees", user.getOutstandingFees());

        MongoCollection<Document> collection = instance.getCollection("User");
        collection.insertOne(document);
    }

    public static User getUserByID(int userID){
        MongoCollection<Document> collection = instance.getCollection("User");
        Document document = collection.find(Filters.eq("ID", userID)).first();
        User user = gson.fromJson(document.toJson(), User.class);
        return user;
    }

    public static void updateUserOutstandingFees(User user, float outstandingFees){
        MongoCollection<Document> collection = instance.getCollection("User");
        collection.updateOne(Filters.eq("ID", user.getID()),Updates.set("outstandingFees", outstandingFees));
    }


    //-----------DOCTOR---------------//
    public static void addDoctor(Doctor doctor){
        Document document = new Document("ID",doctor.getID())
        .append("ID", doctor.getID())
        .append("name", doctor.getName())
        .append("age",doctor.getAge())
        .append("gender", doctor.getGender())
        .append("email", doctor.getEmail())
        .append("phoneNumber", doctor.getPhoneNumber())
        .append("address", doctor.getAddress())
        .append("salary", doctor.getSalary());

        MongoCollection<Document> collection = instance.getCollection("Doctor");
        collection.insertOne(document);
    
    }

    public static Doctor getDoctorByID(int doctorID){
        MongoCollection<Document> collection = instance.getCollection("Doctor");
        Document document = collection.find(Filters.eq("ID", doctorID)).first();
        Doctor doctor = gson.fromJson(document.toJson(), Doctor.class);
        return doctor;
    }

    public static void deleteDoctor(Doctor doctor){
        MongoCollection<Document> collection = instance.getCollection("Doctor");
        collection.deleteOne(Filters.eq("ID", doctor.getID()));
    }

    public static ArrayList<Appointment> viewDoctorAppointments(int doctorID){
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
    public static void addAppointment(Appointment appointment){
        Document document = new Document("ID",appointment.getID())
        .append("ID", appointment.getID())
        .append("date", appointment.getDate().toString())
        .append("doctorID", appointment.getAssignedDoctor().getID())
        .append("price", appointment.getPrice())
        .append("description", appointment.getDescription())
        .append("animalID", appointment.getAnimal().getID());

        MongoCollection<Document> collection = instance.getCollection("Appointments");
        collection.insertOne(document);
    }

    public static void deleteAppointment(Appointment appointment){
        MongoCollection<Document> collection = instance.getCollection("Appointments");
        collection.deleteOne(Filters.eq("ID", appointment.getID()));
    }


    public static Appointment viewAppointmentById(int appointmentID){
        MongoCollection<Document> collection = instance.getCollection("Appointments");
        Document document = collection.find(Filters.eq("ID", appointmentID)).first();
        Appointment appointment = gson.fromJson(document.toJson(), Appointment.class);
        return appointment;
    }

    public static void updateAppointmentDescription(Appointment appointment, String description){
        MongoCollection<Document> collection = instance.getCollection("Appointments");
        collection.updateOne(Filters.eq("ID", appointment.getID()),Updates.set("description", description));
    }
}

