package com.QACart;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class C_extract {

    @Test
    public void firstextract() {
        Response res = given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().extract().response();

        System.out.println(res.asString());
    }

    @Test
    public void extractspecificitem() {
        Response res = given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().extract().response();

        String firstname = res.path("[0].FirstName");
        System.out.println(firstname);
    }

    @Test
    public void extractitemusingjson() {
        Response res = given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().extract().response();

        String firstname = JsonPath.from(res.asString()).getString("[0].FirstName");

        System.out.println(firstname);
    }

    @Test
    public void extractusingthen() {
        String firstname = given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().extract().response().path("[0].FirstName");

        System.out.println(firstname);
    }
}