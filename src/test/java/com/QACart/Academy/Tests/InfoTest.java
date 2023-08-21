package com.QACart.Academy.Tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class InfoTest {

    @Test
    public void ShouldBeAbleToGetCourses() {
        given()
                .baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .header("id","3")
                .log().all()
        .when()
                .get("/api/v1/Students")
        .then()
                .log().all().assertThat().statusCode(200);
    }
}
