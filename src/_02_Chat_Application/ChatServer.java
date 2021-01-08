package _02_Chat_Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import _01_Intro_To_Sockets.server.ServerGreeter;

public class ChatServer {
	private int portNumber;
	private ServerSocket server;
	private Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
public ChatServer(int portNumber) {
	this.portNumber=portNumber;
}
public void start() throws IOException {
	server=new ServerSocket(portNumber);
	socket=server.accept();
	
	oos=new ObjectOutputStream(socket.getOutputStream());
	ois=new ObjectInputStream(socket.getInputStream());
	boolean connected=true;
	oos.flush();
	while(connected==true) {
		try {
			
			oos.writeUTF(" ");
	
	ois.read();
	         
	socket.close();
	}catch(SocketTimeoutException e) {
		connected=false;
		e.printStackTrace();
	}catch(IOException e) {
		connected=false;
		e.printStackTrace();                                    
	}
		//Making and joining the thread
		Thread thread=null;
		try {
			thread=new ServerGreeter();
		}catch(IOException e) {
			e.printStackTrace();
		}
		thread.start();
		try{
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
public void sendMessage() {
	try {
	if(oos!=null) {
		oos.writeObject("Hello");
		oos.flush();
	}
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
