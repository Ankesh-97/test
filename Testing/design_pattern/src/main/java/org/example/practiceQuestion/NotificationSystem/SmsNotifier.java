package design_patterns.decorator_pattern.practiceQuestion.NotificationSystem;

public class SmsNotifier extends NotifierProvider {
    protected SmsNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        System.out.println("Message sent through sms.");
        this.getNotifier().send(msg);
    }
}
