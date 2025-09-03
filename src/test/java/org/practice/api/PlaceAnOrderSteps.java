package org.practice.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.practice.constants.Endpoints;
import org.practice.models.Order;
import org.practice.utils.RequestSpecifications;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class PlaceAnOrderSteps {
    public Response placeAnOrder(Order order){
        step("Placing an order");
        return given()
                .spec(RequestSpecifications.getReqSpec())
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(Endpoints.ORDER);
    }
}
