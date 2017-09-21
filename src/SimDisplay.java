import display.Display;
import server.UDPPacket;
import server.UDPServer;

public class SimDisplay {

    public static void main(String[] args) throws InterruptedException {

        Display display = new Display();

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
                int gear = (int) Math.round(packet.getM_gear());
                display.changeGear(gear);
                Thread.sleep(100);
            }
        }
    }
}