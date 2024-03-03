package fire.guard.analog.fireguard;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValuesStorage {
    private static ValuesStorage instance;
    ValuesStorage() {}

    public static ValuesStorage getInstance() {
        if (ValuesStorage.instance == null) {
            synchronized (ValuesStorage.class) {
                if (ValuesStorage.instance == null) {
                    ValuesStorage.instance = new ValuesStorage();
                }
            }
        }
        return ValuesStorage.instance;
    }
    private Double Va;
    private Double V1m;
    private Double V2m;
    private Double rhoG;
    private Double mass;
    private Double mstar;
    private Double Vsv;
    private Double Kn = 3.0;

    private Double length;
    private Double width;
    private Double square;
    private Double Nc;
    private Double Nh;
    private Double No;
    private Double Nx;
    private Double containerVolume;
    private Double containerPressure;
    private Double gasConsumption;
    private Double closingTime;
    private Double height;

    private Double temperature;
    private Double molarMass;

    private Double areaCoef;

    private String gasName;

    private Double areaVolume;
    private Double maxP2;
    private Double lpodv;
    private Double lotv;
    private Double dpodv;
    private Double dotv;

    private Double maxPressure;

    private Double coefZ;
    private Double Csteh;

    private Double deltaP;

    private String objectAddress;
    private String objectName;
    private String producerFio;
    private String consumerFio;
    private String buildingType;
    private String roomType;
    private String producerRank;
    private String consumerRank;
}
