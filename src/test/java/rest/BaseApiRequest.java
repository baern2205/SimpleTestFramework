package rest;

import io.restassured.specification.RequestSpecification;
import lombok.Getter;

@Getter
public class BaseApiRequest {

    public RestAssuredClient client = new RestAssuredClient();

    public RequestSpecification given() {
        return client.given().log().all(true);
    }
}
