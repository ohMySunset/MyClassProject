package mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.Command;
import mvc.command.DateCommand;
import mvc.command.GreetingCommand;
import mvc.command.InvalidCommand;
import mvc.command.MemberLoginCommand;

public class FrontController extends HttpServlet{
	
	// 요청을 맵에 저장해놓고 꺼내쓰기 
	// Map<String, Command> -> <요청URI, Command 클래스를 상속하는 객체>
	private Map<String, Command> commands;

	@Override
	// 최초에 한번 실행하도록 서블릿 설정
	public void init(ServletConfig config) throws ServletException {
		
		commands = new HashMap<String, Command>();
		
		String configPath = config.getInitParameter("configPath");
		// 프로퍼티 객체 생성
		Properties prop = new Properties();
		// 프로퍼티 파일을 읽어오기 위해 FileInputStream 생성
		FileInputStream fis = null;
		
		// 설정 파일의 시스템의 실제 경로 
		String configFilePath = config.getServletContext().getRealPath(configPath);
		
		try {
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		Iterator itr = prop.keySet().iterator();
		
		while(itr.hasNext()) {
			String command = (String) itr.next();
			String className = prop.getProperty(command);
						
			// command 맵 -> command, className의 인스턴스를 저장
							
				try {
			
					Class commandClass = Class.forName(className); //Class 클래스를 통해 클래스들에 대한 정보를 로드
					                           // forName() : 물리적인 클래스 파일명을 인자로 넣어주면 이에 해당하는 클래스를 반환
										
					// Command 인스턴스 생성
					Command commandInstance = (Command) commandClass.newInstance(); 
					//  해당 클래스의 디폴트 생성자를 호출, object 타입으로 반환하기 때문에 형변환 필요 -> 유연한 프로그래밍이 가능
				
				    // command.put(경로, Command 인스턴스)
				   commands.put(command, commandInstance);
				   
				   System.out.println(command+"="+className);
				   
				} catch (InstantiationException | IllegalAccessException e) {
			
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		
		/*
		 * commands = new HashMap<String, Command>();
		 * 
		 * commands.put("/", new GreetingCommand()); commands.put("/greeting", new
		 * GreetingCommand()); commands.put("/date", new DateCommand());
		 * commands.put("/member/login", new MemberLoginCommand());
		 */
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		// 요청을 분석 : URI를 이용해서 분석
		// http://localhost:8080/mvc/greeting -> /greeting만 뽑아내기		
		String command = request.getRequestURI();
		System.out.println(command);
		// /mvc/greeting
		System.out.println(command.indexOf(request.getContextPath()));
		if(command.indexOf(request.getContextPath())==0) {
			command = command.substring(request.getContextPath().length());
		}
		System.out.println(command);
		
		// 요청에 맞는 기능 실행 -> 결과 데이터를 생성
		// Object resultObj = null;
		
		// 맵에서 요청을 꺼내서 처리 
		Command cmd = commands.get(command);
		
		// 경로가 잘못됐을 경우 
		if(cmd==null) {
			cmd = new InvalidCommand();
		}
		
		String viewPage = null;
		
//		if(command.equals("/greeting") | command.contentEquals("/")) {
//			cmd = new GreetingCommand(); // 다형성을 이용한 오버라이딩
//		} else if(command.contentEquals("/date")) {
//		    cmd = new DateCommand();
//		} else if(command.equals("/member/login")) {
//	        cmd = new MemberLoginCommand();
//		} else {
//	        cmd = new InvalidCommand();
//		}
		
		viewPage = cmd.getViewPage(request, response);
		
		// request의 속성에 결과 데이터를 저장
		// request.setAttribute("result", resultObj);
		
		// 응답을 위한 View 페이지로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}

	
	
	
}
