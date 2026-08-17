package model.ElementTypes;

import model.Constants.ElementType;

public class TextElementAbsract extends AbsractDocumentElement {
    private final String text;

    public TextElementAbsract(String text) {
        super(ElementType.TEXT);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
