package fire.guard.analog.fireguard.enums;

public enum CacheConstants {
    EVAP_RATE("evapRate"),
    EVAP_TIME("evapTime"),
    MASS_EVAP("massEvap"),
    VAPOUR_MASS("vapourMass"),
    STREEM_PRESS("streamPress"),
    AIR_SPEED("airSpeed"),

    NU("nu"),
    LIQUID_EVAP("liquidEvap"),
    LIQUID_SPILL("liquidSpill"),
    TECH_LIQUID_MASS("techLiquidMass"),
    PUMP_LIQUID_MASS("pumpLiquidMass"),
    PIPE_LIQUID_MASS("pipeLiquidMass"),
    S_ROOM("sRoom"),
    V_ROOM("vRoom"),
    FREE_SPACE("freeSpace"),
    VAPOUR_DENSITY("vapourDensity"),
    STECH_COEF("stechCoef"),
    EXCES_PRESS("excesPress"),

    ROOM_LEN("roomLen"),
    ROOM_HEIGHT("roomHeight"),
    ROOM_WEIGHT("roomWeight"),
    CAPACITY_VOL("capacityVol"),
    PUMP_FEED("pumpFeed"),
    S_MIRROR("sMirror"),
    ROOM_TEMP("roomTemp"),
    SHUT_OFF_TIME("shutOffTime"),
    AIR_EXCHANGE("airExchange"),

    SUBSTANCE_NAME("substanceName"),

    MOLAR_MASS("molarMass"),

    DENSITY("density"),

    PIPE_LEN_PODV("pipeLenPodv"),
    PIPE_LEN_ODV("pipeLenOdv"),
    DIAMETER_PIPELINE_PODV("diameterPipelinePodv"),
    DIAMETER_PIPELINE_ODV("diameterPipelineOdv"),
    COEF_FREE_SPACE("coefFreeSpace"),
    S_OKR("sOkr"),
    ANTUANA_A("antuanaA"),
    ANTUANA_B("antuanaB"),
    ANTUANA_C("antuanaC"),
    V("v"),

    N_C("nC"),
    N_H("nH"),
    N_O("nO"),

    N_X("nX");
    private String name;

    CacheConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
