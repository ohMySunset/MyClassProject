<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean result = false;

// 1. multipart/form-data인지 확인
boolean isMultipart = ServletFileUpload.isMultipartContent(request);

if (isMultipart) {

	// 2. 폼에서 받은 데이터(Fileitem)를 저장할 factory 설정
	DiskFileItemFactory factory = new DiskFileItemFactory();

	// 3. 요청받은 input들을 분리해서 처리 할 ServletFileUpload 생성
	ServletFileUpload upload = new ServletFileUpload(factory);

	// 4. 사용자의 요청을 파싱 (FileItem => input의 객체)
	// input들을 파싱하여 FileItem 객체 타입의 리스트에 넣어줌
	List<FileItem> items = upload.parseRequest(request);
	// 줄 세워 정렬 시키기
	Iterator<FileItem> itr = items.iterator();
	// 반복문으로 데이터 찾아서 item에 저장
	while (itr.hasNext()) {

		FileItem item = itr.next();
		// 폼필드와 file을 구분해서 처리 :isFormField() 
		if (item.isFormField()) { // file 타입을 제외한 모든 필드 : true		

	// 파라미터 이름이 title인 데이터를 저장할 변수
	String title = null;
	// form에서 필드 네임 받아오기
	String fName = item.getFieldName();
	// 필드이름이 title이면 한글처리로 받아와서 title에 저장
	if (fName.equals("title")) {
		title = item.getString("utf-8");
	}
	// 속성에 저장
	request.setAttribute("title", title);
		} else { // 타입이 file인 필드 : false

	String fName = item.getFieldName(); // 파일의 필드이름 
	String userFileName = item.getName(); // 유저가 지정한 파일 이름
	String contentType = item.getContentType(); // 컨텐트 타입
  long fileSize = item.getSize(); // 파일의 사이즈

	System.out.println("필드 이름 : " + fName);
	System.out.println("파일의 이름 : " + userFileName);
	System.out.println("컨텐트 타입 : " + contentType);
	System.out.println("파일의 사이즈 : " + fileSize);
	
		// 파일을 특정 폴더에 저장(쓰기)
    
		if(!userFileName.isEmpty() && fileSize > 0){
			
			// 파일을 저장할 경로 (upload 폴더 안으로)
			String dir = request.getSession().getServletContext().getRealPath("/upload");
			System.out.println(dir);
			
			// 파일의 저장 경로를 File객체로 생성
			File saveFilePath = new File(dir);
			
			// 저장할 폴더가 생성되어있지 않으면 생성해주기
			if(!saveFilePath.exists()){
				saveFilePath.mkdir();
			}
			
			// 파일 쓰기(저장)
			item.write(new File(saveFilePath, userFileName));
			System.out.println("파일 저장 완료!");
			
			request.setAttribute("saveFileName", userFileName );
		}
		}
		
	}

	// 데이터 업로드 정상 처리
	  result = true;
	  request.setAttribute("result", result);
}
%>
<jsp:forward page="uploadView.jsp" />