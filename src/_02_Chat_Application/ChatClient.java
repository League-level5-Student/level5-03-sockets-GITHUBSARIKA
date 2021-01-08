package _02_Chat_Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ChatClient {
	static ObjectOutputStream oos;
	static ObjectInputStream is;
	static Socket socket;
public ChatClient(String ip, int portNumber) {
		// TODO Auto-generated constructor stub
	}
public void start() {
	String iPAdress="18.237.236.131";
	int portNumber=8080;
	try {
		oos=new ObjectOutputStream(socket.getOutputStream());
		is=new ObjectInputStream(socket.getInputStream());
			oos.flush();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

	try {
		socket=new Socket(iPAdress, portNumber);
		
		
		
		oos.writeUTF("Hello");
		
		String message=is.readUTF();
		oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
}
//Sending message
public static void sendMessage() {
	try {
		if(oos!=null) {                                                      
			String message=JOptionPane.showInputDialog("Hi");
			oos.flush();
		}
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
        