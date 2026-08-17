#pragma once

#include "DocumentElement.h"
#include <string>

using namespace std;

class TextElement : public DocumentElement {
public:
    string text;

    TextElement(string t) : DocumentElement(ElementType::Text) {
        text = t;
    }
};
