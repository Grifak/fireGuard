package fire.guard.analog.fireguard.enums;

import java.util.Arrays;
import java.util.List;

public enum Task1Stehio {
    ACETYLENE("Ацетилен",2,2),
    BUTANE("Бутан",4,10),
    BUTENE("Бутен",4,8),
    METHANE("Метан",1,4),
    PROPYLENE("Пропилен",3,6),
    ETHAN("Этан",2,6),
    ETHYLENE("Этилен",2,4);

    private String name;
    private Integer Nc;
    private Integer Nh;

    public static List<String> getNames(){
        return Arrays.stream(Task1Stehio.values())
                .map(Task1Stehio::getName)
                .toList();
    }

    public static Task1Stehio getByName(String name){
        return Arrays.stream(Task1Stehio.values())
                .filter(val -> val.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Integer getNc() {
        return Nc;
    }

    public void setNc(Integer nc) {
        Nc = nc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNh() {
        return Nh;
    }

    public void setNh(Integer nh) {
        Nh = nh;
    }

    Task1Stehio(String name, Integer Nc, Integer Nh){
        this.name = name;
        this.Nc = Nc;
        this.Nh = Nh;
    }

}
