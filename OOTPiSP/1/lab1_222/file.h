#ifndef FILE_H
#define FILE_H

#include <QWidget>
#include <QTextEdit>

class File : public QWidget
{
    Q_OBJECT;
public:
    File(QWidget *parent = 0);
    QTextEdit *text = new QTextEdit;

public slots:
    void openFile();
};

#endif // FILE_H
