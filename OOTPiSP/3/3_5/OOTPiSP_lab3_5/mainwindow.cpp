#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    QString output;
    //добавляем товары
    things << "Стол";
    things << "Стул";
    things << "Шкаф";
    things << "Табуретка";
    things << "Софа";
    //выводим товары
    QSet<QString>::iterator it = things.begin();
    for(; it != shop1.end(); ++it)
        output.append(*it + " ");
    ui->lineEdit->setText(output);

    output.clear();
    //добавляем товары в магазины
    shop1 << "Стол" << "Стул" << "Шкаф" << "Табуретка";
    shop2 << "Шкаф" << "Табуретка";
    shop3 << "Стул" << "Шкаф" << "Табуретка";
    //выводим инфу о магазах
    it = shop1.begin();
    for(; it != shop1.end(); ++it)
        output.append(*it + " ");
    ui->lineEdit_2->setText(output);
    output.clear();

    it = shop2.begin();
    for(; it != shop2.end(); ++it)
        output.append(*it + " ");
    ui->lineEdit_3->setText(output);
    output.clear();

    it = shop3.begin();
    for(; it != shop3.end(); ++it)
        output.append(*it + " ");
    ui->lineEdit_4->setText(output);
    output.clear();
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_pushButton_clicked()
{
    QString output;
    QSet<QString> temp = shop1;
    QSet<QString> unite;
    QSet<QString> all;
    //это объединение всех всех магазов
    //и соответственно товары, которые есть хотя бы в 1 магазе
    unite = shop1;
    unite.unite(shop2);
    unite.unite(shop3);

    output.append("Везде: ");
    //с пересечения находим товары, которые есть во всех магазах
    temp.intersect(shop2);
    temp.intersect(shop3);
    all = temp;
    QSet<QString>::iterator it = temp.begin();
    for(; it != temp.end(); ++it)
        output.append(*it + " ");

    output.append("\nХотя бы в одном: ");
    it = unite.begin();
    for(; it != unite.end(); ++it)
        output.append(*it + " ");

    output.append("\nНигде: ");
    //находим товары, которые никуда не доставлены
    temp = things;
    temp.subtract(unite);

    it = temp.begin();
    for(; it != temp.end(); ++it)
        output.append(*it + " ");

    ui->textEdit->setText(output);
}
