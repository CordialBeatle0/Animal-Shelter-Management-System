package Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDateTime;
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
}
