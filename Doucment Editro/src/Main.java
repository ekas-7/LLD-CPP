import core.DocumentEditor;
import model.ElementTypes.ImageElementAbsract;
import model.ElementTypes.TextElementAbsract;
import util.DocumentPersistenceUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DocumentEditor editor = new DocumentEditor();

        editor.addElement(new TextElementAbsract("Hello World"));
        editor.addElement(new ImageElementAbsract("http://example.com/logo.png"));

        editor.renderAll();

        DocumentPersistenceUtil.saveToFile("document.txt", editor.getElements());
        DocumentPersistenceUtil.saveToJson("document.json", editor.getElements());
    }
}