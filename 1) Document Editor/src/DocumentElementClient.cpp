#include "core/DocumentEditor.h"
#include "models/TextElement.h"
#include "models/ImageElement.h"

using namespace std;

int main() {
    DocumentEditor editor;

    editor.addElement(new TextElement("Hello World"));
    editor.addElement(new ImageElement("http://example.com/logo.png"));

    editor.renderAll();

    return 0;
}
