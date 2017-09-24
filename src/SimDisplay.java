import display.Display;
import display.SplashScreen;
import server.UDPPacket;
import server.UDPServer;

public class SimDisplay {

    private static final String F1 = "src/res/img/f1.png";

    public static void main(String[] args) throws InterruptedException {

        Display display = new Display(F1);

        display.init();

        UDPServer server = new UDPServer();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    server.start();
                } catch (Exception e) {
                }
            }
        });
        thread.start();

        while (true) {
            UDPPacket packet = server.getPacket();
            if (packet != null) {
                display.refresh(packet);
                Thread.sleep(100);
            }
        }
    }
}