#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    srand(time(0));
    QString output;
    //добавляем элементы в стек и выводим
    for(int i = 0; i < 10; i++){
        st.append(rand() % 50 - 10);
        output.append(QString::number(st[i]) + " ");
    }
    ui->lineEdit->setText(output);
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_pushButton_clicked()
{
    QString output;
    //если элемент > 0, меняем его на 1, иначе -1 и выводим
    for(int i = 0; i < 9; i++){
        st[i] = (st[i]+st[i+1])/2;

        output.append(QString::number(st[i]) + " ");
    }
    ui->lineEdit_2->setText(output);
}
