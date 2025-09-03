package org.practice.tests;

import org.practice.constants.Endpoints;
import org.practice.constants.Params;
import org.practice.models.Pet;
import org.practice.utils.RequestSpecifications;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class BaseTest {
    protected List<Long> createdPetIds = new ArrayList<>();
    protected Pet pet;
    @BeforeSuite
    public void setup(){
        pet = new Pet();
        pet.setName("Doggie");
    }
    @AfterSuite
    public void teardown(){
        step("Deleting created pets during the test");
        createdPetIds.forEach(id->deletePetsById(id));
    }
    private void deletePetsById(Long id){
        given()
                .spec(RequestSpecifications.getReqSpec())
                .pathParams(Params.PARAM_ID, id)
                .when()
                .delete(Endpoints.PET_BY_ID);
    }
}
