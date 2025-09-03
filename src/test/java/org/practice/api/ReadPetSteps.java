package org.practice.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.practice.constants.Endpoints;
import org.practice.constants.Params;
import org.practice.utils.RequestSpecifications;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class ReadPetSteps {
    public Response readPet(Long id){
        step("Reading pet");
        return given()
                .spec(RequestSpecifications.getReqSpec())
                .contentType(ContentType.JSON)
                .pathParams(Params.PARAM_ID, id)
                .when()
                .get(Endpoints.PET_BY_ID);
    }
}
