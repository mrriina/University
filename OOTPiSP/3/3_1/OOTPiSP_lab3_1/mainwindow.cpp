#include "mainwindow.h"
#include "ui_mainwindow.h"

#include <QMessageBox>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_lineEdit_editingFinished()
{
    if(ui->lineEdit->text().toInt() < 999 && ui->lineEdit->text().toInt() > -999) {
        if(ui->lineEdit->text() == '0'){
            QMessageBox::critical(this, "Информационное сообщение", "Нулевое число");
        }
        else if (!(ui->lineEdit->text().toInt())){
            QMessageBox::critical(this, "Неправильный формат ввода", "Введите число от -999 до 999");
        }
        else {
            if(ui->lineEdit->text().toInt()>0) {
                if(ui->lineEdit->text().toInt()<10) QMessageBox::critical(this, "Информационное сообщение", "Положительное однозначное число");
                else if(ui->lineEdit->text().toInt()/10<10) QMessageBox::critical(this, "Информационное сообщение", "Положительное двузначное число");
                else if(ui->lineEdit->text().toInt()/100<10) QMessageBox::critical(this, "Информационное сообщение", "Положительное трехзначное число");
            } else {
                if(ui->lineEdit->text().toInt()>-10) QMessageBox::critical(this, "Информационное сообщение", "Отрицательное однозначное число");
                else if(ui->lineEdit->text().toInt()/10>-10) QMessageBox::critical(this, "Информационное сообщение", "Отрицательное двузначное число");
                else if(ui->lineEdit->text().toInt()/100>-10) QMessageBox::critical(this, "Информационное сообщение", "Отрицательное трехзначное число");
            }
        }
    }
    else {
        QMessageBox::critical(this, "Неправильный ввод", "Введите число от -999 до 999");
    }

}

