import java.util.Timer;
import java.util.TimerTask;

class ClockTimer extends Subject {

    private int seconds; // The subject state
    private Timer timer;
    private boolean isRunning;

    void setSeconds(int seconds) {
        this.seconds = seconds;
        notifyObservers();
    }

    int getSeconds() {
        return this.seconds;
    }

    boolean isRunning() {
        return isRunning;
    }

    void start() {
        this.isRunning = true;

        this.timer = new Timer();

        // Set up the repeated task that will update the subject states (seconds)
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                setSeconds(seconds + 1);
            }
        };

        long delay  = 1000L;
        long period = 1000L;
        this.timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }

    void pause() {
        this.isRunning = false;
        this.timer.cancel();
    }

    void reset() {
        this.setSeconds(0);
    }

}
