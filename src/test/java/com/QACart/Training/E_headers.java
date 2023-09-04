package com.QACart.Training;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class E_headers {

    @Test
    public void Headersss() {
        given().baseUri("https://todo.qacart.com").log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all().assertThat().statusCode(200);
    }

    /*


  {
    "courses": [
        {
            "id": 1,
            "author": "Hatem Hatamleh",
            "name": "Selenium",
            "type": "WEB",
            "language": "JAVA"
        },
        {
            "id": 2,
            "author": "Hatem Hatamleh",
            "name": "ISTQB Foundation Level",
            "type": "MANUAL",
            "language": "NONE"
        }
    ],
    "count": 2
}


    */
    @Test
    public void shouldbeabletogetcourses(){
        given()
                .baseUri("https://todo.qacart.com")
                .header("language","JAVA")
                .log().all()
        .when().get("/api/v1/info/courses")
        .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void getheadersOne(){
        given()
                .baseUri("https://todo.qacart.com")
                .header("language","NONE")
                .header("type","MANUAL")
                .log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void getheadersSeacond(){
        given()
                .baseUri("https://todo.qacart.com")
                .headers("language","JAVA","type","WEB")
                .log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void headerclass(){

        Header typeHeader = new Header("type","WEB");
        given()
                .baseUri("https://todo.qacart.com")
                .header(typeHeader)
                .log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void headerclasstwo(){

        Header typeHeader = new Header("type","WEB");
        Header langHeader = new Header("language","JAVA");
        given()
                .baseUri("https://todo.qacart.com")
                .header(typeHeader)
                .header(langHeader)
                .log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void headersclass(){

        Header typeHeader = new Header("type","WEB");
        Header langHeader = new Header("language","JAVA");

        Headers infoHeader = new Headers(typeHeader,langHeader);
        given()
                .baseUri("https://todo.qacart.com")
                .headers(infoHeader)
                .log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void HashMap(){

        HashMap<String ,String > infoHEader = new HashMap<>();
        infoHEader.put("language","NONE");
        infoHEader.put("type","MANUAL");

        //Header typeHeader = new Header("type","WEB");
        //Header langHeader = new Header("language","JAVA");
        //Headers infoHeader = new Headers(typeHeader,langHeader);
        given()
                .baseUri("https://todo.qacart.com")
                .headers(infoHEader)
                .log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void CleanUp(){

        HashMap<String ,String > infoHEader = new HashMap<>();
        infoHEader.put("language","NONE");
        infoHEader.put("type","MANUAL");

        given()
                .baseUri("https://todo.qacart.com")
                .headers(infoHEader)
                .log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all().assertThat().statusCode(200).body("count", equalTo(1));
    }

}
