#include "mainwindow.h"
#include <QCoreApplication>
#include <QApplication>
#include <iostream>

int main(int argc, char *argv[])
{
    int task = 1;

    if(task == 1) {
        QCoreApplication b(argc, argv);
        std::cout << "Console ok...  \n";

        int N;
        std::cout << "Enter size of the array: " << std::endl;
        std::cin >> N;

        int arr[N];
        std::cout << "Enter elements of the array: " << std::endl;
        for(int i=0; i<N; i++) {
            std::cin >> arr[i];
        }

        std::cout << "Inverse array:" << std::endl;
        for(int i=N-1; i>=0; i--) {
            std::cout << arr[i];
        }

        return b.exec();
    }
    else if(task == 2){
        QApplication a(argc, argv);
        MainWindow w;
        w.show();
        return a.exec();
    }

}
