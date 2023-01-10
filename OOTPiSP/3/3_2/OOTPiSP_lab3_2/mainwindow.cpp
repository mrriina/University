#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    int n=3, m=3, k, p=0, sum=0, mult=1;
    int arr[n][m];

    connect(ui->comboBox, SIGNAL(currentIndexChanged(int)), this, SLOT(indexChanged(int)));
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<m; j++) arr[i][j]=p++;
    }

    for(int i=0; i<m; i++)
    {
        ui->comboBox->addItem(QString::number(i));
    }

    for (int i=0; i < n; i++)
    {
        for(int j=0; j<m; j++)
        {
            ui->textBrowser->append(QString::number(arr[i][j]));
        }
        ui->textBrowser->append("\n");
    }

    for (int i=n; i > 0; i--)
    {
        for(int j=0; j<m; j++)
        {
            ui->textBrowser_2->append(QString::number(arr[i-1][j]));
        }
        ui->textBrowser_2->append("\n");
    }
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_comboBox_currentIndexChanged(int index)
{
    int n=3, m=3, k, p=0, sum=0, mult=1;
    int arr[n][m];


    for(int i=0; i<n; i++)
    {
        for(int j=0; j<m; j++) arr[i][j]=p++;
    }

    k=ui->comboBox->currentText().toInt();
    for(int i=0; i<n; i++)
    {
        sum+=arr[i][k];
        mult*=arr[i][k];
    }
    ui->lineEdit_3->setText(QString::number(mult));
    ui->lineEdit_4->setText(QString::number(sum));
}

