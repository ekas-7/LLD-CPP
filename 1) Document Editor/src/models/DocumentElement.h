#pragma once
#include "ElementType.h"

class DocumentElement {
public:
    ElementType type;

    DocumentElement(ElementType t) {
        type = t;
    }

    virtual ~DocumentElement() {}
};
