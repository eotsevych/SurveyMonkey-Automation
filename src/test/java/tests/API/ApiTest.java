package tests.API;

import api.services.RequestPoint;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertAll;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("AQA Tests")
class ApiTest {

    private static final String EXPECTED_SERVER = "akka-http/10.1.7";
    private RequestPoint requestPoint;

    @BeforeAll
    void setup() {
        requestPoint = new RequestPoint();
    }

    @Test
    @DisplayName("Verify IP")
    void ipJsonTest() {
        Response response = requestPoint.getIpResponse();
        assertThat("Ip Json Test request is not successful, status code differs from expected!", response.getStatusCode(), is(not(HttpStatus.SC_SERVICE_UNAVAILABLE)));
    }

    @Test
    @Issue("BUG-1")
    @DisplayName("Verify Health Check")
    void HealthCheckTest() {
        Response response = requestPoint.getHealthCheckResponse();
        assertAll("Health Check verification",
                () -> assertThat("Status code differs from expected!", response.getStatusCode(), is(HttpStatus.SC_OK)),
                () -> assertThat("Server differs from expected!", response.getStatusLine(), is(EXPECTED_SERVER))
        );
    }

}
