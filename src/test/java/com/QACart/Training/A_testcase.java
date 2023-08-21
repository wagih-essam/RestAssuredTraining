package com.QACart.Training;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class A_testcase {

    @Test
    public void testone() {
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().assertThat().statusCode(200);
    }
    @Test
    public void TestTimeResponse(){
        RestAssured
                .given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io")
                .when().get("/api/v1/Students")
                .then().statusCode(200);
    }
}
