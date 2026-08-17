#pragma once

#include "models/DocumentElement.h"
#include <vector>

using namespace std;

class DocumentEditor {
    vector<DocumentElement*> elements;

public:
    void addElement(DocumentElement* el);
    void renderAll() const;
    ~DocumentEditor();
};
