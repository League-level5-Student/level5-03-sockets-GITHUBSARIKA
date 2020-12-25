package _02_Chat_Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import _01_Intro_To_Sockets.server.ServerGreeter;

public class ChatServer {
	private static int portNumber;
	private static ServerSocket server;
	private static Socket socket;
	ObjectOutputStream os;
	ObjectInputStream is;
public ChatServer(int portNumber) {
	this.portNumber=portNumber;
}
public static void main(String[] args) throws IOException {
	server=new ServerSocket(portNumber);
	socket=server.accept();
	boolean connected=true;
	while(connected==true) {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF(" ");
	ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
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
	if(os!=null) {
		os.writeObject("Hello");
		os.flush();
	}
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
