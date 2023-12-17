package fire.guard.analog.fireguard.enums;

import java.util.Arrays;
import java.util.List;

public enum Task2Substance {
    GEKSAN("гексан", "C6 H10 O", 98, 6.33089, 1670.009, 230.312, 661, 6, 10, 0, 1),
    CHIKLO_GEKSAN("циклогексан", "С6 H14", 86, 5.99517, 1166.274, 223.661, 779, 6, 14, 0, 0),
    BUTILACHETAT("бутилацетат", "C2 H12 O2", 116, 6.25205, 1430.418, 210.745, 882, 2, 12, 0, 2),
    ACETON("ацетон", "C3 H6 O", 58, 6.37551, 1281.721, 237.008, 784, 3, 6, 0, 1),
    PENTAN("пентан", "С5 H12", 72, 5.97208, 1062.555, 231.805, 626, 5, 12, 0, 0),
    SPIRT("этиловый спирт", "С2 H6 O", 46, 7.81158, 1918.508, 252.125, 789, 2, 6, 0, 1),
    BENZOL("бензол", "C6 H6", 78, 5.6139, 902.275, 178.099, 876, 6, 6, 0, 0),
    AMIL_SPIRT("амиловый спирт", "C5 H12 O", 88, 6.3073, 1287.625, 161.33, 811, 5, 12, 0, 1);
    private String name;
    private String formula;
    private Integer molarMass;
    private Double antuanA;
    private Double antuanB;
    private Double antuanC;
    private Integer density;
    private Integer nC;
    private Integer nH;
    private Integer nX;
    private Integer nO;


    Task2Substance(String name, String formula, Integer molarMass, Double antuanA, Double antuanB, Double antuanC, Integer density, Integer nC, Integer nH, Integer nX, Integer nO) {
        this.name = name;
        this.formula = formula;
        this.molarMass = molarMass;
        this.antuanA = antuanA;
        this.antuanB = antuanB;
        this.antuanC = antuanC;
        this.density = density;
        this.nO = nO;
        this.nC = nC;
        this.nX = nX;
        this.nH = nH;
    }

    public String getName() {
        return name;
    }

    public String getFormula() {
        return formula;
    }

    public Integer getMolarMass() {
        return molarMass;
    }
    public Double getAntuanA() {
        return antuanA;
    }

    public Double getAntuanB() {
        return antuanB;
    }

    public Double getAntuanC() {
        return antuanC;
    }
    public Integer getDensity() {
        return density;
    }

    public Integer getnC() {
        return nC;
    }

    public Integer getnH() {
        return nH;
    }

    public Integer getnX() {
        return nX;
    }

    public Integer getnO() {
        return nO;
    }

    public static List<String> getNames(){
        return Arrays.stream(Task2Substance.values())
                .map(Task2Substance::getName)
                .toList();
    }

    public static Task2Substance getByName(String name){
        return Arrays.stream(Task2Substance.values())
                .filter(val -> val.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
