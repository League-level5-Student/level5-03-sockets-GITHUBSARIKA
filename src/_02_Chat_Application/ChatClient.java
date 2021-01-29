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
			oos=new ObjectOutputStream(socket.getOutputStream());
		is=new ObjectInputStream(socket.getInputStream());
			oos.flush();
			
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
	
	

	
	while(socket.isConnected()) {
		try {
			
			
			JOptionPane.showMessageDialog(null, is.readObject());
			System.out.println(is.readObject());
			sendMessage();
			
			
			}catch(Exception e) {
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
        