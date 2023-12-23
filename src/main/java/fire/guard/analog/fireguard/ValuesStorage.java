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


    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public void setKn(Double kn) {
        Kn = kn;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Double getNc() {
        return Nc;
    }

    public void setNc(Double nc) {
        Nc = nc;
    }

    public Double getNh() {
        return Nh;
    }

    public void setNh(Double nh) {
        Nh = nh;
    }

    public Double getNo() {
        return No;
    }

    public void setNo(Double no) {
        No = no;
    }

    public Double getNx() {
        return Nx;
    }

    public void setNx(Double nx) {
        Nx = nx;
    }

    public Double getLength() {
        return length;
    }
    public void setLength(Double length) {
        this.length = length;
    }
    public Double getWidth() {
        return width;
    }
    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getAreaCoef() {
        return areaCoef;
    }

    public void setAreaCoef(Double areaCoef) {
        this.areaCoef = areaCoef;
    }

    public String getGasName() {
        return gasName;
    }

    public void setGasName(String gasName) {
        this.gasName = gasName;
    }

    public Double getAreaVolume() {
        return areaVolume;
    }

    public void setAreaVolume(Double areaVolume) {
        this.areaVolume = areaVolume;
    }

    public Double getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(Double gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    public Double getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Double closingTime) {
        this.closingTime = closingTime;
    }

    public Double getMaxP2() {
        return maxP2;
    }

    public void setMaxP2(Double maxP2) {
        this.maxP2 = maxP2;
    }

    public Double getLpodv() {
        return lpodv;
    }

    public void setLpodv(Double lpodv) {
        this.lpodv = lpodv;
    }

    public Double getLotv() {
        return lotv;
    }

    public void setLotv(Double lotv) {
        this.lotv = lotv;
    }

    public Double getDpodv() {
        return dpodv;
    }

    public void setDpodv(Double dpodv) {
        this.dpodv = dpodv;
    }

    public Double getDotv() {
        return dotv;
    }

    public void setDotv(Double dotv) {
        this.dotv = dotv;
    }

    public Double getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(Double maxPressure) {
        this.maxPressure = maxPressure;
    }

    private Double height;

    public Double getContainerVolume() {
        return containerVolume;
    }

    public void setContainerVolume(Double containerVolume) {
        this.containerVolume = containerVolume;
    }

    public Double getContainerPressure() {
        return containerPressure;
    }

    public void setContainerPressure(Double containerPressure) {
        this.containerPressure = containerPressure;
    }

    private Double temperature;
    private Double molarMass;

    public Double getMolarMass() {
        return molarMass;
    }

    public void setMolarMass(Double molarMass) {
        this.molarMass = molarMass;
    }

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
