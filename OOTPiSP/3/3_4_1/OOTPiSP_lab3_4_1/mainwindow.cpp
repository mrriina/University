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
        st.append(rand() % 80 - 10);
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
    int k = 9;
    for(int i = 0; i < 5; i++){
        st[i] = st[i]*st[k];
        k--;

        output.append(QString::number(st[i]) + " ");
    }
    ui->lineEdit_2->setText(output);
}
