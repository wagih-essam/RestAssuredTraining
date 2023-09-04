package com.QACart.Training;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class E_headers {

    @Test
    public void Headersss() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io").log().all()
                .when().get("/api/v1/Students")
                .then();
    }

    // should get only Country Mexico , it returns all!!
    @Test
    public void failedscenario(){
        given()
                .baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .header("Country","Mexico")
                .when().get("/api/v1/Students")
                .then().log().all().assertThat().statusCode(200);
    }
    @Test
    public void shouldbeabletogetcourses(){
        given()
                .baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .header("Country","Mexico")
                .log().all()
        .when().get("/api/v1/Students")
        .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void getheadersOne(){
        given()
                .baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .header("Country","Mexico")
                .header("LastNAme","Kuhlman")
                .log().all()
                .when().get("/api/v1/Students")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void getheadersSeacond(){
        given()
                .baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .headers("Country","Mexico","LastNAme","Kuhlman")
                .log().all()
                .when().get("/api/v1/Students")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void getheadersThird(){
        given()
                .baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .headers("Country","Mexico","LastNAme","Kuhlman")
                .log().all()
                .when().get("/api/v1/Students")
                .then().log().all().assertThat().statusCode(200);
    }
}
