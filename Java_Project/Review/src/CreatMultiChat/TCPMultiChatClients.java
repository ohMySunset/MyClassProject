package CreatMultiChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class TCPMultiChatClients { 

	public static void main(String[] args) {
		
		try {
			String serverIp = "59.5.205.112"; //호스트 주소
			Socket socket = new Socket(serverIp, 7777);
			
			//메세지를 받는 쓰래드
			Thread receiver = new ClientReceiver(socket);
			//메세지를 보내는 쓰레드
			Thread sender = new ClientSender(socket, "할랼루");
			
			receiver.start();
			sender.start();
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
		
	}

}

class ClientSender extends Thread{
	
	// 메세지 보내기 쓰레드
	Socket socket;
	DataOutputStream out;
	String name;
	
	
	public ClientSender(Socket socket, String name) {
		this.socket = socket;
		
        try {
			out = new DataOutputStream(socket.getOutputStream());
			this.name = name;
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		
		//서버에 접속하면 바로 이름을 전송	
			try {
				if(out != null) {
				out.writeUTF(name);				
			}	while (out != null) {
				out.writeUTF("["+name+"]"+ sc.nextLine());
				
			}	
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		
	}
	
	





class ClientReceiver extends Thread{
	
	//메세지를 받아 콘솔에 출력하기
	Socket socket;
	DataInputStream in;
	
	public ClientReceiver(Socket socket) {
		this.socket = socket;
	
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while(in != null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {		
				e.printStackTrace();
			}
		}
	}
	
	
}