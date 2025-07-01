package src.design_patterns.observer_pattern.practiceQuestions.weatherstation;

public interface Subject {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();

    void updateState(Object o);
}
