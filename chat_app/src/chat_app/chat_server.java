package chat_app;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class chat_server {
	public static void main(String args[]) throws NumberFormatException, IOException{
		chat_server server=null;
		if(args.length!=1){
			System.out.println("Error: Port not specified");
		}
		else{
			server = new chat_server(Integer.parseInt(args[0]));
		}
	}
	
	Socket socket=null;
	ServerSocket server=null;
	DataInputStream dis=null;
	
	public chat_server(int port) throws IOException{
		System.out.println("Starting the server on port "+port);
		server = new ServerSocket(port);
		System.out.println("Server started at port "+port);
		System.out.println("Waiting for client...");
		socket = server.accept();
		System.out.println("Client accepted "+socket);
		open();
		boolean done = false;
        while (!done)
        {  try
           {  String line = dis.readUTF();
              System.out.println(line);
              done = line.equals(".bye");
           }
           catch(IOException ioe)
           {  done = true;
           }
        }
        close();
     }
	public void open() throws IOException
	   {  dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	   }
	   public void close() throws IOException
	   {  if (socket != null)    socket.close();
	      if (dis != null)  dis.close();
	   }
	
	
	
}
