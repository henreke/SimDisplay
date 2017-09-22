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
        packet.m_xv = buffer.getFloat();
        packet.m_yv = buffer.getFloat();
        packet.m_zv = buffer.getFloat();
        packet.m_xr = buffer.getFloat();
        packet.m_yr = buffer.getFloat();
        packet.m_zr = buffer.getFloat();
        packet.m_xd = buffer.getFloat();
        packet.m_yd = buffer.getFloat();
        packet.m_zd = buffer.getFloat();
        packet.m_susp_pos[0] = buffer.getFloat();
        packet.m_susp_pos[1] = buffer.getFloat();
        packet.m_susp_pos[2] = buffer.getFloat();
        packet.m_susp_pos[3] = buffer.getFloat();
        packet.m_susp_vel[0] = buffer.getFloat();
        packet.m_susp_vel[1] = buffer.getFloat();
        packet.m_susp_vel[2] = buffer.getFloat();
        packet.m_susp_vel[3] = buffer.getFloat();
        packet.m_wheel_speed[0] = buffer.getFloat();
        packet.m_wheel_speed[1] = buffer.getFloat();
        packet.m_wheel_speed[2] = buffer.getFloat();
        packet.m_wheel_speed[3] = buffer.getFloat();
        packet.m_throttle = buffer.getFloat();
        packet.m_steer = buffer.getFloat();
        packet.m_brake = buffer.getFloat();
        packet.m_clutch = buffer.getFloat();
        packet.m_gear = buffer.getFloat();
        packet.m_gforce_lat = buffer.getFloat();
        packet.m_gforce_lon = buffer.getFloat();
        packet.m_lap = buffer.getFloat();
        packet.m_engineRate = buffer.getFloat();
        packet.m_sli_pro_native_support = buffer.getFloat();
        packet.m_car_position = buffer.getFloat();
        packet.m_kers_level = buffer.getFloat();
        packet.m_kers_max_level = buffer.getFloat();
        packet.m_drs = buffer.getFloat();
        packet.m_traction_control = buffer.getFloat();
        packet.m_anti_lock_brakes = buffer.getFloat();
        packet.m_fuel_in_tank = buffer.getFloat();
        packet.m_fuel_capacity = buffer.getFloat();
        packet.m_in_pits = buffer.getFloat();
        packet.m_sector = buffer.getFloat();
        packet.m_sector1_time = buffer.getFloat();
        packet.m_sector2_time = buffer.getFloat();
        packet.m_brakes_temp[0] = buffer.getFloat();
        packet.m_brakes_temp[1] = buffer.getFloat();
        packet.m_brakes_temp[2] = buffer.getFloat();
        packet.m_brakes_temp[3] = buffer.getFloat();
        packet.m_tyres_pressure[0] = buffer.getFloat();
        packet.m_tyres_pressure[1] = buffer.getFloat();
        packet.m_tyres_pressure[2] = buffer.getFloat();
        packet.m_tyres_pressure[3] = buffer.getFloat();
        packet.m_team_info = buffer.getFloat();
        packet.m_total_laps = buffer.getFloat();
        packet.m_track_size = buffer.getFloat();
        packet.m_last_lap_time = buffer.getFloat();
        packet.m_max_rpm = buffer.getFloat();
        packet.m_idle_rpm = buffer.getFloat();
        packet.m_max_gears = buffer.getFloat();
        packet.m_sessionType = buffer.getFloat();
        packet.m_drsAllowed = buffer.getFloat();
        packet.m_track_number = buffer.getFloat();
        packet.m_vehicleFIAFlags = buffer.getFloat();
        packet.m_era = buffer.getFloat();
        packet.m_engine_temperature = buffer.getFloat();
        packet.m_gforce_vert = buffer.getFloat();
        packet.m_ang_vel_x = buffer.getFloat();
        packet.m_ang_vel_y = buffer.getFloat();
        packet.m_ang_vel_z = buffer.getFloat();
        packet.m_tyres_temperature[0] = buffer.get();
        packet.m_tyres_temperature[1] = buffer.get();
        packet.m_tyres_temperature[2] = buffer.get();
        packet.m_tyres_temperature[3] = buffer.get();
        packet.m_tyres_wear[0] = buffer.get();
        packet.m_tyres_wear[1] = buffer.get();
        packet.m_tyres_wear[2] = buffer.get();
        packet.m_tyres_wear[3] = buffer.get();
        packet.m_tyre_compound = buffer.get();
        packet.m_front_brake_bias = buffer.get();
        packet.m_fuel_mix = buffer.get();
        packet.m_currentLapInvalid = buffer.get();
        packet.m_tyres_damage[0] = buffer.get();
        packet.m_tyres_damage[1] = buffer.get();
        packet.m_tyres_damage[2] = buffer.get();
        packet.m_tyres_damage[3] = buffer.get();
        packet.m_front_left_wing_damage = buffer.get();
        packet.m_front_right_wing_damage = buffer.get();
        packet.m_rear_wing_damage = buffer.get();
        packet.m_engine_damage = buffer.get();
        packet.m_gear_box_damage = buffer.get();
        packet.m_exhaust_damage = buffer.get();
        packet.m_pit_limiter_status = buffer.get();
        packet.m_pit_speed_limit = buffer.get();
        packet.m_session_time_left = buffer.getFloat();
        packet.m_rev_lights_percent = buffer.get();
        packet.m_is_spectating = buffer.get();
        packet.m_spectator_car_index = buffer.get();

        // Car data
        packet.m_num_cars = buffer.get();
        packet.m_player_car_index = buffer.get();
        for (int i = 0; i < 20; i ++)
            packet.m_car_data[i] = buffer.get();
        packet.m_yaw = buffer.getFloat();
        packet.m_pitch = buffer.getFloat();
        packet.m_roll = buffer.getFloat();
        packet.m_x_local_velocity = buffer.getFloat();
        packet.m_y_local_velocity = buffer.getFloat();
        packet.m_z_local_velocity = buffer.getFloat();
        packet.m_susp_acceleration[0] = buffer.getFloat();
        packet.m_susp_acceleration[1] = buffer.getFloat();
        packet.m_susp_acceleration[2] = buffer.getFloat();
        packet.m_susp_acceleration[3] = buffer.getFloat();
        packet.m_ang_acc_x = buffer.getFloat();
        packet.m_ang_acc_y = buffer.getFloat();
        packet.m_ang_acc_z = buffer.getFloat();
    }
}
