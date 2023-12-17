package fire.guard.analog.fireguard.common;

import javafx.scene.control.TextField;

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
}
