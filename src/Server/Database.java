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

public class Database {

    // Static instance variable to hold the single instance of the class
    private static MongoDatabase instance;

    private static final Gson gson = new GsonBuilder()
            // Register the LocalDateAdapter class to handle LocalDateTime objects
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    private MongoClient mongoClient;

    // Collections Creation
    static MongoCollection<Document> volunteerTaskCollection;
    static MongoCollection<Document> volunteerCollection;
    static MongoCollection<Document> accountCollection;

    public Database() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        if (instance == null) {
            mongoClient = new MongoClient("localhost", 27017);
            instance = mongoClient.getDatabase("animal-shelter");
        }

        // Getting the collections
        volunteerTaskCollection = instance.getCollection("VolunteerTask");
        volunteerCollection = instance.getCollection("Volunteer");
        accountCollection = instance.getCollection("Account");
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
