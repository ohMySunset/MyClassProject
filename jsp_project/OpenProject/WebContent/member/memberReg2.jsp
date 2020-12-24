<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	int result = 0;

  String dir = request.getSession().getServletContext().getRealPath("/upload/member");

  // DAO객체의 insert 메서드로 member 참조변수 전달, Connection 객체의 참조변수 전달 
  Connection conn = ConnectionProvider.getConnection();
  MemberDao dao = MemberDao.getInstance();

  // 객체 생성이 성공했을 경우 처리
  if (conn != null) {

	// 폼에 입력한 사용자 입력 데이터의 한글 처리
	// request.setCharacterEncoding("utf-8");
	
	String userId = null;
	String pw = null;
	String userName = null;
	String userPhoto = null;

	// fileUpload 라이브러리를 이용해서 DB에 입력할 데이터를 받아와야 한다.
	if(ServletFileUpload.isMultipartContent(request)){
			
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = upload.parseRequest(request);
		
		Iterator<FileItem> itr = items.iterator();
		
		while(itr.hasNext()){
			FileItem item = itr.next();
			// type = file 여부 확인 -> 각 필드의 값을 축출
		  if(item.isFormField()){ // 일반 필드			  
			  String fName = item.getFieldName();
			  
		     if(fName.equals("userid")){
			    userId = item.getString("utf-8");
		     }		
		     if(fName.equals("pw")){
				    pw = item.getString("utf-8");
			     }	
		     if(fName.equals("username")){
				    userName = item.getString("utf-8");
			     }	
		  } else { // 파일 필드
			  
			  if(item.getFieldName().equals("userPhoto") && !item.getName().isEmpty() && item.getSize()>0){
				  			  
				  // 경로를 저장하는 File 객체를 생성
				  File saveFilePath = new File(dir);
				  
				  // 폴더가 존재하는지 여부
				  if(!saveFilePath.exists() || !saveFilePath.isDirectory()){
					  saveFilePath.mkdir();
				  }
				  
				  // split(".") .을 기준으로 자르고 배열 생성 : mini.jpg -> "mini","jpg"
				  // 새로운 파일 이름 : 중복하는 파일의 이름이 있으면 덮어쓴다. -> nanoTime()으로 중복되지 않는 이름을 만들어 준다.  
				  String newFileName = System.nanoTime() + "."+ item.getName().split("\\.")[1];
				  
				  // 파일 저장
				  item.write(new File(saveFilePath, newFileName));
				  
				  userPhoto = newFileName;
			  }		  
		  }			
		}
		
		// Member 타입의 객체 불러오기
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(pw);
		member.setUserName(userName);
		member.setUserPhoto(userPhoto);

		System.out.println(member);

		try{
		// DB에 데이터 저장
		result = dao.insertMember(conn, member); // SQLException 발생 시 DB에 저장 안됨. 하지만 파일은 저장이 되어있다. 
		} catch(Exception e){
		 	File delFile = new File(dir, userPhoto);
			if(delFile.exists()){
				// 해당 파일을 삭제
				delFile.delete();
			} 
			
		}
		}	
	

}
  
  request.setAttribute("result", result);
  
%>
<jsp:forward page="memberRegView.jsp"/>