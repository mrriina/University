package com.example.spp_lab1;

public class Calculator extends Thread {
    private int N;
    private final Controller controller;
    public Calculator( int N, Controller controller) {
        this.N = N;
        this.controller = controller;
    }
    @Override
    public void run() {
        double a = 1.;
        double sum = a;
        int i = 1;
        try {
            while (i < N && !isInterrupted()) {
                controller.updateResult(sum);
                a = a*( 1.0 / i );
                sum += a;
                i++;
                synchronized (controller) {
                    controller.updateResult(sum);
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}

