package core;

import model.Constants.ElementType;
import model.ElementTypes.DocumentElement;
import model.ElementTypes.ImageElement;
import model.ElementTypes.TextElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentEditor {
    private final List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public List<DocumentElement> getElements() {
        return elements;
    }

    public void renderAll() {
        for (DocumentElement element : elements) {
            if (element.getType() == ElementType.TEXT) {
                TextElement textElement = (TextElement) element;
                System.out.println("Text: " + textElement.getText());
            } else if (element.getType() == ElementType.IMAGE) {
                ImageElement imageElement = (ImageElement) element;
                System.out.println("Image: " + imageElement.getImageUrl());
            }
        }
    }
}
