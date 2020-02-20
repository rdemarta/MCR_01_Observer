package clock;

interface Subject {

    void attach(Observer o);
    void detach(Observer o);
    void notifyObserver();

}
