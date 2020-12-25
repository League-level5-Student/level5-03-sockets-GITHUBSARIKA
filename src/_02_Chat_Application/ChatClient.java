package _02_Chat_Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ChatClient {
	static ObjectOutputStream os;
	static ObjectInputStream is;
	static Socket socket;
public static void main(String[] args) {
	String iPAdress="18.237.236.131";
	int portNumber=8080;
	try {
		socket=new Socket(iPAdress, portNumber);
		String yesServer=JOptionPane.showInputDialog("Would you llike to join a server?");
		
		os=new ObjectOutputStream(socket.getOutputStream());
		os.writeUTF("Hello");
		is=new ObjectInputStream(socket.getInputStream());
		String message=is.readUTF();
		os.flush();
		if(yesServer.equals("yes")) {
			 iPAdress=JOptionPane.showInputDialog("Enter the iPAdress.");
			 String port=JOptionPane.showInputDialog("Enter the port number");
			 portNumber=Integer.parseInt(port);
			 sendMessage();
		}
		socket.close();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//Sending message
public static void sendMessage() {
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
        