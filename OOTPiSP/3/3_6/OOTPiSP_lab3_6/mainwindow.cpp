#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    QFile f_file("D:\\qtlab\\OOTPiSP\\3\\3_6\\f.txt");
    if (!f_file.open(QIODevice::ReadOnly)) qDebug() << "Ошибка при открытии файла";
    QByteArray t = f_file.readAll();
    ui->textEdit->setText(t);
    f_file.close();

    QByteArray g, h;
    for(int i =0; i<t.size(); i++) {
        if(t[i]%2==0) g.push_back(t[i]);
        else {h.push_back(t[i]);}
    }

    QFile g_file("D:\\qtlab\\OOTPiSP\\3\\3_6\\g.txt");
    if (!g_file.open(QIODevice::WriteOnly)) qDebug() << "Ошибка при открытии файла";
    QTextStream stream(&g_file);
    for(int i=0; i<g.size(); i++) {stream << g[i];}
    ui->textEdit_2->setText(g);
    g_file.close();

    QFile h_file("D:\\qtlab\\OOTPiSP\\3\\3_6\\h.txt");
    if (!h_file.open(QIODevice::WriteOnly)) qDebug() << "Ошибка при открытии файла";
    QTextStream stream_h(&h_file);
    for(int i=0; i<h.size(); i++) {stream_h << h[i];}
    ui->textEdit_3->setText(h);
    h_file.close();
}

MainWindow::~MainWindow()
{
    delete ui;
}
