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
                .then().assertThat().body("[0].FirstName", not(hasItem("wagehh")));
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
    public void emptyassertion() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("[1].FirstName",empty());
    }

    @Test
    public void notemptyassertion() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("[1].FirstName",not(empty()));
    }

    @Test
    public void hassizeassertion() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("LastNAme",hasSize(4));
    }

    @Test
    public void secoandhassizeassertion() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("FirstName.size",equalTo(4));
    }

    @Test
    public void everyitemstartwithassertion() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("createdAt",everyItem(startsWith("2023")));
    }

    // HasKey,HasValue and HasEntry to make sure map contains specific item
    // HasKey to make sure that map contains a specific map
    // assertThat().body("[Groovy Path]",hasKey(key));

    @Test
    public void haskeyasertion() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("[0]",hasKey("FirstName"));
    }

    // HasKey to make sure that map contains a specific map
    // assertThat().body("[Groovy Path]",hasKey(key));

    @Test
    public void hasvalueassertion() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("[3].",hasValue("Egypt"));
    }

    // HasEntry to make sure that map contains a specific value for specific key
    // assertThat().body("[Groovy Path]",hasEntry("Key","Value"));

    @Test
    public void hasentryassertion() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().body("[1]",hasEntry("LastNAme","Kuhlman"));
    }
}
