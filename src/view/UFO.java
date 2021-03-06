package view;


import java.util.ArrayList;

/*
 * Participant: ConcreteSubject
 */

public class UFO implements Subject {
    
    private ArrayList<Observer> observers;
    
    public UFO() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(new Event("Health", 10, this));
        }
    }
    
}
