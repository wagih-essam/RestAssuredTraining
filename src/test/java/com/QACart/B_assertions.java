package com.QACart;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class B_assertions {

    @Test
    public void statuscode() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().statusCode(200);
    }

    @Test
    public void assertequal() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void hasitems() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void not() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void contains() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void empty() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void hassize() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void everyitemstartwith() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void haskey() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void hasvalue() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }

    @Test
    public void hasitem() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }
}
