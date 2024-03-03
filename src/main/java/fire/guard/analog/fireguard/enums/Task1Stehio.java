package fire.guard.analog.fireguard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Task1Stehio {
    ACETYLENE("Ацетилен",2,2, 0, 0),
    BUTANE("Бутан",4,10, 0, 0),
    BUTENE("Бутен",4,8, 0, 0),
    METHANE("Метан",1,4, 0, 0),
    PROPYLENE("Пропилен",3,6, 0, 0),
    ETHAN("Этан",2,6, 0, 0),
    ETHYLENE("Этилен",2,4, 0, 0);

    private final String name;
    private final Integer Nc;
    private final Integer Nh;
    private final Integer No;
    private final Integer Nx;

    public static List<String> getNames(){
        return Arrays.stream(Task1Stehio.values())
                .map(Task1Stehio::getName)
                .collect(Collectors.toList());
    }

    public static Task1Stehio getByName(String name){
        return Arrays.stream(Task1Stehio.values())
                .filter(val -> val.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
