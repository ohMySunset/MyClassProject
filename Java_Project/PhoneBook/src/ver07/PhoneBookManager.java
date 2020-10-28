package ver07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

import ver03.Util;

public class PhoneBookManager implements Util, Menu {

	
	// 정보를 저장할 배열 선언
	private ArrayList<PhoneInfor> list;
	
	
	// 생성자를 통한 초기화
	private PhoneBookManager(int num) {
		//ArrayList<PhoneInfor> 초기화
		list = new ArrayList<PhoneInfor>();	
		num = 0;
		//★ 파일에서 인스턴스들을 로드 (프로그램 실행 순서 잘 생각하기)
		load();
		
	}

    // PhoneBookManager타입의 인스턴스 싱글톤 처리
	// 인스턴스 생성 -> 미리 생성되어 있어야 하므로 static
	private static PhoneBookManager manager = new PhoneBookManager(100); 
	// 인스턴스를 호출할 수 있는 메서드 
	public static PhoneBookManager getInstance() {
		return manager;
	}
	
			
	// 정보 저장 메서드
	// 1) 배열에 정보를 추가하는 메서드
	void inputArray(PhoneInfor p)  {		    
		list.add(p);
	}
	
	
	// 2) 사용자로부터 입력받은 정보를 분류하여 인스턴스 생성.
	// 인터페이스 기반의 상수처리를 하여 메뉴 구성
	public void insertInfor() {
		
		int select = 0;		
		
		while(true) {
			System.out.println("어떤 정보를 입력하시겠습니까?");
			System.out.println(Menu.STANDARD+". 일반");
			System.out.println(Menu.UNIV+". 대학");
	    	System.out.println(Menu.COM +". 회사");
	    	System.out.println(Menu.CAFE +". 동호회");	    		
	    
	    	
	    	// 예외가 발생할 수 있는 부분
	    	try {
	    	select = sc.nextInt();
	    		   
	    	
	    	if(!(select>=Menu.STANDARD && select<=Menu.CAFE)) { 	
	    		MenuMismatchException e = new MenuMismatchException(String.valueOf(select));
	    		throw e;
	  	    }
	    	// 주어진 메뉴를 제외한 숫자 혹은 특수문자를 입력했을 때 예외처리
	    	} catch(InputMismatchException | MenuMismatchException e){
	    		System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
	    		sc.nextLine();
	    		continue;
	    	} catch (Exception e) {
				System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");		
				sc.nextLine();
				continue;
			}
	    	break;
		}  	
		    
		     sc.nextLine();
	    	System.out.println("정보 입력을 시작합니다.");
	    	System.out.println("이름 >> ");	
	    	String name = sc.nextLine();		    	
	    	System.out.println("전화번호 >> ");
	    	String phoneNum = sc.nextLine();	    	
	    	System.out.println("주소 >>");
	    	String addr = sc.nextLine();
	    	System.out.println("이메일 >>");
	    	String email = sc.nextLine();
	    		    		    	
	    	
	    	
	    	switch (select) {   
	    	case STANDARD :
	    		inputArray(new PhoneInfor(name, phoneNum, addr, email));	    	
	    		break;
	    	case UNIV : 
	    		//전공, 학년 
	    		System.out.println("전공>>");
	    		String major = sc.nextLine();	    	
	    		System.out.println("학년>>");
	    		int grade = sc.nextInt();
	    		sc.nextLine();
	    		inputArray(new UnivPhoneInfor(name, phoneNum, addr, email, major, grade));
	    		break;
	    	case COM : 
	    		// 회사이름
	    		System.out.println("회사 이름>>");
	    		String company = sc.nextLine();
	    		inputArray(new CompanyPhoneInfor(name, phoneNum, addr, email, company));
	    		break;
	    	case CAFE : 
	    		// 동호회 이름, 닉네임
	    		System.out.println("동호회 이름>>");
	    		String cafeName = sc.nextLine();
	    		System.out.println("닉네임>>");
	    		String nickName = sc.nextLine();
	    		inputArray(new CafePhoneInfor(name, phoneNum, addr, email, cafeName, nickName));
	    		break;	    		
	    	}   		    	
	    	System.out.println("입력하신 정보가 저장되었습니다.[저장개수 :"+list.size()+"]");	 	    		
		}
	

