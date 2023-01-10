#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    QString output;
    srand(time(0));
    //добавялем элемнты в список1
    for(int i = 0; i < 10; i++){
        list1.append(rand() % 90);
    }
    //выводим список1
    QList<int>::iterator it = list1.begin();
    for(; it != list1.end(); ++it)
        output.append(QString::number(*it) + " ");
    ui->lineEdit->setText(output);
    output.clear();

    //добавялем элемнты в список2
    for(int i = 0; i < 10; i++){
        list2.append(rand() % 90);
    }
    //выводим список2
    it = list2.begin();
    for(; it != list2.end(); ++it)
        output.append(QString::number(*it) + " ");
    ui->lineEdit_2->setText(output);
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_pushButton_clicked()
{
    //меняем местами элементы списка1 и списка2
    list1.swap(list2);
    QString output;
    //выводим это
    QList<int>::iterator it = list1.begin();
    for(; it != list1.end(); ++it)//список1 вывод
        output.append(QString::number(*it) + " ");
    ui->lineEdit->setText(output);
    output.clear();
    it = list2.begin();
    for(; it != list2.end(); ++it)//список2 вывод
        output.append(QString::number(*it) + " ");
    ui->lineEdit_2->setText(output);
}
