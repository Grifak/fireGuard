package fire.guard.analog.fireguard.calculator;

public class GasCalculator {
    private static final double V0 = 22.4;
    private static final double PI = Math.PI;

    //1 Method to calculate Va
    public static Double calculateVa(Double P, Double V) {
        return 0.01 * P * V;
    }

    //2 Method to calculate V1m
    public static Double calculateV1m(Double q, Double tau) {
        return q * tau;
    }

    //3 Method to calculate V2m
    public static Double calculateV2m(Double P2, Double lPodv, Double dPodv, Double lOtv, double dOtv) {
        return 0.01 * PI * P2 * (((lPodv * Math.pow(dPodv, 2))/4) + ((lOtv * Math.pow(dOtv, 2))/4));
    }

    //4 Method to calculate ρg
    public static Double calculateRhoG(double M, double T) {
        return M / (V0 * (1 + 0.00367 * T));
    }

    //5 Method to calculate m
    public static Double calculateM(Double Va, Double Vm, Double rho) {
        return (Va + Vm) * rho;
    }

    //6 Method to calculate m*
    public static Double calculateMStar(Double m, Double A, Double tau) {
        return m / (1 + A * tau);
    }
    //8 Method to calculate Vсв
    public static Double calculateVsv(Double L, Double B, Double H, Double areaCoef) {
        double Vpom = L * B * H;
        return areaCoef * Vpom;
    }

    //9 Method to calculate Сстех
    public static Double calculateCsteh(Double nC, Double nH, Double nX, Double nO) {
        double beta = nC + ((nH - nX) / 4) - (nO / 2);
        return 100 / (1 + (4.84 * beta));
    }
    //11 Method to calculate ΔP
    public static Double calculateDeltaP(Double Pmax, Double P0, Double m, Double Z, Double Vsv, Double rhoG, Double Csteh, Double Kn) {
        return (Pmax - P0) * ((m * Z) / (Vsv * rhoG)) * (100 / Csteh) * (1 / Kn);
    }
}
