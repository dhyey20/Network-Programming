package chat_app;

import java.net.*;
import java.io.*;
 
 
public class server {
    public static void main(String args[]) throws IOException {
        byte b[] = new byte[1024];
        System.out.println(InetAddress.getLocalHost().getHostName()+"...");
        DatagramSocket dsoc = new DatagramSocket(9000);
        FileWriter fileWriter = new FileWriter("1.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while (true) {
            DatagramPacket dp = new DatagramPacket(b, b.length);
            dsoc.receive(dp);
            String str = new String(new String(dp.getData(), 0, dp.getLength()));
            if (str.trim().equals("END"))
                break;
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}