#include "mainwindow.h"
#include "ui_mainwindow.h"

#include <QSqlTableModel>
#include <QSqlQuery>
#include <QSqlRecord>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    QSqlDatabase sdb = QSqlDatabase::addDatabase("QSQLITE");
    sdb.setDatabaseName("D:/qtlab/OOTPiSP/6/OOTPiSP_lab6/db.sqlite");
    if (!sdb.open()) {
        qDebug() << "DB can't be open";
    }


//    QSqlTableModel* doctorModel = new QSqlTableModel();
//    doctorModel->setTable("doctor");
//    doctorModel->setEditStrategy(QSqlTableModel::OnManualSubmit);
//    doctorModel->select();
//    ui->centralwidget->doctor_view->setModel(doctorModel);
//    ui->car_company_id_combobox->setModel(doctorModel);
//    ui->car_company_id_combobox->setCurrentIndex(-1);
}

MainWindow::~MainWindow()
{
    delete ui;
}



void MainWindow::on_tab_tabBarClicked(int index)
{
    // doctors list
    if(index == 0)
    {
        QSqlQuery a_query;
        QString str = "";
        if (!a_query.exec("SELECT * FROM doctor")) qDebug() << "Select request error!";
        QSqlRecord rec = a_query.record();
        ui->doctorsList->clear();
        while (a_query.next())
        {
            str += "----------------------\n";
            str += "Name: " + a_query.value(rec.indexOf("name")).toString();
            str += "\nSurname: " +a_query.value(rec.indexOf("surname")).toString();
            str += "\nPatronymic: " +a_query.value(rec.indexOf("patronymic")).toString();
            str += "\nSpeciality: " +a_query.value(rec.indexOf("speciality")).toString() + "\n";
            str += "----------------------\n";
        }
        ui->doctorsList->setText(str);
    }

    // patients list
    else if(index == 1)
    {
        QSqlQuery a_query;
        QString str = "";
        if (!a_query.exec("SELECT * FROM patient")) qDebug() << "Select request error!";
        QSqlRecord rec = a_query.record();
        ui->patientsList->clear();
        while (a_query.next())
        {
            str += "----------------------\n";
            str += "Name: " + a_query.value(rec.indexOf("name")).toString();
            str += "\nSurname: " +a_query.value(rec.indexOf("surname")).toString();
            str += "\nPatronymic: " +a_query.value(rec.indexOf("patronymic")).toString() + "\n";
            str += "----------------------\n";
        }
        ui->patientsList->setText(str);
    }



}


void MainWindow::on_newDoctor_clicked()
{
    qDebug() << "ui->doctorSurnameInput->text()= " << ui->doctorSurnameInput->text();
    qDebug() << "ui->doctorNameInput->text()= " << ui->doctorNameInput->text();
    qDebug() << "ui->doctorPatronymicInput->text()= " << ui->doctorPatronymicInput->text();
    qDebug() << "ui->doctorSpecialityInput->text()= " << ui->doctorSpecialityInput->text();

    QSqlQuery query;
    query.prepare("INSERT INTO doctor (surname, name, patronymic, speciality) "
             "VALUES ('%1', %2, %3, %4)");
    query.bindValue(":1", ui->doctorSurnameInput->text());
    query.bindValue(":2", ui->doctorNameInput->text());
    query.bindValue(":3", ui->doctorPatronymicInput->text());
    query.bindValue(":4", ui->doctorSpecialityInput->text());
    query.exec();


    QString str_insert = "INSERT INTO doctor (surname, name, patronymic, speciality) "
    "VALUES ('%1', %2, %3, %4)";
    //передача значений
    QString str = str_insert.arg(ui->doctorSurnameInput->text())
                            .arg(ui->doctorNameInput->text())
                            .arg(ui->doctorPatronymicInput->text())
                            .arg(ui->doctorSpecialityInput->text());
    //запуск
    QSqlQuery a_query;
    bool b = a_query.exec(str);
    //если успех - сообщаем что данные отправлены и очищаем ячейки
    if(b)
    {
        qDebug() << "Success";
//        int t =  QMessageBox::information(this, "Success", "Data uploaded successfully");
//        switch (t)
//        {
//            case QMessageBox::Ok:
//                ui->new_prod_name_place->setText("");
//                ui->new_prod_count_place->setText("");
//                break;
//        }
    }
    //если не отправили - ошибка
    if (!b) qDebug() << "Кажется данные не вставляются, проверьте дверь, может она закрыта?";
}














class Doctor
{
public:
    int id;
    QString name;
    QString surname;
    QString patronymic;

    void set_name(QString name) {this->name = name;}
    void set_sur(QString surn) {this->surname = surn;}
    void set_patr(QString patr) {this->patronymic = patr;}
    void add_doctor() {};
    void delete_doctor() {};
};

class Patient
{
public:
    int id;
    QString name;
    QString surname;
    QString patronymic;

    void set_name(QString name) {this->name = name;}
    void set_sur(QString surn) {this->surname = surn;}
    void set_patr(QString patr) {this->patronymic = patr;}

    void add_patient() {};
};

class Tickets
{
public:
    int id;
    int iddoctor;
    int idpatient;
    QString date;
    QString time;

    void set_doc(int doc) {this->iddoctor = doc;}
    void set_pat(int pat) {this->idpatient = pat;}
    void set_date(QString date) {this->date = date;}
    void set_time(QString time) {this->time = time;}

    void add_ticket() {};
    void change_ticket() {};
    void delete_ticket() {};
};







