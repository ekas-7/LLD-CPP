package model.ElementTypes;

import model.Constants.ElementType;

public abstract class AbsractDocumentElement {
    private final ElementType type;

    protected AbsractDocumentElement(ElementType type) {
        this.type = type;
    }

    public ElementType getType() {
        return type;
    }
}
