package org.practice.utils;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import org.practice.models.EnvironmentData;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {
    private final String RESOURCES_PATH = "src/test/resources/";
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final String ENV_DATA_PATH = ENVIRONMENT_PATH + "env.json";
    private final Gson GSON = new Gson();
    private <T> T deserializeJson(String filePath, Class<T> tClass){
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public EnvironmentData getEnvironmentData(){
        return deserializeJson(ENV_DATA_PATH, EnvironmentData.class);
    }
}
