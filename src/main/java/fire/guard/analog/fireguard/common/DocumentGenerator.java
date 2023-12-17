package fire.guard.analog.fireguard.common;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class DocumentGenerator {
    public String generateDoc(Map<String, Double> data, String reportCode) throws IOException {
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
}
