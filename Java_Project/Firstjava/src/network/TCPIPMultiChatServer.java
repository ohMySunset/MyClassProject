package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TCPIPMultiChatServer {

	// 접속 사용자 정보를 저장 : 메시지를 전체에게 보내기 위해서
	// 저장 정보 : name, OutputStream
	// Map<String, Object>
	
	HashMap<String, Object> clients;
	
	public TCPIPMultiChatServer() {
		clients = new HashMap<String, Object>();
		Collections.synchronizedMap(clients); //쓰래드 동기화에 안전한 상태로 만들어주는 메서드
	}
	
	
	public void start() throws IOException {
		// ServerSocket 실행
		// 사용자의 요청이 있으면  Socket을 생성해서 
		// 연결 -> clients의 사용자 정보를 저장 -> 쓰래드로 처리 (why? 싱글쓰래드일 경우 한 socket이 접근하면 다른 socket들은 기다려야함)
		
		// 서버소켓 생성
		ServerSocket serverSocket = new ServerSocket(7777);
		System.out.println("Chatting Server Start!!");
		
		Socket socket = null;
		
		while(true) {
		// 요청이 들어올 때까지 대기 하다가 요청이 들어오면 새로운 socket을 생성하여 반환
		socket = serverSocket.accept(); 
		
		// map에 정보 저장, 접속한 사용자들에게 메시지를 전송 (아래에서 클래스 작성)
		
		System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"] 사용자 접속");
		
		ServerReceiver receiver = new ServerReceiver(socket);
		receiver.start();
		
		}
		
	}

	
	void sendToAll(String msg) {
		// 일괄 처리, Map은 순서를 갖지 않음 -> Map key => Set으로 변경		
	     Set<String> keys = clients.keySet();	
	     Iterator<String> itr = keys.iterator();
	     
	     while(itr.hasNext()) {
	    	 
	    	 DataOutputStream out = (DataOutputStream)clients.get(itr.next());  //Object -> DataOutputStream 형변환	    	 
	    	 try {
				out.writeUTF(msg);
			} catch (IOException e) {			
				e.printStackTrace();
			}
	     }
	}

	
	// 내부 클래스 생성 (Inner Class) -> 지금 작성한 객체 안에서만 사용할 수 있도록 해주고, Outer클래스 안의 인스턴스 메서드를 모두 사용할 수 있음. 
	// 데이터를 받아서 저장, 메세지 전체 발송
	private class ServerReceiver extends Thread{
		// Socket, InputStream, OutputStream
		Socket socket;
		DataOutputStream out;
		DataInputStream in;
		
		public ServerReceiver(Socket socket) {	
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void run() {
			
			String name = null; // 접속한 사용자의 이름
			
			try {
				name = in.readUTF();    // 이름을 스트림을 통해 받는다. 
				clients.put(name, out); // map에 사용자 정보 저장
				sendToAll(">>>>>>"+ name + "님이 접속하셨습니다."); // 내부(Inner)클래스에서는 Outer클래스의 멤버를 참조할 수 있다.
			
				while(in != null) {
					sendToAll(in.readUTF());
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				clients.remove(name);
				System.out.println(name + "님이 나가셨습니다.");
			}			
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		new TCPIPMultiChatServer().start();
			
		}
	
}
