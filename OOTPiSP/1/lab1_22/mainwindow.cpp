#include "mainwindow.h"
#include "ui_mainwindow.h"

#include <QPushButton>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    QPushButton *pb;
    pb = new QPushButton;
    QObject::connect(&pb, SIGNAL(clicked()), SLOT(openFile()));
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::openFile()
{

}

