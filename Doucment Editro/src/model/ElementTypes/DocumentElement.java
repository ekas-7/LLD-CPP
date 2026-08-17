package model.ElementTypes;

import model.Constants.ElementType;

public abstract class DocumentElement {
    private final ElementType type;

    protected DocumentElement(ElementType type) {
        this.type = type;
    }

    public ElementType getType() {
        return type;
    }
}
