package server;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class UDPServer {

    private UDPPacket packet;

    public UDPServer() {

    }

    public void start() throws Exception  {
        DatagramSocket serverSocket = new DatagramSocket(20777);
        byte[] receiveData = new byte[1289];

        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            ByteBuffer buffer = ByteBuffer.wrap(receiveData).order(ByteOrder.LITTLE_ENDIAN);
            readData(buffer);
        }
    }

    public UDPPacket getPacket() {
        return this.packet;
    }

    private void readData (ByteBuffer buffer) {
        packet = new UDPPacket();

        packet.m_time = buffer.getFloat();
        packet.m_lapTime = buffer.getFloat();
        packet.m_lapDistance = buffer.getFloat();
        packet.m_totalDistance = buffer.getFloat();
        packet.m_x = buffer.getFloat();
        packet.m_y = buffer.getFloat();
        packet.m_z = buffer.getFloat();
        packet.m_speed = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_time = buffer.getFloat();
        packet.m_gear = buffer.getFloat();
    }
}
