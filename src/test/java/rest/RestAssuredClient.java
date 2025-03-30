package rest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.concurrent.TimeUnit;

public class RestAssuredClient {

    private static final RestAssuredConfig REST_ASSURED_CONFIG = RestAssuredConfig.config()
            .connectionConfig(ConnectionConfig.connectionConfig().closeIdleConnectionsAfterEachResponseAfter(30, TimeUnit.SECONDS))
            .logConfig(LogConfig.logConfig()
                    .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));

    private static final RequestSpecification BASE_REQUEST_SPEC = new RequestSpecBuilder()
            .build()
            .config(REST_ASSURED_CONFIG);

    private final RestProperties restProperties = new RestProperties();

    /**
     * Base request specification.
     */
    public RequestSpecification given() {
        return RestAssured.given(BASE_REQUEST_SPEC)
                .baseUri(restProperties.getBaseUri().toString())
                .accept(ContentType.XML)
                .accept(ContentType.HTML);
    }
}
