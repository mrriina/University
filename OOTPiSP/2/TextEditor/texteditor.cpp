#include "texteditor.h"
#include "ui_texteditor.h"
#include <QObject>
#include <QDebug>
#include <QMessageBox>
#include <QCloseEvent>
#include <QFontDialog>
#include <QSettings>
#include <QFile>
#include <QFileInfo>
#include <QDir>
#include <QFileDialog>

TextEditor::TextEditor(const QString &fileName, QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::TextEditor)
{
    ui->setupUi(this);
    QObject::connect(ui->actionClose, SIGNAL(triggered()), this, SLOT(close()));
    QObject::connect(ui->actionExit, SIGNAL(triggered()), qApp, SLOT(closeAllWindows()));

    setWindowTitle(("TextEditor[*]"));
    QObject::connect(ui->textEdit, SIGNAL(textChanged()), this, SLOT(documentModified()));

    this->setAttribute(Qt::WA_DeleteOnClose, false);

    QFont font = QSettings(this).value("viewFont").value<QFont>();
    ui->textEdit->setFont(font);

    QObject::connect(ui->actionAboutQt, SIGNAL(triggered()), qApp, SLOT(aboutQt()));
    QObject::connect(ui->actionCut, SIGNAL(triggered()), ui->textEdit, SLOT(cut()));
    QObject::connect(ui->actionCopy, SIGNAL(triggered()), ui->textEdit, SLOT(copy()));
    QObject::connect(ui->actionPaste, SIGNAL(triggered()), ui->textEdit, SLOT(paste()));
    QObject::connect(ui->actionUndo, SIGNAL(triggered()), ui->textEdit, SLOT(undo()));
    QObject::connect(ui->actionRedo, SIGNAL(triggered()), ui->textEdit, SLOT(redo()));

    ui->actionCopy->setEnabled(false);
    ui->actionCut->setEnabled(false);
    ui->actionUndo->setEnabled(false);
    ui->actionRedo->setEnabled(false);
    QObject::connect(ui->textEdit, SIGNAL(copyAvailable(bool)), ui->actionCopy, SLOT(setEnabled(bool)));
    QObject::connect(ui->textEdit, SIGNAL(copyAvailable(bool)), ui->actionCut, SLOT(setEnabled(bool)));
    QObject::connect(ui->textEdit, SIGNAL(undoAvailable(bool)), ui->actionUndo, SLOT(setEnabled(bool)));
    QObject::connect(ui->textEdit, SIGNAL(redoAvailable(bool)), ui->actionRedo, SLOT(setEnabled(bool)));

    loadFile(fileName);

    QObject::connect(ui->actionSave, SIGNAL(triggered()), this, SLOT(saveFile()));
    QObject::connect(ui->actionSaveAs, SIGNAL(triggered()), this, SLOT(saveFileAs()));
}

TextEditor::~TextEditor() {
    delete ui;
}

void TextEditor::on_actionNew_triggered() {
    TextEditor *editor = new TextEditor;
    editor->show();
}

void TextEditor::documentModified() {
    this->setWindowModified(true);
}

void TextEditor::closeEvent(QCloseEvent *e) {
    if(this->isWindowModified()) {
        switch(QMessageBox::warning(this, "Document Modified",
                                    "The document has been modified. "
                                    "Do you want to save your changes?\n"
                                    "You will lose and unsaved changes.",
                                    QMessageBox::Yes | QMessageBox::No | QMessageBox::Cancel,
                                    QMessageBox::Cancel)){
            case QMessageBox::Yes:
                saveFile();
                e->accept();
                break;
            case QMessageBox::No:
                e->accept();
                break;
            case QMessageBox::Cancel:
                e->ignore();
                break;
            }
        }
        else{
            e->accept();
        }
}

void TextEditor::on_actionSelectFont_triggered() {
    bool ok;
    QFont font = QFontDialog::getFont( &ok, ui->textEdit->font(), this );

    if (ok) {
        qDebug() << "ok " << font;
        QSettings settings(this);
        settings.setValue("viewFont", font);
        ui->textEdit->setFont(font);

         // пользователь нажимает OK, и шрифт устанавливается в выбранный
     } else {
        qDebug() << "cancel";
         // пользователь нажимает отменить, шрифт остаётся прежним
         // в данном случае, Helvetica [Cronyx], 10
     }
}

void TextEditor::on_actionAbout_triggered() {
    QMessageBox::about(this,
                       "About",
                       "A text editor that works with multiple documents with the ability to open and save, undo actions, work with the clipboard and others.");
}

void TextEditor::loadFile(const QString &fileName) {
    if(fileName == nullptr) {
        setFileName(QString());
        return;
    }

    QFile file(fileName);
    if (!file.open(QIODevice::ReadOnly | QIODevice::Text))
    {
        QMessageBox::warning(this,
                             "Error!",
                             "Could not open the file!",
                             QMessageBox::Ok);
        setFileName(QString());
    }
    else {
        QTextStream in(&file);
        ui->textEdit->setText(in.readAll());
        file.close();
        setFileName(fileName);
        this->setWindowModified(false);
    }
}

void TextEditor::setFileName(const QString &filename) {
    m_fileName = filename;
    setWindowTitle(QString("%1[*] - %2")
                   .arg(m_fileName.isNull()?"untitled":QFileInfo(m_fileName).fileName())
                   .arg(QApplication::applicationName()));
}

void TextEditor::on_actionOpen_triggered() {
    QString fileName = QFileDialog::getOpenFileName(this,
                                                    "Open document",
                                                    QDir::currentPath(),
                                                    "Text documents (*.txt)");
    if(fileName.isNull()) return;

    if(m_fileName.isNull() && !isWindowModified()){
        loadFile(fileName);
    }
    else {
        TextEditor *n = new TextEditor(fileName, this);
        n->show();
    }
}

bool TextEditor::saveFile(){
    if(m_fileName.isNull()) return saveFileAs();
    else {
        QFile file(m_fileName);
        if (!file.open(QIODevice::WriteOnly | QIODevice::Text))
        {
            QMessageBox::warning(this,
                                 "Error!",
                                 "Could not open the file!",
                                 QMessageBox::Ok);
            setFileName(QString());
            return false;
        }
        else {
            QTextStream out(&file);
            out << ui->textEdit->toPlainText();
            file.close();
            setWindowModified(false);
            return true;
        }
    }
}

bool TextEditor::saveFileAs(){
    QString fileName = QFileDialog::getSaveFileName(this,
                                                    "Save document",
                                                    m_fileName.isNull()?QDir::currentPath():m_fileName,
                                                    "Text documents (*.txt)");
    if(fileName.isNull()) return false;
    else {
        setFileName(fileName);
        return saveFile();
    }
}

