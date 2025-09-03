package org.practice.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.practice.api.CreatePetSteps;
import org.practice.api.ReadPetSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadPetTest extends BaseTest{
    private final CreatePetSteps createPetSteps = new CreatePetSteps();
    private final ReadPetSteps readPetSteps = new ReadPetSteps();
    @Test
    public void readPet(){
        Response createdPetResponse = createPetSteps.createPet(pet);
        createdPetIds.add(createdPetResponse.path("id"));
        Response readPetResponse = readPetSteps.readPet(createdPetIds.get(createdPetIds.size()-1));
        Assert.assertEquals(readPetResponse.getStatusCode(), 200, "Status codes do not match!");
        Assert.assertEquals(readPetResponse.getContentType(), ContentType.JSON.toString(), "Content types do not match!");
    }
}
