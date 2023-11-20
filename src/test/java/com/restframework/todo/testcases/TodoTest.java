package com.restframework.todo.testcases;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TodoTest {

    @Test
    public void todotes5646t() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().statusCode(200);
    }
}
