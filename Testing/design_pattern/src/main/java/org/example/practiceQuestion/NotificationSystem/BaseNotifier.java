package org.example.practiceQuestion.NotificationSystem;

public class BaseNotifier implements Notifier {

    @Override
    public void send(String msg) {
        System.out.println("Message sent through all notifier ---" + msg);
    }
}
