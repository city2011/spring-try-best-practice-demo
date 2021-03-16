package hcity.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;

public class GsonUtil {
    private static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static String serialize(Object src) {
        return gson.toJson(src);
    }

    public static <T> T deserialize(String src, Type type) {
        return gson.fromJson(src, type);
    }

    public static <T> T deserialize(String src, Class<T> type) {
        return gson.fromJson(src, type);
    }

    public static <T> T deserialize(JsonElement src, Type type) {
        return gson.fromJson(src, type);
    }

    public static <T> T deserialize(JsonElement src, Class<T> type) {
        return gson.fromJson(src, type);
    }

    public static JsonElement deserialize(String src) {
        JsonParser parser = new JsonParser();
        return parser.parse(src);
    }

    public static String serialize(JsonElement src) {
        return src.toString();
    }
}
