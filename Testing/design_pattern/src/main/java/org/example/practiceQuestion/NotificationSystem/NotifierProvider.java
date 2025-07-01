package design_patterns.decorator_pattern.practiceQuestion.NotificationSystem;

public abstract class NotifierProvider implements Notifier {

    private final Notifier notifier;

    protected NotifierProvider(Notifier notifier) {
        this.notifier = notifier;
    }

    protected final Notifier getNotifier() {
        return this.notifier;
    }


}
