package fire.guard.analog.fireguard;

import fire.guard.analog.fireguard.calculator.LvgCalculator;
import fire.guard.analog.fireguard.common.ApplicationUtils;
import fire.guard.analog.fireguard.common.DocumentGenerator;
import static fire.guard.analog.fireguard.enums.CacheConstants.AIR_EXCHANGE;
import static fire.guard.analog.fireguard.enums.CacheConstants.AIR_SPEED;
import static fire.guard.analog.fireguard.enums.CacheConstants.ANTUANA_A;
import static fire.guard.analog.fireguard.enums.CacheConstants.ANTUANA_B;
import static fire.guard.analog.fireguard.enums.CacheConstants.ANTUANA_C;
import static fire.guard.analog.fireguard.enums.CacheConstants.CAPACITY_VOL;
import static fire.guard.analog.fireguard.enums.CacheConstants.COEF_FREE_SPACE;
import static fire.guard.analog.fireguard.enums.CacheConstants.DENSITY;
import static fire.guard.analog.fireguard.enums.CacheConstants.DIAMETER_PIPELINE_ODV;
import static fire.guard.analog.fireguard.enums.CacheConstants.DIAMETER_PIPELINE_PODV;
import static fire.guard.analog.fireguard.enums.CacheConstants.EVAP_RATE;
import static fire.guard.analog.fireguard.enums.CacheConstants.EVAP_TIME;
import static fire.guard.analog.fireguard.enums.CacheConstants.EXCES_PRESS;
import static fire.guard.analog.fireguard.enums.CacheConstants.FREE_SPACE;
import static fire.guard.analog.fireguard.enums.CacheConstants.LIQUID_EVAP;
import static fire.guard.analog.fireguard.enums.CacheConstants.LIQUID_SPILL;
import static fire.guard.analog.fireguard.enums.CacheConstants.MASS_EVAP;
import static fire.guard.analog.fireguard.enums.CacheConstants.MOLAR_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.NU;
import static fire.guard.analog.fireguard.enums.CacheConstants.N_C;
import static fire.guard.analog.fireguard.enums.CacheConstants.N_H;
import static fire.guard.analog.fireguard.enums.CacheConstants.N_O;
import static fire.guard.analog.fireguard.enums.CacheConstants.N_X;
import static fire.guard.analog.fireguard.enums.CacheConstants.PIPE_LEN_ODV;
import static fire.guard.analog.fireguard.enums.CacheConstants.PIPE_LEN_PODV;
import static fire.guard.analog.fireguard.enums.CacheConstants.PIPE_LIQUID_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.PUMP_FEED;
import static fire.guard.analog.fireguard.enums.CacheConstants.PUMP_LIQUID_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.ROOM_HEIGHT;
import static fire.guard.analog.fireguard.enums.CacheConstants.ROOM_LEN;
import static fire.guard.analog.fireguard.enums.CacheConstants.ROOM_TEMP;
import static fire.guard.analog.fireguard.enums.CacheConstants.ROOM_WEIGHT;
import static fire.guard.analog.fireguard.enums.CacheConstants.SHUT_OFF_TIME;
import static fire.guard.analog.fireguard.enums.CacheConstants.STECH_COEF;
import static fire.guard.analog.fireguard.enums.CacheConstants.STREEM_PRESS;
import static fire.guard.analog.fireguard.enums.CacheConstants.S_MIRROR;
import static fire.guard.analog.fireguard.enums.CacheConstants.S_OKR;
import static fire.guard.analog.fireguard.enums.CacheConstants.S_ROOM;
import static fire.guard.analog.fireguard.enums.CacheConstants.TECH_LIQUID_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.V;
import static fire.guard.analog.fireguard.enums.CacheConstants.VAPOUR_DENSITY;
import static fire.guard.analog.fireguard.enums.CacheConstants.VAPOUR_MASS;
import static fire.guard.analog.fireguard.enums.CacheConstants.V_ROOM;
import fire.guard.analog.fireguard.enums.Task2Substance;
import java.io.File;
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
    private LvgCalculator calculator;
    private ApplicationUtils appUtils;
    private Task2Substance substance;
    private DocumentGenerator documentGenerator;

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

    @FXML
    private Label warningLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cache = new HashMap<>();
        appUtils = new ApplicationUtils();
        calculator = new LvgCalculator(appUtils);
        documentGenerator = new DocumentGenerator();

        capacityVol.setTextFormatter(ApplicationUtils.getFormatter());
        pipeLenPodv.setTextFormatter(ApplicationUtils.getFormatter());
        pipeLenOtv.setTextFormatter(ApplicationUtils.getFormatter());
        coefFreeSpace.setTextFormatter(ApplicationUtils.getFormatter());
        diameterPipelinePodv.setTextFormatter(ApplicationUtils.getFormatter());
        diameterPipelineOtv.setTextFormatter(ApplicationUtils.getFormatter());
        pumpFeed.setTextFormatter(ApplicationUtils.getFormatter());
        shutOffTime.setTextFormatter(ApplicationUtils.getFormatter());
        lenRoom.setTextFormatter(ApplicationUtils.getFormatter());
        wedRoom.setTextFormatter(ApplicationUtils.getFormatter());
        heiRoom.setTextFormatter(ApplicationUtils.getFormatter());
        sOkr.setTextFormatter(ApplicationUtils.getFormatter());
        sMirror.setTextFormatter(ApplicationUtils.getFormatter());
        airExchange.setTextFormatter(ApplicationUtils.getFormatter());
        antuanA.setTextFormatter(ApplicationUtils.getFormatter());
        antuanB.setTextFormatter(ApplicationUtils.getFormatter());
        antuanC.setTextFormatter(ApplicationUtils.getFormatter());

        listTask2.getItems().addAll(Task2Substance.getNames());
        listTask2.setOnAction(this::getSubstanceValue);

        tempList.getItems().addAll(10, 15, 20, 30, 35);
    }
    @FXML
    private void calk(ActionEvent event){
        calcFirstStep(event);
        calcSecondStep(event);
        calFifthStep(event);
        calcSixthStep(event);
        cache.put(ROOM_LEN.getName(), appUtils.getDoubleFromField(lenRoom));
        cache.put(ROOM_WEIGHT.getName(), appUtils.getDoubleFromField(wedRoom));
        cache.put(ROOM_HEIGHT.getName(), appUtils.getDoubleFromField(heiRoom));
        cache.put(CAPACITY_VOL.getName(), appUtils.getDoubleFromField(capacityVol));
        cache.put(COEF_FREE_SPACE.getName(), appUtils.getDoubleFromField(coefFreeSpace));
        cache.put(PUMP_FEED.getName(), appUtils.getDoubleFromField(pumpFeed));
        cache.put(S_MIRROR.getName(), appUtils.getDoubleFromField(sMirror));
        cache.put(S_OKR.getName(), appUtils.getDoubleFromField(sOkr));
        cache.put(FREE_SPACE.getName(), appUtils.getDoubleFromField(freeSpace));
        cache.put(ROOM_TEMP.getName(), tempList.getValue().doubleValue());
        cache.put(SHUT_OFF_TIME.getName(), appUtils.getDoubleFromField(shutOffTime));
        cache.put(AIR_EXCHANGE.getName(), appUtils.getDoubleFromField(airExchange));
        cache.put(MOLAR_MASS.getName(), appUtils.getDoubleFromField(molarMassField));
        cache.put(DENSITY.getName(), appUtils.getDoubleFromField(densityField));
        cache.put(ANTUANA_A.getName(), appUtils.getDoubleFromField(antuanA));
        cache.put(ANTUANA_B.getName(), appUtils.getDoubleFromField(antuanB));
        cache.put(ANTUANA_C.getName(), appUtils.getDoubleFromField(antuanC));
        cache.put(N_C.getName(), substance.getNC().doubleValue());
        cache.put(N_O.getName(), substance.getNO().doubleValue());
        cache.put(N_X.getName(), substance.getNX().doubleValue());
        cache.put(N_H.getName(), substance.getNH().doubleValue());
        cache.put(PIPE_LEN_ODV.getName(), appUtils.getDoubleFromField(pipeLenOtv));
        cache.put(PIPE_LEN_PODV.getName(), appUtils.getDoubleFromField(pipeLenPodv));
        cache.put(DIAMETER_PIPELINE_PODV.getName(), appUtils.getDoubleFromField(diameterPipelinePodv));
        cache.put(DIAMETER_PIPELINE_ODV.getName(), appUtils.getDoubleFromField(diameterPipelineOtv));
    }

    @FXML
    private void generateDoc(ActionEvent event){
        FileChooser fil_chooser = new FileChooser();
        fil_chooser.setTitle("Select File");
        fil_chooser.setInitialFileName("Отчет_ЛВЖ.pdf");
        File file = fil_chooser.showSaveDialog(null);

        try {
            warningLabel.setText("Документ создается...");
            String filePath = documentGenerator.generateDocLVG(cache, file.getAbsolutePath(), substance.getName());
            warningLabel.setText("Отчет создан: " + filePath);
        }catch (Exception e) {
            warningLabel.setText(e.getMessage());
            throw new RuntimeException(e);
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
            warningLabel.setText("Недостаточно данных. Заполните все поля");
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
            warningLabel.setText("Недостаточно данных. Заполните все поля");
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
            warningLabel.setText("Недостаточно данных. Заполните все поля");
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
            warningLabel.setText("Недостаточно данных. Заполните все поля");
        }

    }
}
