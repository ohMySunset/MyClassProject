package CreatMultiChat;
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

	  // 사용자들의 정보를 저장할 Map
	HashMap<String, Object> clients;

	  // 클래스 인스턴스 초기화, 동기화 -> 나중에 쓰레드에서 사용할 것이기 때문에
	public TCPIPMultiChatServer() {	
		clients = new HashMap<String, Object>();
		Collections.synchronizedMap(clients);
	}
	
	
	public void start() throws IOException {
		// 서버소켓 생성	
		ServerSocket serverSocket = new ServerSocket(7777);  // 포트 값 부여
		System.out.println("서버에 연결되었습니다. 채팅을 시작할 수 있습니다!");
		
		//사용자가 요청할때까지 대기하는 소켓, 밑에서 초기화
		Socket socket = null;
		
		while(true) {	// 반복문	
			// 요청이 들어오면 새로운 소켓을 생성해서 반환
			socket = serverSocket.accept();
			
			// 접속자가 있을 때 사용자들에게 메세지 전송 
		System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"] 에서 접속하였습니다.");	
		 
		ServerReceiver receiver = new ServerReceiver(socket);
		receiver.start();
		
		
		}
	}

	// 모든 사용자에게 정보를 보여주기 위한  메서드
	void showToAll(String msg) {
		 //저장된 사용자 정보들을 일괄처리, key값-> Set / map은 순서가 없기때문에 -> iterator
		Set<String> keys = clients.keySet(); //Map안의 키값들이 모두 저장된 keys를 반환		
		Iterator<String> itr = keys.iterator(); //key들의 순서를 정렬
		while(itr.hasNext()) {
			// 정렬한 Map키의 값을 반환하여 스트림에 저장. Object타입 -> DataOutputStream 형변환 
			DataOutputStream out = (DataOutputStream) clients.get(itr.next());
			
			try {
				// 스트림에 저장된 정보중에서 입력받은 Key(name)의 Value값을 출력
				out.writeUTF(msg);
			} catch (IOException e) {		
				e.printStackTrace();
			}
		}
		   
	}
	
	// 내부클래스 생성 -> 메인클래스가 아니어도 아우터클래스의 인스턴스 메서드를 사용할 수 있음.
	// 데이터를 받아서 저장하고 메시지를 발송한다. 
    private class ServerReceiver extends Thread{
    	
    	Socket socket;
    	DataInputStream in;
    	DataOutputStream out;
    	
		public ServerReceiver(Socket socket) {	

			this.socket = socket;		
		 
		    try {   // socket을 통해 연결하고자하는 자원의 읽고 쓰기가 가능. 
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
								
			} catch (IOException e) {				
				e.printStackTrace();
			}
		 		 
		}
    	@Override
		public void run() {
			
    		String name = null; // 접속한 사용자 이름
    		
    		try {
				name = in.readUTF(); // 사용자로부터 이름을 받기
				clients.put(name, out); //스트림을 통해 받은 정보를 map에 정보를 저장.
				showToAll(">>>>> "+ name +"님이 입장하셨습니다.");								
				
			//	showToAll("현재 접속자는 "+ clients.size() + "입니다.");
				
				while(in != null) { // 사용자로부터 데이터 입력이 없을 때 까지 반복
					showToAll(in.readUTF());
				}

			} catch (IOException e) {		
				e.printStackTrace();
			} finally {
				clients.remove(name);
				System.out.println(name+" 님이 나가셨습니다.");
			}
    		
    		
		}
    	    		
    }
    public static void main(String[] args) throws IOException {
    	
    	new TCPIPMultiChatServer().start();
	
}
}