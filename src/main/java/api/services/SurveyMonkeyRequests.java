package api.services;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.disqualified.Disqualified;
import pojo.question.QuestionPojo;
import pojo.surveys.SurveysResponse;

import static io.restassured.RestAssured.given;

public class SurveyMonkeyRequests {

    private final RequestSpecification requestSpec = new RequestSpecBuilder()
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new RequestLoggingFilter())
            .addFilter(new AllureRestAssured())
            .setBaseUri("https://api.surveymonkey.net/v3")
            .setContentType(ContentType.JSON)
            .addHeader("Authorization","")
            .build();

    @Step
    public SurveysResponse getSurveys() {
        return given()
                .spec(requestSpec)
                .when().get("/surveys")
                .then()
                .statusCode(200)
                .extract().response().as(SurveysResponse.class);
    }

    @Step
    public Disqualified getDisqualifiedResponses(int id, int page) {
        return given()
                .spec(requestSpec)
                .pathParam("surveyID", id)
                .queryParam("status", "disqualified")
                .queryParam("page", page)
                .queryParam("per_page", 100)
                .when().get("/surveys/{surveyID}/responses/bulk")
                .then()
                .statusCode(200)
                .extract().response().as(Disqualified.class);
    }

    @Step
    public QuestionPojo getQuestionAndAnswers(int id, int page, int question) {
        return given()
                .spec(requestSpec)
                .pathParam("surveyID", id)
                .pathParam("pageID", page)
                .pathParam("questionID", question)
                .when().get("/surveys/{surveyID}/pages/{pageID}/questions/{questionID}")
                .then()
                .statusCode(200)
                .extract().response().as(QuestionPojo.class);
    }

    @Step
    public Response deleteResponse(int id, long respId) {
        return given()
                .spec(requestSpec)
                .pathParam("collectorID", id)
                .pathParam("responseID", respId)
                .when().delete("/collectors/{collectorID}/responses/{responseID}")
                .then()
                .statusCode(200).extract().response();
    }
}
