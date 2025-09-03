package org.practice.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Endpoints {
    public final String BASE_PATH = "v2";
    public final String PET = "/pet";
    public final String PET_BY_ID = "%s/{%s}".formatted(PET, Params.PARAM_ID);
    public final String STORE = "/store";
    public final String ORDER = STORE + "/order";
    public final String ORDER_BY_ID = "%s/{%s}".formatted(ORDER, Params.PARAM_ORDER_ID);
}
