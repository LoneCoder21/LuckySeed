package name.luckyseed.luckyseed1_16_1;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistentWriter {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final PersistentWriter GLOBAL_WRITER;

    public static void init() {
    }

    static {
        try {
            GLOBAL_WRITER = new PersistentWriter("config/LuckySeedConfig.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final File file;
    private final JsonObject local;

    public PersistentWriter(String fileName) throws IOException {
        this.file = this.create(fileName);
        this.local = this.getJSON();
    }

    private File create(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file;
    }

    public void write() {
        try {
            FileWriter writer = new FileWriter(this.file);

            writer.write(GSON.toJson(this.local));
            writer.flush();
            writer.close();


        } catch (IOException ignored) {

        }
    }

    public JsonObject getJSON() throws IOException {
        if (this.local != null) {
            return this.local;
        }

        FileReader reader = new FileReader(this.file);
        JsonParser parser = new JsonParser();

        Object obj = parser.parse(reader);
        reader.close();

        return obj == null || obj.equals(JsonNull.INSTANCE) ? new JsonObject() : (JsonObject) obj;
    }

    public void put(String element, JsonElement obj) {
        this.local.add(element, obj);
    }

    public double getDoubleValue(String key, double def) {
        if (!this.local.has(key)) {
            this.put(key, new JsonPrimitive(def));
            return def;
        }
        return this.local.get(key).getAsDouble();
    }

    public boolean getBoolValue(String key, boolean def) {
        if (!this.local.has(key)) {
            this.put(key, new JsonPrimitive(def));
            return def;
        }

        return this.local.get(key).getAsBoolean();
    }
}
