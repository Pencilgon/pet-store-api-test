package org.practice.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.practice.api.CreatePetSteps;
import org.practice.api.UpdatePetSteps;
import org.practice.models.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePetTest extends BaseTest{
    private final CreatePetSteps createPetSteps = new CreatePetSteps();
    private final UpdatePetSteps updatePetSteps = new UpdatePetSteps();
    @Test
    public void updatePet(){
        Response createdPetResponse = createPetSteps.createPet(pet);
        createdPetIds.add(createdPetResponse.path("id"));
        pet.setId(createdPetIds.get(createdPetIds.size()-1));
        Category category = new Category();
        category.setName("Idk");
        pet.setCategory(category);
        Response updatedPetResponse = updatePetSteps.updatePet(pet);
        Assert.assertEquals(updatedPetResponse.getStatusCode(), 200, "Status codes do not match!");
        Assert.assertTrue(updatedPetResponse.getContentType().contains(ContentType.JSON.toString()), "Content types do not match!");
    }
}
