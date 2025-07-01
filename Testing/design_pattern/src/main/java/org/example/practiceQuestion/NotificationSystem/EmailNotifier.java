package design_patterns.decorator_pattern.practiceQuestion.NotificationSystem;

public class EmailNotifier extends NotifierProvider {
    protected EmailNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        System.out.println("Sent message through email.");
        this.getNotifier().send(msg);
    }
}
