package _02_Chat_Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ChatClient {
	ObjectOutputStream os;
	ObjectInputStream is;
public static void main(String[] args) {
	String iPAdress="18.237.236.131";
	int portNumber=8080;
	try {
		Socket socket=new Socket(iPAdress, portNumber);
		String yesServer=JOptionPane.showInputDialog("Would you llike to join a server?");
		os=new ObjectOutputStream(socket.getOutputStream());
		is=new ObjectInputStream(socket.getInputStream());
		if(yesServer.equals("yes")) {
			 JOptionPane.showInputDialog("Enter the iPAdress.");
			 JOptionPane.showInputDialog("Enter the port number");
			 sendMessage();
		}
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void sendMessage() {
	try {
		if(os!=null) {
			String message=JOptionPane.showInputDialog("Hi");
			os.flush();
		}
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
