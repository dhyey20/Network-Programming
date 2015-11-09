package chat_app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class chat_client {
	Socket socket=null;
	DataInputStream dis=null;
	DataOutputStream dos=null;
	
	@SuppressWarnings("deprecation")
	public chat_client(String server_name, int port) throws UnknownHostException, IOException{
		System.out.println("Connecting to server. Please wait...");
		socket = new Socket(server_name, port);
		System.out.println("Connected to server "+socket);
		start();
		String line = "";
	      while (!line.equals(".bye"))
	      {  try
	         {  line = dis.readLine();
	            dos.writeUTF(line);
	            dos.flush();
	         }
	         catch(IOException ioe)
	         {  
	        	 System.out.println("Sending error: " + ioe.getMessage());
	         }
	      }
	      }
	      
	      public void start() throws IOException
	      {  
	    	  dis   = new DataInputStream(System.in);
	    	  dos = new DataOutputStream(socket.getOutputStream());
	      }
	      public void stop()
	      {  try
	         {  if (dis   != null)  dis.close();
	            if (dos != null)  dos.close();
	            if (socket    != null)  socket.close();
	         }
	         catch(IOException ioe)
	         {  System.out.println("Error closing ...");
	         }
	      }
	
	public static void main(String args[]) throws NumberFormatException, UnknownHostException, IOException{
		chat_client client=null;
		if(args.length!=2){
			System.out.println("Error: port not specified...");
		}
		else{
			client = new chat_client(args[0], Integer.parseInt(args[1]));
		}
	}
	
}
