package org.practice.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;
import org.practice.constants.Endpoints;

@UtilityClass
public class RequestSpecifications {
    public RequestSpecification getReqSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(SettingsTestData.getEnvironmentData().getBaseUrl())
                .setBasePath(Endpoints.BASE_PATH)
                .setAccept(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
