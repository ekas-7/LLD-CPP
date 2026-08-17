#include "core/DocumentEditor.h"
#include "models/TextElement.h"
#include "models/ImageElement.h"
#include <iostream>

using namespace std;

void DocumentEditor::addElement(DocumentElement* el) {
    elements.push_back(el);
}

void DocumentEditor::renderAll() const {
    for (DocumentElement* el : elements) {
        if (el->type == ElementType::Text) {
            TextElement* textEl = (TextElement*)el;
            cout << "Text: " << textEl->text << endl;
        } else if (el->type == ElementType::Image) {
            ImageElement* imageEl = (ImageElement*)el;
            cout << "Image: " << imageEl->imageUrl << endl;
        }
    }
}

DocumentEditor::~DocumentEditor() {
    for (DocumentElement* el : elements) {
        delete el;
    }
}
