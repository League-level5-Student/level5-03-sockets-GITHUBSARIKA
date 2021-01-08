package _02_Chat_Application;

import java.io.IOException;

import javax.swing.JOptionPane;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
	ChatServer chatServer;
	ChatClient chatClient;
public ChatApp() {
	String response= JOptionPane.showInputDialog("Would you like to host a connection?");
	if(response.equals("yes")) {
		chatServer=new ChatServer(8080);
		try {
			chatServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else {
		String ip= JOptionPane.showInputDialog("Enter iPAdress");
		String port=JOptionPane.showInputDialog("Enter port number.");
		int portNumber=Integer.parseInt(port);
		chatClient=new ChatClient(ip, portNumber);
		chatClient.start();
	}
}
public static void main(String[] args) {
	ChatApp chatApp=new ChatApp();
}
}
