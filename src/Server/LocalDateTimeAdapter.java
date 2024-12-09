package Server;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class is used to serialize and deserialize LocalDateTime objects to and from JSON.
 */
public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    @Override
    public JsonElement serialize(LocalDateTime localDateTime,
                                 Type type,
                                 JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDateTime.format(formatter)); // "yyyy-MM-dd'T'HH:mm:ss"
    }
    
    @Override
    public LocalDateTime deserialize(JsonElement jsonElement,
                                     Type type,
                                     JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), formatter);
    }
}
