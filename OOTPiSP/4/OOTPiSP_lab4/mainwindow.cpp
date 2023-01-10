#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    QStringList headers;//объект для списка строк
    headers << "abc";
    ui->tableWidget->setColumnCount(4);//количество колонок таблицы
    ui->tableWidget->setShowGrid(true);//сетка для таблицы
    ui->tableWidget->setSelectionMode(QAbstractItemView::SingleSelection);//при выборе элемента, любой уже выбранный элемент становится не активным
    ui->tableWidget->setHorizontalHeaderLabels(QStringList() << "U" << "I" << "R" << "Q");//устанавливаем названия столбцов
    ui->tableWidget->horizontalHeader()->setStretchLastSection(true);//горизонтальный заголовок
    ui->tableWidget->horizontalHeader()->setSectionResizeMode(QHeaderView::Fixed);//режим изменнеия размера

    srand(time(0));//таймер
    for(int i = 0; i < 15; i++) {//цикл по строкам
        ui->tableWidget->insertRow(i);//вставка столбца
        ui->tableWidget->setItem(i, 0, new QTableWidgetItem(QString::number(rand() % 100 + 10)));//генерация значений в первом столбце
        ui->tableWidget->setItem(i, 1, new QTableWidgetItem(QString::number(rand() % 100 + 10)));//генерация значений во втором столбце
        ui->tableWidget->item(i, 0)->setToolTip(QString::number(ui->tableWidget->item(i, 0)->text().toInt()));//подсвечиваем значения в первом столбце
        ui->tableWidget->item(i, 1)->setToolTip(QString::number(ui->tableWidget->item(i, 1)->text().toInt()));//подсвечиваем значения во втором столбце

        //ui->tableWidget->item(i, 0)->setToolTip(QString::number(ui->tableWidget->item(i, 0)->text().toInt()));//подсвечиваем значения в первом столбце
    }

    R = new QShortcut(this);//создаем сочетание клавиш для кнопки R
    R->setKey(Qt::CTRL + Qt::Key_R);//устанавливаем значение сочетания
    connect(R, SIGNAL(activated()), this, SLOT(on_R_clicked()));//соединяем нажатие и кнопку

    Q = new QShortcut(this);//создаем сочетание клавиш для кнопки Q
    Q->setKey(Qt::CTRL + Qt::Key_Q);//устанавливаем значение сочетания
    connect(Q, SIGNAL(activated()), this, SLOT(on_Q_clicked()));//соединяем нажатие и кнопку
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_R_clicked()//функция для кнопки R
{
    int count = 0;//счетчик значений
    double U, I; //перменные значения тока и напряжения
    for(int i = 0; i < 15; i++){//цикл по строкам
        U = ui->tableWidget->item(i, 0)->text().toInt();//считываем значения из первого столбца и переводим в числа
        I = ui->tableWidget->item(i, 1)->text().toInt();//считываем значения из второго столбца и переводим в числа
        ui->tableWidget->setItem(i, 2, new QTableWidgetItem(QString::number(U / I)));//расчитываем напряжение и помещваем в третий столбец
        if(ui->tableWidget->item(i, 2)->text().toDouble() >= 100 && ui->tableWidget->item(i, 2)->text().toDouble() <= 1000){//если значение попадает в диапазон
            ui->tableWidget->item(i, 2)->setBackground(Qt::red);//то ячейка становится красной
            count++;//увеличиваем счетчик
        }

        if(ui->tableWidget->item(i, 2)->text().toDouble() < 1){//если значение попадает в диапазон
            ui->tableWidget->item(i, 2)->setBackground(Qt::green);//то ячейка становится зелёной
        }

        ui->tableWidget->item(i, 2)->setToolTip(QString::number(ui->tableWidget->item(i, 2)->text().toInt()));//отображение значения в тултип
    }
    ui->label_3->setText(QString::number(count));//выводим количество значений попавших в диапазон
}

void MainWindow::on_Q_clicked()//функция для кнопки Q
{
    if(!ui->tableWidget->item(0, 2)){
        QMessageBox::critical(this, "Warning!", "At first calculate R value");
        return;
    }
    int count = 0;//счетчик значений в диапазоне
    double t = 10.0;//время
    double R, I;//споротивление и ток
    double res;//кол-во выделенного тепла
    for(int i = 0; i < 15; i++){//цикл по строкам
        I = ui->tableWidget->item(i, 1)->text().toInt();//считываем ток и переводим в число
        R = ui->tableWidget->item(i, 2)->text().toDouble();//считываем сопротивление и переводим в число
        res = I * I * R * t;//рассчитываем количество выделееног тепла за 10 сек
        ui->tableWidget->setItem(i, 3, new QTableWidgetItem(QString::number(res)));//помещаем в четвертую колонку значения
        if(ui->tableWidget->item(i, 3)->text().toDouble() >= 1000 && ui->tableWidget->item(i, 3)->text().toDouble() <= 10000){//если значение попадает в диапазон
            ui->tableWidget->item(i, 3)->setBackground(Qt::blue);//то ячейка становится синей
            count++;//увеличиваем счетчик на 1
        }
        ui->tableWidget->item(i, 3)->setToolTip(QString::number(ui->tableWidget->item(i, 3)->text().toInt()));//отображения значения в тултип
    }
    ui->label_4->setText(QString::number(count));//выводим количество значений попавших в диапазон
}

void MainWindow::on_tableWidget_itemChanged(QTableWidgetItem *item)//функция ручного изменения значения в ячейке
{
    ui->tableWidget->item(item->row(), item->column())//выбираем нужную ячейку и изменяем значение
            ->setToolTip(QString::number(ui->tableWidget->item(item->row(), item->column())->text().toDouble()));//если число изменилось то в тултипе тоже оно изменится
}
