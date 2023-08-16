package com.QACart;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class D_logging {

    @Test
    public void logrequestdata_all() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io").log().all()
                    .when().get("/api/v1/Students")
                    .then();
        }

    @Test
    public void logspecificrequestdata_headers() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io").log().headers()
                .when().get("/api/v1/Students")
                .then();
    }

    @Test
    public void logspecificrequestdata_body() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io").log().body()
                .when().get("/api/v1/Students")
                .then();
    }

    @Test
    public void logspecificrequestdata_parameters() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io").log().parameters()
                .when().get("/api/v1/Students")
                .then();
    }

    @Test
    public void logspecificrequestdata_status() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().log().status();
    }

    @Test
    public void logspecificrequestdata_method() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io").log().method()
                .when().get("/api/v1/Students")
                .then();
    }

    @Test
    public void logspecificrequest_iferrorpositive() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().log().ifError();
    }

    @Test
    public void logspecificrequest_iferrornegative() {
        given().baseUri("https://60c391c82df2cb00178ab77.mockapi.io")
                .when().get("/api/v1/Students")
                .then().log().ifError();
    }

    @Test
    public void logspecificrequest_ifvalidationfailed() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().log().ifValidationFails().
                body("[0].FirstName",equalTo("Giza"));
    }

    @Test
    public void logspecificrequest_ifvalidationfailedsecoand() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().log().ifValidationFails().
                body("[0].FirstName",equalTo("Giza"));
    }

}
