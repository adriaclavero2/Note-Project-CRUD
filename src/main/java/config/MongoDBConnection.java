package config;

import io.github.cdimascio.dotenv.Dotenv; // 📚 Importante importar la librería
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoClient mongoClient = null;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            // 1. Cargamos el archivo .env
            Dotenv dotenv = Dotenv.load();

            // 2. Leemos las variables
            String user     = dotenv.get("MONGO_USER");
            String password = dotenv.get("MONGO_PASSWORD");
            String host     = dotenv.get("MONGO_HOST");
            String port     = dotenv.get("MONGO_PORT");
            String dbName   = dotenv.get("MONGO_DB");

            // 3. Montamos la URI completa
            String uri = "mongodb://" + user + ":" + password + "@" + host + ":" + port;

            // 4. Creamos el cliente usando esa URI
            mongoClient = MongoClients.create(uri);
            System.out.println("✅ Conectado a MongoDB con éxito");
        }

        // Retornamos la base de datos específica
        return mongoClient.getDatabase(Dotenv.load().get("MONGO_DB"));
    }
}