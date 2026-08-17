# Requirements

Support Text and Image **right** now
but should support other types of content in the future, such as video, audio, and interactive elements.

# Approach
- Top Down
- Bottom Up

We will use bottom up for this project.

We should keep List of Text and Image .

Text ---> String </br>
Image ---> Image URL (Path)

# Bad Design
```
Class DocumentEditor{
 vector<element> elements;
    void addText(string text);
    void addImage(string imageUrl);
    void removeElement(int index);
    void editElement(int index, string newTextOrImageUrl);
    void saveToFile(string filePath);
}
```

# Good Design
## Document Element
```
Abstract class DocumentElement {
    virtual void render() = 0;

}
```
Text Element
```
Class TextElement : public DocumentElement {
    string text;
    void render() override;

}
```

Image Element
```
Class ImageElement : public DocumentElement {
    string imageUrl;
    void render() override;

}
```      
# Document Editor
```
Class DocumentEditor {
    vector<DocumentElement*> elements;
    void addElement(DocumentElement* element);
    void removeElement(int index);
    void editElement(int index, DocumentElement* newElement);
}
```

# Persistence
```
Abstract class DocumentPersistence {
    virtual void saveToFile(string filePath, vector<DocumentElement*> elements) = 0;
}
```

Save to File Implementation
```
Class JSONDocumentPersistence : public DocumentPersistence {
    void saveToFile(string filePath, vector<DocumentElement*> elements) override;
}
```

Save to Database Implementation
```
Class DatabaseDocumentPersistence : public DocumentPersistence {
    void saveToFile(string filePath, vector<DocumentElement*> elements) override;
}
```

# Main class 
DocumentEditorClient
```  
class DocumentEditorClient {
    DocumentEditor editor;
    DocumentPersistence* persistence;

    void setPersistence(DocumentPersistence* persistence);
    void addText(string text);
    void addImage(string imageUrl);
    void removeElement(int index);
    void editElement(int index, DocumentElement* newElement);
    void saveDocument(string filePath);
    void renderDocument();
}
```