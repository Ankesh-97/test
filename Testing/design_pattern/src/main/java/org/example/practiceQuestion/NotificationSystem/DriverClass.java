package org.example.practiceQuestion.NotificationSystem;

public class DriverClass {
    public static void main(String[] args) {
        Notifier notifier = new BaseNotifier();
        notifier = new EmailNotifier(notifier);
        notifier = new SmsNotifier(notifier);
        notifier.send("Message");
    }
}
