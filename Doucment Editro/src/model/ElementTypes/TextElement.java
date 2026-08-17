package model.ElementTypes;

import model.Constants.ElementType;

public class TextElement extends DocumentElement {
    private final String text;

    public TextElement(String text) {
        super(ElementType.TEXT);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
