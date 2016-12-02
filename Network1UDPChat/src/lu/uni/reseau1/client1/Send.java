package lu.uni.reseau1.client1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import static lu.uni.reseau1.client1.Client.send_sem;

/**
 * Created by Adriano on 24/11/16.
 */
public class Send extends Thread {
    private DatagramSocket send_sock;
    private DatagramPacket send_packet;
    private byte[] buffer ;
    private String message;
    private InetAddress address ;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public Send(InetAddress address) {
        this.address = address;
    }

    public void run() {


        try {
            send_sock = Client.socket;
            send_sock.setBroadcast(true);


            while(true) {


                System.out.println("Enter your message");
                message = in.readLine();

                buffer = message.getBytes();
                send_packet = new DatagramPacket(buffer, buffer.length, address, 6060);


                send_sock.send(send_packet);
                System.out.println("Sent : " + new String(send_packet.getData()));


            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
