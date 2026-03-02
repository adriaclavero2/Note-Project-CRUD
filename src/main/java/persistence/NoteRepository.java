package persistence;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoDBConnection;
import model.Note;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class NoteRepository {
    private final MongoCollection<Note> collection;

    public NoteRepository() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        MongoDatabase database = MongoDBConnection.getDatabase()
                .withCodecRegistry(pojoCodecRegistry);

        this.collection = database.getCollection("notes", Note.class);
    }
    public void save(Note note) {
        collection.insertOne(note);
    }

    public List<Note> findAll() {
        return collection.find().into(new ArrayList<>());
    }

    public void deleteByTitle(String title) {
        collection.deleteOne(new Document("title", title));
    }
}
