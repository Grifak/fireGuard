package fire.guard.analog.fireguard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class BuildingInfoController implements Initializable {

    private final ValuesStorage valuesStorage = ValuesStorage.getInstance();
    @FXML
    private TextField objectAddress;

    @FXML
    private TextField objectName;
    @FXML
    private TextField producerFio;
    @FXML
    private TextField consumerFio;
    @FXML
    private TextField buildingType;
    @FXML
    private TextField roomType;
    @FXML
    private TextField producerRank;
    @FXML
    private TextField consumerRank;

    public void onInfoAcceptButton(){
        valuesStorage.setObjectAddress(objectAddress.getText());
        valuesStorage.setObjectName(objectName.getText());
        valuesStorage.setProducerFio(producerFio.getText());
        valuesStorage.setConsumerFio(consumerFio.getText());
        valuesStorage.setBuildingType(buildingType.getText());
        valuesStorage.setRoomType(roomType.getText());
        valuesStorage.setProducerRank(producerRank.getText());
        valuesStorage.setConsumerRank(consumerRank.getText());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
