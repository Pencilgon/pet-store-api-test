package org.practice.tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.practice.api.CreatePetSteps;
import org.practice.api.PlaceAnOrderSteps;
import org.practice.api.ReadOrderSteps;
import org.practice.models.Order;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceAnOrderTest extends BaseTest{
    private final CreatePetSteps createPetSteps = new CreatePetSteps();
    private final PlaceAnOrderSteps placeAnOrderSteps = new PlaceAnOrderSteps();
    private final ReadOrderSteps readOrderSteps = new ReadOrderSteps();
    @Test
    @Description("Place an order for the pet")
    @Epic("Web Application")
    @Feature("Order Placement")
    @Story("Placing an order for the pet in pet store")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("MDA-324")
    @Issue("AMD-3627")
    public void placeAnOrder(){
        Response createdPetResponse = createPetSteps.createPet(pet);
        createdPetIds.add(createdPetResponse.path("id"));
        Order order = new Order();
        order.setPetId(createdPetIds.get(createdPetIds.size()-1));
        order.setQuantity(1);
        Response placedOrderResponse = placeAnOrderSteps.placeAnOrder(order);
        Assert.assertTrue(placedOrderResponse.getContentType().contains(ContentType.JSON.toString()), "Content types do not match!");
        Assert.assertEquals(placedOrderResponse.path("petId"), order.getPetId(), "IDs are not equal!");
        Assert.assertEquals(placedOrderResponse.path("quantity"), order.getQuantity(), "Quantities are not equal!");
        Assert.assertEquals(placedOrderResponse.path("complete"), false, "Complete field is not false in the response!");
        Response readOrderResponse = readOrderSteps.readOrder(placedOrderResponse.path("id"));
        Assert.assertEquals(readOrderResponse.getStatusCode(), 200, "Status codes do not match!");
    }
}
