package model.ElementTypes;

import model.Constants.ElementType;

public class ImageElementAbsract extends AbsractDocumentElement {
    private final String imageUrl;

    public ImageElementAbsract(String imageUrl) {
        super(ElementType.IMAGE);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
