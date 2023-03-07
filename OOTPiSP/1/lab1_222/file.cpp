#include "file.h"

#include <QGridLayout>
#include <QHBoxLayout>
#include <QTextEdit>
#include <QPushButton>
#include <QFileDialog>

File::File(QWidget *parent): QWidget(parent)
{
    QGridLayout *layout = new QGridLayout;
    setLayout(layout);

    QHBoxLayout *text_layout = new QHBoxLayout;
    QHBoxLayout *button_layout = new QHBoxLayout;

    layout->addLayout(text_layout, 0, 0);
    layout->addLayout(button_layout, 1, 0);

    text->resize(5, 5);
    text_layout->addWidget(text);

    QPushButton *button = new QPushButton("open file");
    button_layout->addWidget(button);


    QObject::connect(button,SIGNAL(clicked()), SLOT(openFile()));
}

void File::openFile() {
    QString s = QFileDialog::getOpenFileName();
    QFile opFile(s);
    opFile.open(QIODevice::ReadOnly);
    QString content = opFile.readAll();
    opFile.close();
    text->setText(content);
}
