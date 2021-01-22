package _02_Chat_Application;

import java.awt.HeadlessException;
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
	String iPAdress="34.211.182.132";
	int portNumber=8080;
	try {
		socket=new Socket(iPAdress, portNumber);
	} catch (UnknownHostException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	try {
		
		sendMessage();
		oos=new ObjectOutputStream(socket.getOutputStream());
		is=new ObjectInputStream(socket.getInputStream());
			oos.flush();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

	try {
		
		
		
		
		oos.writeUTF("Hello");
		
		String message=is.readUTF();
		oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	while(socket.isConnected()) {
		try {
			JOptionPane.showMessageDialog(null, is.readObject());
			sendMessage();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
//Sending message
public static void sendMessage() {
	try {
		if(oos!=null) {                                                      
			String message=JOptionPane.showInputDialog("Hi");
			oos.writeObject(message);
			oos.flush();
		}
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
        