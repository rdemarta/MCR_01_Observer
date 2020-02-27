package clock;

import javax.swing.*;

class DigitalClock extends Clock {

    private JLabel timeLabel = new JLabel();

    DigitalClock(ClockTimer clockTimer){
        super(clockTimer);
    }

    void display(){
        JFrame window = new JFrame();
        JPanel panel = new JPanel();

        this.timeLabel.setText("00h 00m 00s");
        panel.add(this.timeLabel);

        window.setTitle("Horloge Arabe");
        window.setSize(300,100);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(panel);
        window.setVisible(true);
    }


    @Override
    public void update() {
        super.update();
        System.out.println("UPDATE");
        int currentSeconds = super.getSeconds();

        // Decompose currentSeconds into hours / minutes / seconds
        int hours = currentSeconds / 3600;

        currentSeconds %= 3600;
        int minutes = currentSeconds / 60 ;

        currentSeconds %= 60;
        int seconds = currentSeconds;

        String strLabel = intOnTwoDigits(hours) + "h " + intOnTwoDigits(minutes) + "m " + intOnTwoDigits(seconds) + "s ";

        timeLabel.setText(strLabel);
    }

    /**
     * Converts an int on a two digits String (6 -> 06, 42 -> 42)
     * @param value the integer to be converted
     * @return the String on two digits
     */
    private String intOnTwoDigits(int value) {
        return String.format("%02d", value);
    }
}
