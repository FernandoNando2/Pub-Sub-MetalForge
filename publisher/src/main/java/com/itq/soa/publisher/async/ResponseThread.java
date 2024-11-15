package com.itq.soa.publisher.async;

public class ResponseThread extends Thread {

    private Task task;

    public ResponseThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task started");
            Thread.sleep(5000); // Simula un proceso largo
            task.sendResponse();
            System.out.println("Task completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