	// 2) 정보 검색 메서드
	// 입력한 이름과 비교해서 인덱스를 반환해주는 메서드
	public int searchIndex(String name) {
		int index = -1;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name))
				index = i;
		}				
		return index;
	}
	
		
	
	// 입력된 이름에 부합하는 정보를 출력하는 메서드
	void searchInfor() {	
		sc.nextLine();
		if(list.size()==0) {
		   System.out.println("메모리에 저장된 정보가 없습니다.");
		   System.out.println("정보를 저장하신 후 다시 시도해주세요");
		   return;
		}
		System.out.println("검색하실 정보의 이름을 입력해주세요.");
		String name = sc.nextLine();
		int index = searchIndex(name);
		if(index<0) {
			System.out.println("찾으시는 "+name+" 와(과) 일치하는 정보가 없습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
			return;
		} else {
			System.out.println("검색 결과 >>");
			list.get(index).showInfor();
		}
	}
		
	
	// 3) 삭제 메서드
    // 사용자에게 이름을 입력받고 이름으로 검색한 후 정보 삭제
    public void deleteInfor() {    	
    	if(list.size()==0) {
 		   System.out.println("메모리에 저장된 정보가 없습니다."+"\n 정보를 저장하신 후 다시 시도해주세요.");
 		   return;
 	   }
    	sc.nextLine();
    	System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요");
    	String name = sc.nextLine();
    	int index = searchIndex(name);
    	if(index<0) {
    		System.out.println("찾으시는 "+name+" 와(과) 일치하는 정보가 없습니다.");
    		System.out.println("초기화면으로 이동합니다.");
    	} else {
    		list.remove(index);
    		}    		
    		System.out.println("요청하신 이름의 정보를 삭제하였습니다.");
    	}	
    
   
    
    // 4) 기본 정보 출력 메서드
    public void showShortInfo() {
    	if(list.size()==0) {
  		   System.out.println("메모리에 저장된 정보가 없습니다."+"\n 정보를 저장하신 후 다시 시도해주세요.");
  		   return;
  	   }
    	System.out.println("기본 정보 출력 결과 >>");
    	for(int i=0;i<list.size();i++){
    		list.get(i).showBasicInfor();
     		System.out.println("----------------------");
       }   	
    }
    
    
  
    // 5) 전체 정보 출력 메서드
    public void showAllInfor() {
 	   if(list.size()==0) {
 		   System.out.println("메모리에 저장된 정보가 없습니다."+"\n 정보를 저장하신 후 다시 시도해주세요.");
 		   return;
 	   }
     	System.out.println("전체 정보 출력 결과 >>");
     	for(int i=0;i<list.size();i++) {
     		list.get(i).showInfor();
     		System.out.println("----------------------");
     	}
     }
   
    
    
    // 2020.10.27 업데이트 : 직렬화로 데이터 저장, 로드 기능 추가   
    // 6) List:infor에 저장되어 있는 인스턴스들을 저장하는 기능
    public void save() {
    	
    	if(list.size()==0) {
    		System.out.println("저장된 데이터가 없어 파일이 저장되지 않습니다.");
    		return;
    	}
    	
    	try {
    	// 인스턴스를 저장할 수 있는 출력스트림 생성
    	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.ser"));
 //   	for( PhoneInfor pi : list) {
 //   		out.writeObject(pi);
 //   		out.close();
 //   	}
    	   out.writeObject(list);
    	   out.close();
    	
    	  System.out.println("저장되었습니다.(phonebook.ser)");
    	} catch(IOException e){
    		System.out.println("저장하는 과정에 오류가 발생했습니다. ("+ e.getMessage()+ ") \n 다시 시도해 주세요");
    	}
    }
  
    
    // 7) 프로그램으로 파일의 저장 데이터를 로드하는 기능
    void load() {
    	// 파일의 존재여부 확인 : File 클래스 이용
    	File file = new File("phonebook.ser");
    	if(file.exists()==false) {
    		System.out.println("저장된 파일이 존재하지 않습니다. 파일 저장 후 Load가 됩니다.");
    		return;
    	}
    	// 파일에 있는 데이터를 메모리에 저장 : list에 저장
    	// 파일의 데이터를 read() (읽을 수 있는) 스트림 생성    
    	try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("phonebook.ser"));
//	      while(true) {	    
//	    	 Object obj = in.readObject();	    
//	    	 if(obj==null) {
//	    		 break;
//	    	 }
//	    	 list.add((PhoneInfor)obj);
//	      }
			list = (ArrayList<PhoneInfor>)in.readObject();
			System.out.println("데이터 로드 완료...");
    	} catch (IOException e) {
	  //     System.out.println("데이터를 로드하는 과정에 오류가 발생했습니다.");
	  //    e.printStackTrace();
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		}
    	
    	
    }
   
    
}
    
	
	

