package core;

import model.Constants.ElementType;
import model.ElementTypes.AbsractDocumentElement;
import model.ElementTypes.ImageElementAbsract;
import model.ElementTypes.TextElementAbsract;

import java.util.ArrayList;
import java.util.List;

public class DocumentEditor {
    private final List<AbsractDocumentElement> elements = new ArrayList<>();

    public void addElement(AbsractDocumentElement element) {
        elements.add(element);
    }

    public List<AbsractDocumentElement> getElements() {
        return elements;
    }

    public void renderAll() {
        for (AbsractDocumentElement element : elements) {
            if (element.getType() == ElementType.TEXT) {
                TextElementAbsract textElement = (TextElementAbsract) element;
                System.out.println("Text: " + textElement.getText());
            } else if (element.getType() == ElementType.IMAGE) {
                ImageElementAbsract imageElement = (ImageElementAbsract) element;
                System.out.println("Image: " + imageElement.getImageUrl());
            }
        }
    }
}
