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
    V("v");
    private String name;

    CacheConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
