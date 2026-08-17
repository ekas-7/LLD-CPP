package model.ElementTypes;

import model.Constants.ElementType;

public class ImageElement extends DocumentElement {
    private final String imageUrl;

    public ImageElement(String imageUrl) {
        super(ElementType.IMAGE);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
