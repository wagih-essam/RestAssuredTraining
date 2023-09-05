package com.QACart.Training;

import com.QACart.pojo.loginpojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class G_body {

    @Test
    public void ShouldBeAbleToLogin(){
        String body = "{\n" +
                "    'email': 'hatem@example.com',\n" +
                "    'password': 'Test1234'\n" +
                "}";

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when().post("api/v1/students/login")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void ShouldBeAbleToLoginByFile(){
        File body = new File("src/test/resources/login.json");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when().post("api/v1/students/login")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void ShouldBeAbleToLoginByHashMap(){
        HashMap<String,String> body = new HashMap<>();
        body.put("email","hatem@example.com");
        body.put("password","Test1234");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when().post("api/v1/students/login")
                .then().log().all().assertThat().statusCode(200);
    }

    /*
    in the above, it will fail. Why ? >>
    * Cannot serialize object because no JSON serializer found in classpath.
    * Please put Jackson (Databind), Gson, Johnzon, or Yasson in the classpath.
    *
    What is serialization ?
    Serialization is a process of converting an object from its current state to a stream of bytes
    which can be written to a file or transported through a network or stored in a database.

    Serialization is a conversion of the state of a Java object to a byte stream
    Deserialization is the reverse of it i.e.
    conversion of a byte stream to corresponding Java object.
    A serialized object can be stored in files, external sources, databases etc
    *

    Serialization is to convert java object to JSON
    */

    @Test
    public void ShouldBeAbleToLoginBySetters(){
        loginpojo body = new loginpojo();
        body.setEmail("hatem@example.com");
        body.setPassword("Test1234");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when().post("api/v1/students/login")
                .then().log().all().assertThat().statusCode(200);
    }

    /*

    * Or , we can make it by contractor
    * add pulic loginpojo in loginpojo and then apply the belew
    *

    @Test
    public void ShouldBeAbleToLoginByContractor(){
        loginpojo bodyy = new loginpojo("hatem@example.com","Test1234");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(bodyy)
                .log().all()
                .when().post("api/v1/students/login")
                .then().log().all().assertThat().statusCode(200);
    }

    *
     */

}
