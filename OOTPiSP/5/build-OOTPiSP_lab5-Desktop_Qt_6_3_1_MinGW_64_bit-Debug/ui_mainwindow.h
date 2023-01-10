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
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QTableView>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QTableView *tableView;
    QTableView *tableView_2;
    QTableView *tableView_3;
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;
    QLabel *label_5;
    QLabel *label_6;
    QLabel *label_7;
    QLineEdit *artistid_text;
    QLineEdit *title_text;
    QLineEdit *year_text;
    QPushButton *id_but;
    QPushButton *title_but;
    QPushButton *year_but;
    QLineEdit *artistid_res;
    QLineEdit *title_res;
    QLineEdit *year_res;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(929, 541);
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        tableView = new QTableView(centralwidget);
        tableView->setObjectName(QString::fromUtf8("tableView"));
        tableView->setGeometry(QRect(150, 20, 461, 141));
        tableView_2 = new QTableView(centralwidget);
        tableView_2->setObjectName(QString::fromUtf8("tableView_2"));
        tableView_2->setGeometry(QRect(150, 180, 461, 141));
        tableView_3 = new QTableView(centralwidget);
        tableView_3->setObjectName(QString::fromUtf8("tableView_3"));
        tableView_3->setGeometry(QRect(150, 340, 461, 141));
        label = new QLabel(centralwidget);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(50, 70, 63, 20));
        label_2 = new QLabel(centralwidget);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(50, 230, 63, 20));
        label_3 = new QLabel(centralwidget);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(50, 390, 63, 20));
        label_4 = new QLabel(centralwidget);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setGeometry(QRect(680, 150, 63, 20));
        label_5 = new QLabel(centralwidget);
        label_5->setObjectName(QString::fromUtf8("label_5"));
        label_5->setGeometry(QRect(630, 190, 63, 20));
        label_6 = new QLabel(centralwidget);
        label_6->setObjectName(QString::fromUtf8("label_6"));
        label_6->setGeometry(QRect(630, 230, 63, 20));
        label_7 = new QLabel(centralwidget);
        label_7->setObjectName(QString::fromUtf8("label_7"));
        label_7->setGeometry(QRect(630, 270, 63, 20));
        artistid_text = new QLineEdit(centralwidget);
        artistid_text->setObjectName(QString::fromUtf8("artistid_text"));
        artistid_text->setGeometry(QRect(680, 190, 71, 31));
        title_text = new QLineEdit(centralwidget);
        title_text->setObjectName(QString::fromUtf8("title_text"));
        title_text->setGeometry(QRect(680, 230, 71, 31));
        year_text = new QLineEdit(centralwidget);
        year_text->setObjectName(QString::fromUtf8("year_text"));
        year_text->setGeometry(QRect(680, 270, 71, 31));
        id_but = new QPushButton(centralwidget);
        id_but->setObjectName(QString::fromUtf8("id_but"));
        id_but->setGeometry(QRect(760, 190, 71, 31));
        title_but = new QPushButton(centralwidget);
        title_but->setObjectName(QString::fromUtf8("title_but"));
        title_but->setGeometry(QRect(760, 230, 71, 31));
        year_but = new QPushButton(centralwidget);
        year_but->setObjectName(QString::fromUtf8("year_but"));
        year_but->setGeometry(QRect(760, 270, 71, 31));
        artistid_res = new QLineEdit(centralwidget);
        artistid_res->setObjectName(QString::fromUtf8("artistid_res"));
        artistid_res->setGeometry(QRect(840, 190, 71, 31));
        title_res = new QLineEdit(centralwidget);
        title_res->setObjectName(QString::fromUtf8("title_res"));
        title_res->setGeometry(QRect(840, 230, 71, 31));
        year_res = new QLineEdit(centralwidget);
        year_res->setObjectName(QString::fromUtf8("year_res"));
        year_res->setGeometry(QRect(840, 270, 71, 31));
        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 929, 25));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        MainWindow->setStatusBar(statusbar);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
        label->setText(QCoreApplication::translate("MainWindow", "Artist:", nullptr));
        label_2->setText(QCoreApplication::translate("MainWindow", "Cd:", nullptr));
        label_3->setText(QCoreApplication::translate("MainWindow", "Track:", nullptr));
        label_4->setText(QCoreApplication::translate("MainWindow", "Count", nullptr));
        label_5->setText(QCoreApplication::translate("MainWindow", "artistid", nullptr));
        label_6->setText(QCoreApplication::translate("MainWindow", "title", nullptr));
        label_7->setText(QCoreApplication::translate("MainWindow", "year", nullptr));
        id_but->setText(QCoreApplication::translate("MainWindow", "Count", nullptr));
        title_but->setText(QCoreApplication::translate("MainWindow", "Count", nullptr));
        year_but->setText(QCoreApplication::translate("MainWindow", "Count", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
