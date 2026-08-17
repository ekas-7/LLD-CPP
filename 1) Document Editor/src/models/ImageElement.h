#pragma once

#include "DocumentElement.h"
#include <string>

using namespace std;

class ImageElement : public DocumentElement {
public:
    string imageUrl;

    ImageElement(string url) : DocumentElement(ElementType::Image) {
        imageUrl = url;
    }
};
