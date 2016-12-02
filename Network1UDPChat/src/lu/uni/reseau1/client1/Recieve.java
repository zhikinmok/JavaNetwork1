package lu.uni.reseau1.client1;

import java.io.IOException;
import java.net.*;

/**
 * Created by Adriano on 24/11/16.
 */
public class Recieve extends Thread {




    public void run(){
        byte[] buffer = new byte[1024];
        DatagramSocket recieve_socket;
        DatagramPacket recieve_packet ;
        try {
            recieve_socket = Client.socket;
            while(true) {

                recieve_packet = new DatagramPacket(buffer, buffer.length);

                recieve_socket.receive(recieve_packet);
                String message = new String(recieve_packet.getData(), 0, recieve_packet.getLength());
                buffer = recieve_packet.getData();

                System.out.println();
                System.out.println(recieve_packet.getAddress());
                System.out.println("Recieve  : [" + message + "]");


            }



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
