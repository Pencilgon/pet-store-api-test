package org.practice.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.practice.api.CreatePetSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePetTest extends BaseTest{
    private final CreatePetSteps createPetSteps = new CreatePetSteps();
    @Test
    public void createPet(){
        var createdPetResponse = createPetSteps.createPet(pet);
        createdPetIds.add(createdPetResponse.path("id"));
        Assert.assertEquals(createdPetResponse.getStatusCode(), 200, "Status codes do not match!");
        Assert.assertEquals(createdPetResponse.getContentType(), ContentType.JSON.toString(), "Content types do not match!");
        Assert.assertTrue(createdPetResponse.getHeader("Access-Control-Allow-Methods").contains("DELETE"), " Header \"Access-Control-Allow-Methods\" does not contain DELETE method!");
    }
}
