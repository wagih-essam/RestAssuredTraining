package com.restframework.todo.testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {

    @Test
    public void shouldBeAbletoRegisterReqRes(){

        String body =

                "{\n " +
                "    'email': 'eve.holt@reqres.in',\n" +
                "    'password': 'pistol'\n" +
                "}";

        RestAssured.
                given()
                .baseUri("https://reqres.in/api/register")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when().post()
                .then().log().all().assertThat().body("id", equalTo("4"));

    }

    @Test
    public void shouldNotBeAbletoRegisterReqRes() {

        String body =

                "{\n " +
                        "    'email': 'sydney@fife'\n" +
                        "}";

        RestAssured.
                given()
                .baseUri("https://reqres.in/api/register")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when().post()
                .then().log().all().assertThat().statusCode(400).assertThat().body("error", equalTo("Missing password"));
    }


        @Test
        public void shouldBeAbletoLoginReqRes(){

            String loginbody =

                    "{\n " +
                            "    'email': 'eve.holt@reqres.in',\n" +
                            "    'password': 'cityslicka'\n" +
                            "}";

            RestAssured.
                    given()
                    .baseUri("https://reqres.in")
                    .contentType(ContentType.JSON)
                    .body(loginbody)
                    .log().all()
                    .when().post("/api/login")
                    .then().log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("token", equalTo("QpwL5tke4Pnpja7X4"));

        }

    @Test
    public void shouldNotBeAbletoLoginReqRes(){

        String NotLoginbody =

                "{\n " +
                        "    'email': 'peter@klaven'\n" +
                        "}";

        RestAssured.
                given()
                .baseUri("https://reqres.in/api/login")
                .contentType(ContentType.JSON)
                .body(NotLoginbody)
                .log().all()
                .when().post()
                .then().log().all()
                .assertThat().statusCode(400)
                .assertThat().body("error", equalTo("Missing password"));

    }



    }

