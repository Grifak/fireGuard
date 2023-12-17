package fire.guard.analog.fireguard;


public class ValuesStorage {

    private Double Va;
    private Double V1m;
    private Double V2m;
    private Double RhoG;
    private Double M;
    private Double Mstar;
    private Double Vsv;

    public Integer getKn() {
        return Kn;
    }

    private Integer Kn = 3;
    private Double coefZ;

    private Double Csteh;
    private Double DeltaP;

    public Double getCoefZ() {
        return coefZ;
    }

    public void setCoefZ(Double coefZ) {
        this.coefZ = coefZ;
    }

    public Double getVa() {
        return Va;
    }

    public void setVa(Double va) {
        Va = va;
    }

    public Double getV1m() {
        return V1m;
    }

    public void setV1m(Double v1m) {
        V1m = v1m;
    }

    public Double getV2m() {
        return V2m;
    }

    public void setV2m(Double v2m) {
        V2m = v2m;
    }

    public Double getRhoG() {
        return RhoG;
    }

    public void setRhoG(Double rhoG) {
        RhoG = rhoG;
    }

    public Double getM() {
        return M;
    }

    public void setM(Double m) {
        M = m;
    }

    public Double getMstar() {
        return Mstar;
    }

    public void setMstar(Double mstar) {
        Mstar = mstar;
    }

    public Double getVsv() {
        return Vsv;
    }

    public void setVsv(Double vsv) {
        Vsv = vsv;
    }

    public Double getCsteh() {
        return Csteh;
    }

    public void setCsteh(Double csteh) {
        Csteh = csteh;
    }

    public Double getDeltaP() {
        return DeltaP;
    }

    public void setDeltaP(Double deltaP) {
        DeltaP = deltaP;
    }
}
