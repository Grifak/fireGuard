package fire.guard.analog.fireguard;

import fire.guard.analog.fireguard.calculator.Task2Calculator;
import fire.guard.analog.fireguard.common.ApplicationUtils;
import fire.guard.analog.fireguard.common.DocumentGenerator;
import fire.guard.analog.fireguard.common.NumFormatter;
import static fire.guard.analog.fireguard.enums.CacheConstants.AIR_SPEED;
import static fire.guard.analog.fireguard.enums.CacheConstants.EVAP_RATE;
import static fire.guard.analog.fireguard.enums.CacheConstants.EVAP_TIME;
import static fire.guard.analog.fireguard.enums.CacheConstants.EXCES_PRESS;
import static fire.guard.analog.fireguard.enums.CacheConstants.FREE_SPACE;
import static fire.guard.analog.fireguard.enums.CacheConstants.LIQUID_EVAP;
import static fire.guard.analog.fireguard.enums.CacheConstants.LIQUID_SPILL;
import static fire.guard.analog.fireguard.enums.CacheConstants.MASS_EVAP;
import static fire.guard.analog.fireguard.enums.CacheConstants.NU;
import static fire.guard.analog.fireguard.enums.CacheConstants.PIPE_LIQUID_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.PUMP_LIQUID_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.STECH_COEF;
import static fire.guard.analog.fireguard.enums.CacheConstants.STREEM_PRESS;
import static fire.guard.analog.fireguard.enums.CacheConstants.S_ROOM;
import static fire.guard.analog.fireguard.enums.CacheConstants.TECH_LIQUID_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.V;
import static fire.guard.analog.fireguard.enums.CacheConstants.VAPOUR_DENSITY;
import static fire.guard.analog.fireguard.enums.CacheConstants.VAPOUR_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.V_ROOM;
import fire.guard.analog.fireguard.enums.Task2Substance;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class Task2Controller implements Initializable {
    private Map<String, Double> cache;
    private Task2Calculator calculator;
    private ApplicationUtils appUtils;
    private Task2Substance substance;
    private final DocumentGenerator documentGenerator = new DocumentGenerator();

    @FXML
    private ChoiceBox<String> listTask2;
    @FXML
    private TextField molarMassField;
    @FXML
    private TextField densityField;
    //ПУНКТ 1
    @FXML
    private TextField capacityVol;
    @FXML
    private TextField pipeLenPodv;
    @FXML
    private TextField pipeLenOtv;
    @FXML
    private TextField coefFreeSpace;
    @FXML
    private TextField diameterPipelinePodv;
    @FXML
    private TextField diameterPipelineOtv;
    @FXML
    private TextField pipeLiquidMass;

    //ПУНКТ 2
    @FXML
    private TextField pumpFeed;
    @FXML
    private TextField shutOffTime;
    @FXML
    private TextField pumpLiquidMass;

    //ПУНКТ 3
    @FXML
    private TextField techLiquidMass;

    //ПУНКТ 4
    @FXML
    private TextField liquidSpill;

    //ПУНКТ 5
    @FXML
    private TextField lenRoom;
    @FXML
    private TextField wedRoom;
    @FXML
    private TextField heiRoom;
    @FXML
    private TextField sMirror;
    @FXML
    private TextField sOkr;
    @FXML
    private TextField liquidEvap;

    //ПУНКТ 6
    @FXML
    private TextField airExchange;
    @FXML
    private TextField formulaField;
    @FXML
    private ChoiceBox<Integer> tempList;
    @FXML
    private TextField antuanA;
    @FXML
    private TextField antuanB;
    @FXML
    private TextField antuanC;
    @FXML
    private TextField evapRate;

    //ПУНКТ 7
    @FXML
    private TextField evaporTime;

    //ПУНКТ 8
    @FXML
    private TextField vapourMass;

    //ПУНКТ 9
    @FXML
    private TextField freeSpace;

    //ПУНКТ 10
    @FXML
    private TextField vapourDensity;

    //ПУНКТ 11
    @FXML
    private TextField stechCoef;

    //ПУНКТ 12
    @FXML
    private TextField excesPress;

    //ПУНКТ 13
    @FXML
    private TextField category;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cache = new HashMap<>();
        appUtils = new ApplicationUtils();
        calculator = new Task2Calculator(appUtils);


        capacityVol.setTextFormatter(NumFormatter.getFormatter());
        pipeLenPodv.setTextFormatter(NumFormatter.getFormatter());
        pipeLenOtv.setTextFormatter(NumFormatter.getFormatter());
        coefFreeSpace.setTextFormatter(NumFormatter.getFormatter());
        diameterPipelinePodv.setTextFormatter(NumFormatter.getFormatter());
        diameterPipelineOtv.setTextFormatter(NumFormatter.getFormatter());
        pumpFeed.setTextFormatter(NumFormatter.getFormatter());
        shutOffTime.setTextFormatter(NumFormatter.getFormatter());
        lenRoom.setTextFormatter(NumFormatter.getFormatter());
        wedRoom.setTextFormatter(NumFormatter.getFormatter());
        heiRoom.setTextFormatter(NumFormatter.getFormatter());
        sOkr.setTextFormatter(NumFormatter.getFormatter());
        sMirror.setTextFormatter(NumFormatter.getFormatter());
        airExchange.setTextFormatter(NumFormatter.getFormatter());
        antuanA.setTextFormatter(NumFormatter.getFormatter());
        antuanB.setTextFormatter(NumFormatter.getFormatter());
        antuanC.setTextFormatter(NumFormatter.getFormatter());

        listTask2.getItems().addAll(Task2Substance.getNames());
        listTask2.setOnAction(this::getSubstanceValue);

        tempList.getItems().addAll(10, 15, 20, 30, 35);
    }

    public void getSubstanceValue(ActionEvent event){
        Task2Substance chooseSubstace = Task2Substance.getByName(listTask2.getValue());
        molarMassField.setText(chooseSubstace.getMolarMass().toString());
        formulaField.setText(chooseSubstace.getFormula());
        antuanA.setText(chooseSubstace.getAntuanA().toString());
        antuanB.setText(chooseSubstace.getAntuanB().toString());
        antuanC.setText(chooseSubstace.getAntuanC().toString());
        densityField.setText(chooseSubstace.getDensity().toString());

        substance = chooseSubstace;
    }


    private void calcFirstStep(ActionEvent event){
        Boolean fieldNotIsEmpty = appUtils.validateFields(capacityVol,
                pipeLenOtv, pipeLenPodv,
                coefFreeSpace, diameterPipelinePodv,
                diameterPipelineOtv, densityField,
                molarMassField);

        if(fieldNotIsEmpty){
            Double pipeLiquidMassCalc = calculator.calcPipeLiquidMass(densityField,
                    capacityVol, diameterPipelinePodv,
                    diameterPipelineOtv, coefFreeSpace,
                    pipeLenPodv, pipeLenOtv);
            cache.put(PIPE_LIQUID_MASS.getName(), pipeLiquidMassCalc);
            pipeLiquidMass.setText(pipeLiquidMassCalc.toString());
        }else {
            pipeLiquidMass.setText(null);
        }
    }


    private void calcSecondStep(ActionEvent event){
        Boolean fieldIsNotEmpty = appUtils.validateFields(pumpFeed, shutOffTime);
        if(fieldIsNotEmpty){
            Double calcPumpLiquidMass = calculator.calcPumpLiquidMass(densityField, pumpFeed, shutOffTime);
            cache.put(PUMP_LIQUID_MASS.getName(), calcPumpLiquidMass);
            pumpLiquidMass.setText(calcPumpLiquidMass.toString());

            Double calcTechLiquidMass = calculator.calcTechLiquidMass(pipeLiquidMass, pumpLiquidMass);
            cache.put(TECH_LIQUID_MASS.getName(), calcTechLiquidMass);
            techLiquidMass.setText(calcTechLiquidMass.toString());

            Double calcV = calculator.calcV(densityField, techLiquidMass);
            cache.put(V.getName(), calcV);
            Double calcLiquidSpill = calculator.calcLiquidSpill(densityField, techLiquidMass);
            cache.put(LIQUID_SPILL.getName(), calcLiquidSpill);
            liquidSpill.setText(calcLiquidSpill.toString());
        }else {
            pumpLiquidMass.setText(null);
        }
    }


    private void calFifthStep(ActionEvent event){
        Boolean fieldIsNotEmpty = appUtils.validateFields(sMirror, sOkr, lenRoom, heiRoom, wedRoom);
        if (fieldIsNotEmpty){
            Double sRoom = calculator.calcSRoom(lenRoom, wedRoom);
            Double vRoom = calculator.calcVRoom(sRoom, heiRoom);
            cache.put(S_ROOM.getName(), sRoom);
            cache.put(V_ROOM.getName(), vRoom);

            Double calcLiquidEvap = calculator.calcLiquidEvap(sRoom, sOkr, sMirror);
            cache.put(LIQUID_EVAP.getName(), calcLiquidEvap);
            liquidEvap.setText(calcLiquidEvap.toString());
        }else {
            liquidEvap.setText(null);
        }
    }


    private void calcSixthStep(ActionEvent event){
        Boolean fieldIsNotEmpty = appUtils.validateFields(airExchange, lenRoom, antuanA, antuanB, antuanC);
        Double tempVal = tempList.getValue().doubleValue();
        fieldIsNotEmpty = fieldIsNotEmpty && (tempVal != null);

        if(fieldIsNotEmpty) {
            Double airSpeed = calculator.caclAirSpeed(lenRoom, airExchange);
            cache.put(AIR_SPEED.getName(), airSpeed);
            airSpeed = calculator.interpolationAirSpeed(airSpeed, tempVal);
            cache.put(NU.getName(), airSpeed);

            Double streamPress = calculator.calcStreamPress(antuanA, antuanB, antuanC, tempVal);
            cache.put(STREEM_PRESS.getName(), streamPress);

            Double molarMass = appUtils.getDoubleFromField(molarMassField);
            Double evapRateVal = calculator.calcEvapRate(molarMass, streamPress, airSpeed);

            cache.put(EVAP_RATE.getName(), evapRateVal);
            evapRate.setText(evapRateVal.toString());

            Double evapTimeVal = calculator.calcEvapTime(cache.get(TECH_LIQUID_MASS.getName()), cache.get(LIQUID_EVAP.getName()), evapRateVal);
            cache.put(EVAP_TIME.getName(), evapTimeVal);
            evaporTime.setText(evapTimeVal.toString());

            Double massEvap = calculator.calcMassEvap(cache.get(LIQUID_EVAP.getName()), evapRateVal);
            cache.put(MASS_EVAP.getName(), massEvap);

            Double vapourMassVal = calculator.calcVapourMass(massEvap, evapTimeVal, airExchange);
            cache.put(VAPOUR_MASS.getName(), vapourMassVal);
            vapourMass.setText(vapourMassVal.toString());

            Double freeSpaceVal = calculator.calcFreeSpace(cache.get(V_ROOM.getName()));
            cache.put(FREE_SPACE.getName(), freeSpaceVal);
            freeSpace.setText(freeSpaceVal.toString());


            Double vapourDensityVal = calculator.calcVapourDensity(molarMassField);
            cache.put(VAPOUR_DENSITY.getName(), vapourDensityVal);
            vapourDensity.setText(vapourDensityVal.toString());

            Double stechCoefVal = calculator.calcStechCoef(substance);
            cache.put(STECH_COEF.getName(), stechCoefVal);
            stechCoef.setText(stechCoefVal.toString());

            Double excesPressVal = calculator.calcExcesPress(vapourMassVal, freeSpaceVal, vapourDensityVal, stechCoefVal);
            cache.put(EXCES_PRESS.getName(), excesPressVal);
            excesPress.setText(excesPressVal.toString());

        }else {
            evapRate.setText(null);
        }

    }

    @FXML
    private void calk(ActionEvent event){
        calcFirstStep(event);
        calcSecondStep(event);
        calFifthStep(event);
        calcSixthStep(event);
    }

    @FXML
    private void generateDoc(ActionEvent event){
        FileChooser fil_chooser = new FileChooser();
        fil_chooser.setTitle("Select File");
        fil_chooser.setInitialFileName("Отчет_ЛВЖ.docx");
        File file = fil_chooser.showSaveDialog(null);

        try {
            documentGenerator.generateDocLVG(cache, file.getAbsolutePath());
        } catch (IOException e) {

        }
    }

    @FXML
    private void cleanFieds(ActionEvent event){
        listTask2.setValue(null);
        molarMassField.setText(null);
        densityField.setText(null);
        capacityVol.setText(null);
        pipeLenPodv.setText(null);
        pipeLenOtv.setText(null);
        coefFreeSpace.setText(null);
        diameterPipelinePodv.setText(null);
        diameterPipelineOtv.setText(null);
        pipeLiquidMass.setText(null);
        pumpFeed.setText(null);
        shutOffTime.setText(null);
        pumpLiquidMass.setText(null);
        techLiquidMass.setText(null);
        liquidSpill.setText(null);
        lenRoom.setText(null);
        wedRoom.setText(null);
        heiRoom.setText(null);
        sMirror.setText(null);
        sOkr.setText(null);
        liquidEvap.setText(null);
        airExchange.setText(null);
        formulaField.setText(null);
        tempList.setValue(0);
        antuanA.setText(null);
        antuanB.setText(null);
        antuanC.setText(null);
        evapRate.setText(null);
        evaporTime.setText(null);
        vapourMass.setText(null);
        freeSpace.setText(null);
        vapourDensity.setText(null);
        stechCoef.setText(null);
        excesPress.setText(null);
    }

}
