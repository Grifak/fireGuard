package fire.guard.analog.fireguard.common;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import fire.guard.analog.fireguard.ValuesStorage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DocumentGenerator {
    public String generateDocLVG(Map<String, Double> data, String reportCode) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("/Users/notremembering/IdeaProjects/fireGuardMaven/src/main/resources/reports/template_LVG.docx").render(data);
        NiceXWPFDocument document = template.getXWPFDocument();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        File file = new File( "/Users/notremembering/IdeaProjects/fireGuardMaven/src/main/resources/reports/tmp.docx");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(baos.toByteArray());
        outputStream.close();

        return file.getAbsolutePath();
    }

    public String generateReportGG(ValuesStorage storage, String reportCode) throws IOException {
        Double kntmp = 3.0;//try include in map)))))
        Map<String, Double> data = getStringDoubleMap(storage);

        XWPFTemplate template = XWPFTemplate.compile("C:\\Users\\makun\\IdeaProjects\\fireGuard\\src\\main\\resources\\reports\\reportGGtemplate.docx")
                .render(data);
        NiceXWPFDocument document = template.getXWPFDocument();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        File file = new File( "C:\\Users\\makun\\IdeaProjects\\fireGuard\\src\\main\\resources\\reports\\reportGG.docx");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(baos.toByteArray());
        outputStream.close();

        return file.getAbsolutePath();
    }

    private static Map<String, Double> getStringDoubleMap(ValuesStorage storage) {
        Map<String, Double> data = new HashMap<>(Map.of("Va", storage.getVa(),
                "V1m", storage.getV1m(),
                "V2m", storage.getV2m(),
                "rhoG", storage.getRhoG(),
                "mass", storage.getM(),
                "Mstar", storage.getMstar(),
                "coefZ", storage.getCoefZ(),
                "Vsv", storage.getVsv(),
                "Csteh", storage.getCsteh(),
                "deltaP", storage.getDeltaP()));

        data.put("Kn", 3.0);///XD ))))))))))) legacy joke
        return data;
    }
}
