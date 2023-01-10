/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 6.3.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QTextBrowser>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QTabWidget *tab;
    QWidget *add_seller;
    QTextBrowser *doctorsList;
    QWidget *tab_2;
    QTextBrowser *patientsList;
    QWidget *add;
    QPushButton *newDoctor;
    QPushButton *newPatient;
    QPushButton *pushButton_3;
    QLineEdit *doctorSurnameInput;
    QLineEdit *doctorNameInput;
    QLineEdit *doctorPatronymicInput;
    QLineEdit *doctorSpecialityInput;
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;
    QLabel *label_5;
    QLineEdit *lineEdit_5;
    QLineEdit *lineEdit_6;
    QLabel *label_6;
    QLineEdit *lineEdit_7;
    QLabel *label_7;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(960, 422);
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        tab = new QTabWidget(centralwidget);
        tab->setObjectName(QString::fromUtf8("tab"));
        tab->setGeometry(QRect(10, 10, 891, 321));
        add_seller = new QWidget();
        add_seller->setObjectName(QString::fromUtf8("add_seller"));
        doctorsList = new QTextBrowser(add_seller);
        doctorsList->setObjectName(QString::fromUtf8("doctorsList"));
        doctorsList->setGeometry(QRect(20, 10, 431, 261));
        tab->addTab(add_seller, QString());
        tab_2 = new QWidget();
        tab_2->setObjectName(QString::fromUtf8("tab_2"));
        patientsList = new QTextBrowser(tab_2);
        patientsList->setObjectName(QString::fromUtf8("patientsList"));
        patientsList->setGeometry(QRect(10, 10, 391, 261));
        tab->addTab(tab_2, QString());
        add = new QWidget();
        add->setObjectName(QString::fromUtf8("add"));
        newDoctor = new QPushButton(add);
        newDoctor->setObjectName(QString::fromUtf8("newDoctor"));
        newDoctor->setGeometry(QRect(40, 170, 91, 31));
        newPatient = new QPushButton(add);
        newPatient->setObjectName(QString::fromUtf8("newPatient"));
        newPatient->setGeometry(QRect(320, 170, 91, 31));
        pushButton_3 = new QPushButton(add);
        pushButton_3->setObjectName(QString::fromUtf8("pushButton_3"));
        pushButton_3->setGeometry(QRect(600, 170, 91, 31));
        doctorSurnameInput = new QLineEdit(add);
        doctorSurnameInput->setObjectName(QString::fromUtf8("doctorSurnameInput"));
        doctorSurnameInput->setGeometry(QRect(100, 30, 113, 28));
        doctorNameInput = new QLineEdit(add);
        doctorNameInput->setObjectName(QString::fromUtf8("doctorNameInput"));
        doctorNameInput->setGeometry(QRect(100, 60, 113, 28));
        doctorPatronymicInput = new QLineEdit(add);
        doctorPatronymicInput->setObjectName(QString::fromUtf8("doctorPatronymicInput"));
        doctorPatronymicInput->setGeometry(QRect(100, 90, 113, 28));
        doctorSpecialityInput = new QLineEdit(add);
        doctorSpecialityInput->setObjectName(QString::fromUtf8("doctorSpecialityInput"));
        doctorSpecialityInput->setGeometry(QRect(100, 120, 113, 28));
        label = new QLabel(add);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(10, 30, 63, 20));
        label_2 = new QLabel(add);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(10, 60, 63, 20));
        label_3 = new QLabel(add);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(10, 90, 81, 21));
        label_4 = new QLabel(add);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setGeometry(QRect(10, 120, 71, 21));
        label_5 = new QLabel(add);
        label_5->setObjectName(QString::fromUtf8("label_5"));
        label_5->setGeometry(QRect(270, 60, 63, 20));
        lineEdit_5 = new QLineEdit(add);
        lineEdit_5->setObjectName(QString::fromUtf8("lineEdit_5"));
        lineEdit_5->setGeometry(QRect(360, 90, 113, 28));
        lineEdit_6 = new QLineEdit(add);
        lineEdit_6->setObjectName(QString::fromUtf8("lineEdit_6"));
        lineEdit_6->setGeometry(QRect(360, 60, 113, 28));
        label_6 = new QLabel(add);
        label_6->setObjectName(QString::fromUtf8("label_6"));
        label_6->setGeometry(QRect(270, 30, 63, 20));
        lineEdit_7 = new QLineEdit(add);
        lineEdit_7->setObjectName(QString::fromUtf8("lineEdit_7"));
        lineEdit_7->setGeometry(QRect(360, 30, 113, 28));
        label_7 = new QLabel(add);
        label_7->setObjectName(QString::fromUtf8("label_7"));
        label_7->setGeometry(QRect(270, 90, 81, 21));
        tab->addTab(add, QString());
        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 960, 25));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        MainWindow->setStatusBar(statusbar);

        retranslateUi(MainWindow);

        tab->setCurrentIndex(2);


        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
#if QT_CONFIG(tooltip)
        tab->setToolTip(QString());
#endif // QT_CONFIG(tooltip)
#if QT_CONFIG(whatsthis)
        tab->setWhatsThis(QString());
#endif // QT_CONFIG(whatsthis)
        tab->setTabText(tab->indexOf(add_seller), QCoreApplication::translate("MainWindow", "Doctor", nullptr));
        tab->setTabText(tab->indexOf(tab_2), QCoreApplication::translate("MainWindow", "Patient", nullptr));
        newDoctor->setText(QCoreApplication::translate("MainWindow", "New doctor", nullptr));
        newPatient->setText(QCoreApplication::translate("MainWindow", "New patient", nullptr));
        pushButton_3->setText(QCoreApplication::translate("MainWindow", "New ticket", nullptr));
        label->setText(QCoreApplication::translate("MainWindow", "surname: ", nullptr));
        label_2->setText(QCoreApplication::translate("MainWindow", "name:", nullptr));
        label_3->setText(QCoreApplication::translate("MainWindow", "patronymic:", nullptr));
        label_4->setText(QCoreApplication::translate("MainWindow", "speciality:", nullptr));
        label_5->setText(QCoreApplication::translate("MainWindow", "name:", nullptr));
        label_6->setText(QCoreApplication::translate("MainWindow", "surname: ", nullptr));
        label_7->setText(QCoreApplication::translate("MainWindow", "patronymic:", nullptr));
        tab->setTabText(tab->indexOf(add), QCoreApplication::translate("MainWindow", "New", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
