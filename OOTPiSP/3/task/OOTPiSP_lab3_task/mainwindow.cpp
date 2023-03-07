#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    QMap<QString, int> map1;
    map1["apple"] = 1;
    map1["banana"] = 2;
    map1["orange"] = 3;
    QString str;
    QMap<QString, int>::iterator it1 = map1.begin();//переносим итератор на начало словаря
    for(; it1 != map1.end(); ++it1) {
        str.append(it1.key()+" ");
    }
    ui->lineEdit->setText(str);

}

MainWindow::~MainWindow()
{
    delete ui;
}

