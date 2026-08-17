package util;

import model.Constants.ElementType;
import model.ElementTypes.AbsractDocumentElement;
import model.ElementTypes.ImageElementAbsract;
import model.ElementTypes.TextElementAbsract;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class DocumentPersistenceUtil {
    private DocumentPersistenceUtil() {
    }

    public static void saveToFile(String filePath, List<AbsractDocumentElement> elements) throws IOException {
        StringBuilder content = new StringBuilder();
        for (AbsractDocumentElement element : elements) {
            if (element.getType() == ElementType.TEXT) {
                TextElementAbsract textElement = (TextElementAbsract) element;
                content.append("Text: ").append(textElement.getText());
            } else if (element.getType() == ElementType.IMAGE) {
                ImageElementAbsract imageElement = (ImageElementAbsract) element;
                content.append("Image: ").append(imageElement.getImageUrl());
            }
            content.append(System.lineSeparator());
        }
        Files.writeString(Path.of(filePath), content.toString());
    }

    public static void saveToJson(String filePath, List<AbsractDocumentElement> elements) throws IOException {
        StringBuilder json = new StringBuilder();
        json.append("{\"elements\":[");
        for (int i = 0; i < elements.size(); i++) {
            AbsractDocumentElement element = elements.get(i);
            if (i > 0) {
                json.append(",");
            }

            if (element.getType() == ElementType.TEXT) {
                TextElementAbsract textElement = (TextElementAbsract) element;
                json.append("{\"type\":\"TEXT\",\"text\":\"")
                        .append(escapeJson(textElement.getText()))
                        .append("\"}");
            } else if (element.getType() == ElementType.IMAGE) {
                ImageElementAbsract imageElement = (ImageElementAbsract) element;
                json.append("{\"type\":\"IMAGE\",\"imageUrl\":\"")
                        .append(escapeJson(imageElement.getImageUrl()))
                        .append("\"}");
            }
        }
        json.append("]}");

        Files.writeString(Path.of(filePath), json.toString());
    }

    private static String escapeJson(String value) {
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
