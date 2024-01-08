package fire.guard.analog.fireguard.common;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class ApplicationUtils {
    public Boolean validateFields(TextField... fields){
        for(TextField field : fields){
            if(field.getText().isEmpty())
                return false;
        }
        return true;
    }

    public Double getDoubleFromField(TextField textField){
        try {
            return Double.valueOf(textField.getText());
        }catch (NumberFormatException ex){
            return Double.valueOf(textField.getText().concat(".0"));
        }
    }

    public static TextFormatter<Double> getFormatter(){
        UnaryOperator filter = getFilter();
        return new TextFormatter<>(filter);
    }
    private static UnaryOperator getFilter() {
        Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");
        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c ;
            } else {
                return null ;
            }
        };

        return filter;
    }
}
