package api.services;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class RequestPoint {

    private static final String HTTP_IP_JSONTEST_COM = "http://ip.jsontest.com/";
    private static final String HTTPS_RECORDSQA_CARBYNEAPIDEV_COM = "https://recordsqa.carbyneapidev.com";

    private static final long MAX_TIME_OUT_SEC = 5000;

    private final RequestSpecification requestSpec = new RequestSpecBuilder()
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new RequestLoggingFilter())
            .addFilter(new AllureRestAssured())
            .build();

    @Step
    public Response getIpResponse() {
        return given()
                .spec(requestSpec)
                .baseUri(HTTP_IP_JSONTEST_COM)
                .when().get("/")
                .then()
                .time(lessThan(MAX_TIME_OUT_SEC))
                .extract().response();
    }

    @Step
    public Response getHealthCheckResponse() {
        return given()
                .spec(requestSpec)
                .baseUri(HTTPS_RECORDSQA_CARBYNEAPIDEV_COM).basePath("/RecordsService/ExternalServices")
                .when().get("/HealthCheck")
                .then()
                .time(lessThan(MAX_TIME_OUT_SEC))
                .extract().response();
    }
}

