package design_patterns.decorator_pattern.practiceQuestion.NotificationSystem;

public class BaseNotifier implements Notifier {

    @Override
    public void send(String msg) {
        System.out.println("Message sent through all notifier ---" + msg);
    }
}
