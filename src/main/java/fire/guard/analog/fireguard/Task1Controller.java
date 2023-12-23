package fire.guard.analog.fireguard;

import fire.guard.analog.fireguard.calculator.GasCalculator;
import fire.guard.analog.fireguard.common.ApplicationUtils;
import fire.guard.analog.fireguard.common.DocumentGenerator;
import fire.guard.analog.fireguard.common.NumFormatter;
import fire.guard.analog.fireguard.enums.Task1Stehio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class Task1Controller implements Initializable {
    private final ValuesStorage valuesStorage = new ValuesStorage();
    private final ApplicationUtils appUtils = new ApplicationUtils() ;

    private final DocumentGenerator documentGenerator = new DocumentGenerator();
    @FXML
    private ChoiceBox<String> dropDownList;
    @FXML
    private TextField pressureField;
    @FXML
    private TextField volumeField;
    @FXML
    private TextField gasConsumptionField;
    @FXML
    private TextField closingTimeField;
    @FXML
    private TextField maxP2Field;
    @FXML
    private TextField lpodvField;
    @FXML
    private TextField dodvField;
    @FXML
    private TextField lotvField;
    @FXML
    private TextField dotvField;
    @FXML
    private TextField insideTempField;
    @FXML
    private TextField outGasField;
    @FXML
    private TextField inGasField;
    @FXML
    private TextField airExchgField;
    @FXML
    private TextField lengthField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField widthField;
    @FXML
    private TextField areaCoefField;
    private Double NcField;
    private Double NhField;
    @FXML
    private TextField NxField;
    @FXML
    private TextField NoField;
    @FXML
    private TextField maxPressureField;
    @FXML
    private TextField startPressureField;
    @FXML
    private ChoiceBox<String> dropDownListZ;
    @FXML
    private ChoiceBox<String> dropDownListSteh;
    @FXML
    private TextField res1;
    @FXML
    private TextField res2;
    @FXML
    private TextField res3;
    @FXML
    private TextField res4;
    @FXML
    private TextField res5;
    @FXML
    private TextField res6;
    @FXML
    private TextField res7;
    @FXML
    private TextField res8;
    @FXML
    private TextField res9;
    @FXML
    private TextField res10;
    @FXML
    private Label warningLabel;
    private final Map<String,Integer> gasMap = new HashMap<>();

    private final Double[] coefficientZ = {1.0, 0.5, 0.3, 0.0};



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gasMap.put("Ацетилен", 26);
        gasMap.put("Бутан", 58);
        gasMap.put("Бутен", 56);
        gasMap.put("Метан", 16);
        gasMap.put("Пропилен", 42);
        gasMap.put("Этан", 30);
        gasMap.put("Этилен", 28);
        pressureField.setTextFormatter(NumFormatter.getFormatter());
        volumeField.setTextFormatter(NumFormatter.getFormatter());
        gasConsumptionField.setTextFormatter(NumFormatter.getFormatter());
        closingTimeField.setTextFormatter(NumFormatter.getFormatter());
        maxPressureField.setTextFormatter(NumFormatter.getFormatter());
        maxP2Field.setTextFormatter(NumFormatter.getFormatter());
        lpodvField.setTextFormatter(NumFormatter.getFormatter());
        dodvField.setTextFormatter(NumFormatter.getFormatter());
        lotvField.setTextFormatter(NumFormatter.getFormatter());
        dotvField.setTextFormatter(NumFormatter.getFormatter());
        insideTempField.setTextFormatter(NumFormatter.getFormatter());
        outGasField.setTextFormatter(NumFormatter.getFormatter());
        inGasField.setTextFormatter(NumFormatter.getFormatter());
        airExchgField.setTextFormatter(NumFormatter.getFormatter());
        lengthField.setTextFormatter(NumFormatter.getFormatter());
        widthField.setTextFormatter(NumFormatter.getFormatter());
        heightField.setTextFormatter(NumFormatter.getFormatter());
        areaCoefField.setTextFormatter(NumFormatter.getFormatter());
        NoField.setTextFormatter(NumFormatter.getFormatter());
        NxField.setTextFormatter(NumFormatter.getFormatter());
        startPressureField.setTextFormatter(NumFormatter.getFormatter());

        for(String item : gasMap.keySet()) {
            dropDownList.getItems().add(item);
        }
        for(Double item : coefficientZ){
            dropDownListZ.getItems().add(String.valueOf(item));
        }
        dropDownListSteh.getItems().addAll(Task1Stehio.getNames());
        dropDownListSteh.setOnAction(this::getStehioValue);

    }

    public void getStehioValue(ActionEvent actionEvent){
        Task1Stehio stehio = Task1Stehio.getByName(dropDownListSteh.getValue());
        NcField = Double.valueOf(stehio.getNc());
        NhField = Double.valueOf(stehio.getNh());

    }

    public void fillResultingValues(){
        warningLabel.setText("");
        res1.setText(String.valueOf(gasMap.get(dropDownList.getValue())));
        res2.setText(String.valueOf(valuesStorage.getVa()));
        res3.setText(String.valueOf(valuesStorage.getV1m()));
        res4.setText(String.valueOf(valuesStorage.getV2m()));
        res5.setText(String.valueOf(valuesStorage.getRhoG()));
        res6.setText(String.valueOf(valuesStorage.getM()));
        res7.setText(String.valueOf(valuesStorage.getMstar()));
        res8.setText(String.valueOf(valuesStorage.getVsv()));
        res9.setText(String.valueOf(valuesStorage.getCsteh()));
        res10.setText(String.valueOf(valuesStorage.getDeltaP()));
    }

    public void onGetValues(ActionEvent actionEvent){
        try {
            valuesStorage.setVa(GasCalculator.calculateVa(appUtils.getDoubleFromField(pressureField), appUtils.getDoubleFromField(volumeField)));
            valuesStorage.setV1m(GasCalculator.calculateV1m(appUtils.getDoubleFromField(gasConsumptionField), appUtils.getDoubleFromField(closingTimeField)));
            valuesStorage.setV2m(GasCalculator.calculateV2m(appUtils.getDoubleFromField(maxP2Field), appUtils.getDoubleFromField(lpodvField),
                    appUtils.getDoubleFromField(dodvField), appUtils.getDoubleFromField(lotvField),
                    appUtils.getDoubleFromField(dotvField)));

            valuesStorage.setRhoG(GasCalculator.calculateRhoG(gasMap.get(dropDownList.getValue()), appUtils.getDoubleFromField(insideTempField)));
            valuesStorage.setM(GasCalculator.calculateM(appUtils.getDoubleFromField(inGasField), appUtils.getDoubleFromField(outGasField), valuesStorage.getRhoG()));
            valuesStorage.setMstar(GasCalculator.calculateMStar(valuesStorage.getM(), appUtils.getDoubleFromField(airExchgField), appUtils.getDoubleFromField(closingTimeField)));
            valuesStorage.setCoefZ(Double.parseDouble(dropDownListZ.getValue()));
            valuesStorage.setVsv(GasCalculator.calculateVsv(appUtils.getDoubleFromField(lengthField), appUtils.getDoubleFromField(widthField),
                    appUtils.getDoubleFromField(heightField), appUtils.getDoubleFromField(areaCoefField)));

            valuesStorage.setCsteh(GasCalculator.calculateCsteh(NcField, NhField, appUtils.getDoubleFromField(NxField), appUtils.getDoubleFromField(NoField)));

            valuesStorage.setDeltaP(GasCalculator.calculateDeltaP(appUtils.getDoubleFromField(maxPressureField),
                    appUtils.getDoubleFromField(startPressureField), valuesStorage.getMstar(),
                    valuesStorage.getCoefZ(), valuesStorage.getVsv(), valuesStorage.getRhoG(),
                    valuesStorage.getCsteh(), Double.valueOf(valuesStorage.getKn())));


            valuesStorage.setLength(appUtils.getDoubleFromField(lengthField));
            valuesStorage.setMolarMass(Double.valueOf(gasMap.get(dropDownList.getValue())));
            valuesStorage.setTemperature(appUtils.getDoubleFromField(insideTempField));
            valuesStorage.setWidth(appUtils.getDoubleFromField(widthField));
            valuesStorage.setHeight(appUtils.getDoubleFromField(heightField));
            valuesStorage.setSquare(valuesStorage.getLength() * valuesStorage.getWidth());
            valuesStorage.setAreaVolume(valuesStorage.getLength() * valuesStorage.getWidth() * valuesStorage.getHeight());
            valuesStorage.setAreaVolume(valuesStorage.getLength() * valuesStorage.getWidth() * valuesStorage.getHeight());
            valuesStorage.setAreaCoef(appUtils.getDoubleFromField(areaCoefField));
            valuesStorage.setGasName(dropDownList.getValue());
            valuesStorage.setNc(NcField);
            valuesStorage.setNh(NhField);
            valuesStorage.setNo(appUtils.getDoubleFromField(NoField));
            valuesStorage.setNx(appUtils.getDoubleFromField(NxField));
            valuesStorage.setContainerPressure(appUtils.getDoubleFromField(pressureField));
            valuesStorage.setContainerVolume(appUtils.getDoubleFromField(volumeField));
            valuesStorage.setGasConsumption(appUtils.getDoubleFromField(gasConsumptionField));
            valuesStorage.setClosingTime(appUtils.getDoubleFromField(closingTimeField));
            valuesStorage.setClosingTime(appUtils.getDoubleFromField(closingTimeField));
            valuesStorage.setMaxP2(appUtils.getDoubleFromField(maxP2Field));
            valuesStorage.setLotv(appUtils.getDoubleFromField(lotvField));
            valuesStorage.setLpodv(appUtils.getDoubleFromField(lpodvField));
            valuesStorage.setDotv(appUtils.getDoubleFromField(dotvField));
            valuesStorage.setDpodv(appUtils.getDoubleFromField(dodvField));








            fillResultingValues();
        }
        catch (Exception exception){
            exception.getCause();
            warningLabel.setText("Ошибка в веденных значениях! Введите корректные значения");
        }

    }

    public void onGenerateReport(ActionEvent actionEvent) {
        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Выберите куда сохранить отчет");
        file_chooser.setInitialFileName("Отчет_ГГ.pdf");
        File file = file_chooser.showSaveDialog(null);
        warningLabel.setText("choose file");
        String filePathVal = null;
        try {
            warningLabel.setText("Документ создается...");
            filePathVal = documentGenerator.generateReportGG(valuesStorage, file.getAbsolutePath(),warningLabel);
        } catch (Exception e) {
            warningLabel.setText(e.getMessage());
        }
        warningLabel.setText("Отчет создан " + filePathVal);
    }

    public void onClearValues(ActionEvent event){

        res1.clear();
        res2.clear();
        res3.clear();
        res4.clear();
        res5.clear();
        res6.clear();
        res7.clear();
        res8.clear();
        res9.clear();
        res10.clear();

        pressureField.clear();
        volumeField.clear();
        gasConsumptionField.clear();
        closingTimeField.clear();
        maxP2Field.clear();
        lpodvField.clear();
        dodvField.clear();
        lotvField.clear();
        dotvField.clear();
        insideTempField.clear();
        outGasField.clear();
        inGasField.clear();
        airExchgField.clear();
        lengthField.clear();
        widthField.clear();
        heightField.clear();
        areaCoefField.clear();
        NoField.clear();
        NxField.clear();
    }
}