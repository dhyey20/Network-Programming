package chat_app;

import java.net.*;
import java.io.*;
 
public class client {
    public static void main(String args[]) throws Exception {
        byte sdata[] = "dhyeyshah".getBytes();
        DatagramSocket dsoc = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("Uday-Laptop");
        //FileInputStream inputStream = new FileInputStream("1.txt");
        //int nRead = 0;
        //while ((nRead = inputStream.read(sdata)) != -1) {
            dsoc.send(new DatagramPacket(sdata, sdata.length, ip, 9000));
            //if (nRead == 0) {
              //  sdata = "END".getBytes();
               // dsoc.send(new DatagramPacket(sdata, sdata.length, ip, 9000));
            //}
        //}
    }
}