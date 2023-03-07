#include "texteditor.h"

#include <QApplication>

int main(int argc, char *argv[]) {
    QApplication a(argc, argv);
    TextEditor w;
    a.setApplicationName("Text Editor");
    a.setApplicationVersion("0.1");
    a.setOrganizationName("ExampleSoft");
    a.setOrganizationDomain("example.com");
    a.setWindowIcon(QIcon(":/Resources/new.png"));
    w.show();
    return a.exec();
}
