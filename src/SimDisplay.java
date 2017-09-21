import display.Display;

public class SimDisplay {

    public static void main(String[] args) throws InterruptedException {

        Display display = new Display();

        display.init();

        Thread.sleep(2000);

        display.changeGear(2);
    }
}