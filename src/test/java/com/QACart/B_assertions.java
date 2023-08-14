package com.QACart;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class B_assertions {

    @Test
    public void statuscode() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().statusCode(200);
    }

    /*

    // An assertion is a way to verify that the expected result and
    the actual result match or not in the test case.
    // Hamcrest is a framework for writing matcher objects,
    allowing ‘match’ rules to be defined declaratively.

    */

    // equalTo – It checks whether the retrieved number from the response is equal to the expected number.
    // to assert body use =  user.body() method
    // Body method takes two parameters = the matcher " groovy path " and Assertion

    /*
    equalTo – It checks whether the retrieved number from the response is equal to the expected number.
    greaterThan – checks extracted number is greater than the expected number.
    greaterThanOrEqualTo – checks whether the extracted number is greater than equal to the expected number.
    lessThan – It checks whether the retrieved number from the response is lesser than the expected number.
    lessThanOrEqualTo – It checks whether the retrieved number from the response is lesser than or equal to the expected number.
     */

    @Test
    public void assertequal() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("[0].FirstName",is(equalTo("Gina")));
    }

    // HasItem : to assert if an array contains a specific item
    // in the below , Rest will find any country that has item egypt

    @Test
    public void hasitem() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("Country",hasItem("Egypt"));
    }

    @Test
    public void negativehasitem() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("Country",hasItem("HHHH"));

    }

    @Test
    public void collectfirsttestcases() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("[0].FirstName",equalTo("Gina"),"Country",hasItem("Egypt"));
    }

    // HasItems : to assert if an array contains a specific items
    // Arrangement isn't important

    @Test
    public void hasitems() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("Country",hasItems("Egypt","Turkey","Mexico"));
    }

    // Not : use it to check if item is Not in collection

    @Test
    public void notassert() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("[0].FirstName", not(hasItem("wageh")));
    }

    // Contain assert against all , so you must include all data " egypt , mexico" not just one or two
    // its like hasitems but this is the difference
    // Arrangement is very important

    @Test
    public void containsassertoin() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("Country",contains("Saint Vincent and the Grenadines","Mexico","Eritrea","Egypt"));
    }

    @Test
    public void firstnegativecontainsassertoin() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("Country",contains("Saint Vincent and the Grenadines","Mexico"));
    }

    // Arrangement in contains is important

    @Test
    public void secoandnegativecontainsassertoin() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("Country",contains("Saint Vincent and the Grenadines","Mexico","Egypt","Eritrea"));
    }

    // To avoid Arrangement while using contains , we can use contains in any order

    @Test
    public void containsinanyorderassertoin() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("Country",containsInAnyOrder("Saint Vincent and the Grenadines","Egypt","Mexico","Eritrea"));
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
    public void hasi() {
        RestAssured
                .given().baseUri("")
                .when().get("")
                .then().equals("");
    }
}
