package com.QACart.Training;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class F_parameters {

    @Test
    public void ShouldBeAbleToGetLectures() {
        given().baseUri("https://todo.qacart.com")
                .queryParam("mode","VIDEO")
                .queryParam("type","FREE")
                .log().all()
                .when().get("/api/v1/info/lectures")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void QuiryOaramsOne(){
        given()
                .baseUri("https://todo.qacart.com")
                .queryParams("mode","VIDEO","type","FREE")
                .log().all()
                .when().get("/api/v1/info/lectures")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void HashMapQuiryParams(){

        HashMap< String , String > quiries = new HashMap<>();
        quiries.put("mode","VIDEO");
        quiries.put("type","PAID");

        given()
                .baseUri("https://todo.qacart.com")
                .queryParams(quiries).log().all()
                .when().get("/api/v1/info/lectures")
                .then().log().all().assertThat().statusCode(200);
    }


}
