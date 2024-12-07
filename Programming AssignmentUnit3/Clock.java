import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    public static void printCurrentTime() {
        System.out.println(dateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        Thread updateTimeThread = new Thread(new UpdateTimeTask());
        Thread displayTimeThread = new Thread(new DisplayTimeTask());

        // Set thread priorities
        displayTimeThread.setPriority(Thread.MAX_PRIORITY);
        updateTimeThread.setPriority(Thread.MIN_PRIORITY);

        updateTimeThread.start();
        displayTimeThread.start();
    }
}

class UpdateTimeTask implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DisplayTimeTask implements Runnable {
    @Override
    public void run() {
        while (true) {
            Clock.printCurrentTime();
            try {
                Thread.sleep(1000); // Sleep for 1 second to update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
