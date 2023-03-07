#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    QList<int> list;
    list << 3 << 4 << 5 << 6 << 7;
    for(int i=0; i<list.size(); i++)
    {
        ui->textBrowser->append(QString::number(list[i]));
    }
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_radioButton_clicked(bool checked)
{
    int itm;
    itm = ui->lineEdit->text().toInt();
    ui->textBrowser->append(QString::number(itm));
    ui->radioButton->setChecked(false);
    ui->radioButton->setAutoExclusive(false);
    ui->radioButton->setChecked(false);
    ui->radioButton->setAutoExclusive(true);
}


void MainWindow::on_radioButton_2_clicked(bool checked)
{
    QString list;
    ui->textBrowser->toPlainText();
    list.append(ui->textBrowser->toPlainText());
    ui->textBrowser->clear();

    for(int i=0; i<list.size()-1; i++)
    {
        if(list[i]=='\n') continue;
        else ui->textBrowser->append(list[i]);
    }
    ui->radioButton_2->setAutoExclusive(false);
    ui->radioButton_2->setChecked(false);
    ui->radioButton_2->setAutoExclusive(true);
}

