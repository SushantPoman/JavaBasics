package DesignPatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/observer-method-design-pattern-in-java/
public class DpObserver {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

        weatherStation.addObserver(currentConditionsDisplay);
        weatherStation.addObserver(statisticsDisplay);

        // Simulate a change in temperature
        weatherStation.setTemperature(25.5f);
        // Output:
        // Current Conditions Display: Temperature = 25.5
        // Statistics Display: Temperature = 25.5

        // Simulate another change in temperature
        weatherStation.setTemperature(30.0f);
        // Output:
        // Current Conditions Display: Temperature = 30.0
        // Statistics Display: Temperature = 30.0

        // Remove an observer
        weatherStation.removeObserver(currentConditionsDisplay);

        // Simulate another change in temperature
        weatherStation.setTemperature(28.0f);
        // Output:
        // Statistics Display: Temperature = 28.0
    }
}

// Observer
interface Observer {
    void update(float temperature);
}

// Subject (Observable)
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Concrete Observer
class CurrentConditionsDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    private void display() {
        System.out.println("Current Conditions Display: Temperature = " + temperature);
    }
}

// Concrete Observer
class StatisticsDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    private void display() {
        System.out.println("Statistics Display: Temperature = " + temperature);
    }
}