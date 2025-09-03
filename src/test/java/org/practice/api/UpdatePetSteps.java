package org.practice.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.practice.constants.Endpoints;
import org.practice.constants.Params;
import org.practice.models.Pet;
import org.practice.utils.RequestSpecifications;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class UpdatePetSteps {
    public Response updatePet(Pet pet){
        step("Updating pet");
        return given()
                .spec(RequestSpecifications.getReqSpec())
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(Endpoints.PET);
    }
}
