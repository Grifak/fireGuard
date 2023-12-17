package fire.guard.analog.fireguard;


public class ValuesStorage {

    private Double Va;
    private Double V1m;
    private Double V2m;
    private Double rhoG;
    private Double mass;
    private Double mstar;
    private Double Vsv;
    private Double Kn = 3.0;

    private Double coefZ;
    private Double Csteh;

    private Double deltaP;
    public Double getCoefZ() {
        return coefZ;
    }

    public Double getKn() {
        return Kn;
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
        return rhoG;
    }

    public void setRhoG(Double rhoG) {
        this.rhoG = rhoG;
    }

    public Double getM() {
        return mass;
    }

    public void setM(Double m) {
        mass = m;
    }

    public Double getMstar() {
        return mstar;
    }

    public void setMstar(Double mstar) {
        this.mstar = mstar;
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
        return deltaP;
    }

    public void setDeltaP(Double deltaP) {
        this.deltaP = deltaP;
    }
}
