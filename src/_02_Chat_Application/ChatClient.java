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
public ChatClient(String ip, int portNumber) {
		// TODO Auto-generated constructor stub
	}
public void start() {
	String iPAdress="18.237.236.131";
	int portNumber=8080;
	try {
		socket=new Socket(iPAdress, portNumber);
		
		
		os=new ObjectOutputStream(socket.getOutputStream());
		os.writeUTF("Hello");
		is=new ObjectInputStream(socket.getInputStream());
		String message=is.readUTF();
		os.flush();
		}catch(Exception e) {
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
        