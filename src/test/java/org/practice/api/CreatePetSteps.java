package org.practice.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.practice.constants.Endpoints;
import org.practice.models.Pet;
import org.practice.utils.RequestSpecifications;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class CreatePetSteps {
    public Response createPet(Pet pet){
        step("Creating pet");
        return given()
                .spec(RequestSpecifications.getReqSpec())
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(Endpoints.PET);
    }
}
