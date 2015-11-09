package ftp;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class FileServer extends Thread {
	
	private ServerSocket ss;
	
	public FileServer(int port) {
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				Socket clientSock = ss.accept();
				saveFile(clientSock);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	private void saveFile(Socket clientSock) throws IOException {
		DataInputStream dis = new DataInputStream(clientSock.getInputStream());
		FileOutputStream fos = new FileOutputStream("testfile.txt");
		byte buffer;
		
		int filesize = 15123; // Send file size in separate msg
		int read = 0;
		int totalRead = 0;
		int remaining = filesize;

		while((buffer = dis.readByte())> 0){
			System.out.println("read " + totalRead + " bytes.");
			fos.write(buffer);
		}
		
		fos.close();
		dis.close();
	}
	
	public static void main(String[] args) throws UnknownHostException {
		FileServer fs = new FileServer(1988);
		fs.start();
		System.out.println(InetAddress.getLocalHost().getHostName());
	}
 
}