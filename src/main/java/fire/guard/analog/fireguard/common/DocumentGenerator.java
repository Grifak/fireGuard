package fire.guard.analog.fireguard.common;

import com.aspose.words.Document;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import fire.guard.analog.fireguard.ValuesStorage;
import fire.guard.analog.fireguard.enums.CacheConstants;
import java.net.URL;
import java.util.stream.Collectors;
import javafx.scene.control.Label;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DocumentGenerator {
    public void generateDocLVG(Map<String, Double> data, String filePathPdf, String substanceName) throws Exception {
        Map<String, String> result = data.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> String.valueOf(e.getValue())));

        result.put(CacheConstants.SUBSTANCE_NAME.getName(), substanceName);
        URL resource = DocumentGenerator.class.getClassLoader().getResource("templates/template_LVG.docx");
        XWPFTemplate template = XWPFTemplate.compile(resource.getPath())
                .render(result);
        NiceXWPFDocument document = template.getXWPFDocument();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        String filePathDocx = filePathPdf.replace(".pdf", ".docx");
        File file = new File(filePathDocx);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(baos.toByteArray());
        outputStream.close();
        Document doc = new Document(filePathDocx);
        doc.save(filePathPdf);
    }

    public String generateReportGG(ValuesStorage storage, String filePathPdf, Label warningLabel) throws IOException {
        Double kntmp = 3.0;//try include in map)))))
        Map<String, String> data = getStringDoubleMap(storage);

        try {
            warningLabel.setText("Создается отчет...");
            URL resource = DocumentGenerator.class.getClassLoader().getResource("templates/template_GG.docx");
            XWPFTemplate template = XWPFTemplate.compile(resource.getPath())
                    .render(data);
            NiceXWPFDocument document = template.getXWPFDocument();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.write(baos);
            String filePathDocx = filePathPdf.replace(".pdf", ".docx");
            File file = new File(filePathDocx);
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(baos.toByteArray());
            outputStream.close();

            Document doc = new Document(filePathDocx);
            doc.save(filePathPdf);
            return file.getAbsolutePath();
        }catch (Exception e){
            warningLabel.setText(e.getMessage());
            throw new IOException(e.getMessage());
        }

    }

    private static Map<String, String> getStringDoubleMap(ValuesStorage storage) {
        Map<String, String> data = new HashMap<>();
        data.put("Va", storage.getVa().toString());
        data.put("V1m", storage.getV1m().toString());
        data.put("V2m", storage.getV2m().toString());
        data.put("rhoG", storage.getRhoG().toString());
        data.put("mass", storage.getM().toString());
        data.put("Mstar", storage.getMstar().toString());
        data.put("coefZ", storage.getCoefZ().toString());
        data.put("Vsv", storage.getVsv().toString());
        data.put("Csteh", storage.getCsteh().toString());
        data.put("deltaP", storage.getDeltaP().toString());
        data.put("length", storage.getLength().toString());
        data.put("width", storage.getWidth().toString());
        data.put("height", storage.getHeight().toString());
        data.put("square", storage.getSquare().toString());
        data.put("areaVolume", storage.getAreaVolume().toString());
        data.put("temperature", storage.getTemperature().toString());
        data.put("areaCoef", storage.getAreaCoef().toString());
        data.put("gasName", storage.getGasName());
        data.put("Nc", storage.getNc().toString());
        data.put("Nh", storage.getNh().toString());
        data.put("No", storage.getNo().toString());
        data.put("Nx", storage.getNx().toString());
        data.put("containerPressure",storage.getContainerPressure().toString());
        data.put("containerVolume",storage.getContainerVolume().toString());
        data.put("gasConsumption",storage.getGasConsumption().toString());
        data.put("closingTime",storage.getClosingTime().toString());
        data.put("maxP2",storage.getMaxP2().toString());
        data.put("lpodv",storage.getLpodv().toString());
        data.put("lotv",storage.getLotv().toString());
        data.put("dpodv",storage.getDpodv().toString());
        data.put("dotv",storage.getDotv().toString());
        data.put("molarMass", storage.getMolarMass().toString());

        data.put("Kn", String.valueOf(3.0));///XD ))))))))))) legacy joke
        return data;
    }
}
