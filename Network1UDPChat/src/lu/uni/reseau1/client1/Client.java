package lu.uni.reseau1.client1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.concurrent.Semaphore;

/**
 * Created by Adriano on 22/11/16.
 *
 * Mod in header
 */
public class Client {
    static Semaphore send_sem = new Semaphore(1);
    static DatagramSocket socket ;


    public static void main(String[] args) {
        System.out.println("Client started");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            socket = new DatagramSocket(6060) ;
            System.out.println(InetAddress.getLocalHost());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            String name = args[0];
            byte[] buffer =new byte[1024];
            InetAddress address = InetAddress.getByName(args[1]);

            Send send = new Send(address);
            Recieve recieve = new Recieve();

            send.start();
            recieve.start();




        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Please provide a name in first slot of program argument and the address on second slot, stopping...");
        }

    }
}

