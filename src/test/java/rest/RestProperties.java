package rest;

import lombok.Getter;

import java.net.URI;
import org.json.simple.JSONObject;
import utils.JsonHandler;

@Getter
public class RestProperties {

    public RestProperties() {
        JSONObject jsonObject = new JsonHandler().parseJson("/data.txt");
        baseUri = (String) jsonObject.get("base_url");
        System.out.println(baseUri);
    }

    private final String baseUri;

}
