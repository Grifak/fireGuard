package fire.guard.analog.fireguard.common;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import fire.guard.analog.fireguard.ValuesStorage;
import javafx.scene.control.Label;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DocumentGenerator {
    public void generateDocLVG(Map<String, Double> data, String filePath) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("C:\\Users\\makun\\IdeaProjects\\fireGuard\\src\\main\\resources\\templates\\template_LVG.docx")
                .render(data);
        NiceXWPFDocument document = template.getXWPFDocument();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        File file = new File(filePath);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(baos.toByteArray());
        outputStream.close();
    }

    public String generateReportGG(ValuesStorage storage, String filepath, Label warningLabel) throws IOException {
        Double kntmp = 3.0;//try include in map)))))
        Map<String, Double> data = getStringDoubleMap(storage);

        try {
            warningLabel.setText("Создается отчет...");
            XWPFTemplate template = XWPFTemplate.compile("C:\\Users\\makun\\IdeaProjects\\fireGuard\\src\\main\\resources\\templates\\reportGGtemplate.docx")
                    .render(data);
            NiceXWPFDocument document = template.getXWPFDocument();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.write(baos);
            File file = new File(filepath);
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(baos.toByteArray());
            outputStream.close();
            return file.getAbsolutePath();
        }catch (Exception e){
            warningLabel.setText(e.getMessage());
            throw new IOException(e.getMessage());
        }

    }

    private static Map<String, Double> getStringDoubleMap(ValuesStorage storage) {
        Map<String, Double> data = new HashMap<>();
        data.put("Va", storage.getVa());
        data.put("V1m", storage.getV1m());
        data.put("V2m", storage.getV2m());
        data.put("rhoG", storage.getRhoG());
        data.put("mass", storage.getM());
        data.put("Mstar", storage.getMstar());
        data.put("coefZ", storage.getCoefZ());
        data.put("Vsv", storage.getVsv());
        data.put("Csteh", storage.getCsteh());
        data.put("deltaP", storage.getDeltaP());

        data.put("Kn", 3.0);///XD ))))))))))) legacy joke
        return data;
    }
}
