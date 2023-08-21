package com.QACart.Training;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class E_headers {

    @Test
    public void Headersss() {
        given().baseUri("https://60c391c82df2cb00178ab775.mockapi.io").log().all()
                .when().get("/api/v1/Students")
                .then();
    }
}
