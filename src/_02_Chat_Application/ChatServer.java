package _02_Chat_Application;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JOptionPane;

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
	
	oos.flush();
	while(socket.isConnected()) {
		System.out.println("Hey there!");
		oos.writeUTF(" ");
	
	ois.read();
	         
	socket.close();
	

		
		
			try {
				JOptionPane.showMessageDialog(null, ois.readObject());
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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
