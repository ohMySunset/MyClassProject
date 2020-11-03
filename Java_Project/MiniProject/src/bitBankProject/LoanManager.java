package bitBankProject;

import java.util.InputMismatchException;

public class LoanManager implements Util{
	
		

	JudgeQualification loan1 = new JudgeQualification();
	LoanProgress loan2 = LoanProgress.getInstance();
	LoanRepay loan3 = new LoanRepay();
	LoanInfor loan4 = new LoanInfor();
	
	

	   void startBankMenu(){
			
			AccountMain account = new AccountMain();		
			LoanManager manager = new LoanManager();
		   
			
		 	// 1차 분기 	
		    while(true) {		    	   
		      	 System.out.println("안녕하세요! 은행 업무 선택 메뉴입니다."); 
		      	 System.out.println("어떤 은행 업무를 선택하시겠습니까?");
		      	 System.out.println("=======================");
		      	 System.out.println(" 1. 계좌 업무 ");
		      	 System.out.println(" 2. 대출 업무 ");
		      	 System.out.println("=======================");
		      	 
		      	 int select = 0; 
		      	 
		      	try {
					
		    		select = SC.nextInt();
		    		SC.nextLine();
		    		
		    		if(!(select>=Util.SHORT_LOAN && select<=Util.BEFORE)) { 	
		        		MenuMismatchException e = new MenuMismatchException(String.valueOf(select));
		        		throw e;
		      	    }
		        	// 주어진 메뉴를 제외한 숫자 혹은 특수문자를 입력했을 때 예외처리
		        	} catch(InputMismatchException | MenuMismatchException e){
		        		System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
		        		SC.nextLine();
		        		continue;
		        	} catch (Exception e) {
		    			System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");		
		    			SC.nextLine();
		    			continue;
		    		}
		      	
		      	 switch(select) {
		      	 case 1 :
		      		 System.out.println("계좌 업무 화면으로 이동합니다>>");
		      		 account.startAccountMenu();
		      		 break;
		      	 case 2 :
		      		 System.out.println("대출 업무 화면으로 이동합니다>>");
		      		manager.startLoanMenu();
		      		 break;		          	
		      	 }
		    
		        }
		    
			}
	
	

    // 2차 분기
	void startLoanMenu() {
	
       while(true) {
    	   
    	   int select = 0;
    	   
    	   SC.nextLine();
    	   
    	   System.out.println("안녕하세요 대출관리 메뉴입니다. 무엇을 도와드릴까요>?");
    	   System.out.println("====================================");
    	   System.out.println(" 1. 대출 자격 심사");
    	   System.out.println(" 2. 대출 실행");
    	   System.out.println(" 3. 대출금 상환 ");
    	   System.out.println(" 4. 대출 내역 확인");
    	   System.out.println(" 5. 이전 단계 ");
    	   System.out.println("====================================");
    	   	     	              
     
       
       select = SC.nextInt();        
       SC.nextLine();
       
       switch(select) {
       case 1 :     
    	   loan1.showPossibleAmound();
    	   break;
	   case 2 :    				   
		   loan2.executeLoan();	 
		   break;
	   case 3 : 
		  loan3.LoanRepay();
		   break;
	   case 4 :
		  loan4.ShowLoanInfor();
		   break;	
	   case 5 :
		   return;
	   }
	
	}
       
	
	
	}
}
	

