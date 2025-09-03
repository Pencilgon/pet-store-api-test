package org.practice.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.practice.constants.Endpoints;
import org.practice.constants.Params;
import org.practice.utils.RequestSpecifications;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class ReadOrderSteps {
    public Response readOrder(Long id){
        step("Reading order");
        return given()
                .spec(RequestSpecifications.getReqSpec())
                .contentType(ContentType.JSON)
                .pathParams(Params.PARAM_ORDER_ID, id)
                .when()
                .get(Endpoints.ORDER_BY_ID);
    }
}
