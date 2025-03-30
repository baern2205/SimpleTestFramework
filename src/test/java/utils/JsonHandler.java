package utils;

import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor
public class JsonHandler {

    private static final JSONParser parser = new JSONParser();

    public JSONObject parseJson(String fileName) {
        try (InputStream inputStream = getClass().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + fileName);
            }
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            return (JSONObject) parser.parse(reader);
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
