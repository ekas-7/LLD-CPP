import core.DocumentEditor;
import model.ElementTypes.ImageElement;
import model.ElementTypes.TextElement;
import util.DocumentPersistenceUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DocumentEditor editor = new DocumentEditor();

        editor.addElement(new TextElement("Hello World"));
        editor.addElement(new ImageElement("http://example.com/logo.png"));

        editor.renderAll();

        DocumentPersistenceUtil.saveToFile("document.txt", editor.getElements());
        DocumentPersistenceUtil.saveToJson("document.json", editor.getElements());
    }
}