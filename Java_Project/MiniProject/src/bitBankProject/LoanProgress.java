package bitBankProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class LoanProgress implements Util{
	
	
	public static final double SHORT_INTEREST_RATE = 0.07;	// 단기 대출 금리
	public static final double LONG_INTEREST_RATE = 0.03;	// 장기 대출 금리
	
	
    private long loanAmount;          // 대출 금액
    private String loanPeriod;       // 상환기간
    
    
    AccountManager account = AccountManager.getInstance();
    LoanInfor infor = new LoanInfor();
    
    
    //  배열 리스트 생성
    public final List<LoanInfor> loan = new ArrayList<LoanInfor>();
        
    // 싱글톤 처리
    static LoanProgress lp = new LoanProgress()	;  
    public static LoanProgress getInstance() {
    	return lp;
    }
      
    
    // 생성자    
    LoanProgress() {    
    	
    }
    	

	// 리스트에 정보 저장
	void inputArray(LoanInfor l) {
		loan.add(l);
	}
	
		
	// 단기, 장기 대출 진행 메서드		
	public void executeLoan() {	
			
		out:while(true) {
		
		AccountManager am = AccountManager.getInstance();	
		JudgeQualification jq = new JudgeQualification();	
		
		// 1)멤버쉽이 플래티넘 미만일 경우, 2) 이미 대출을 받은 경우에는 진행할 수 없도록 예외처리		
        if(am.membership(jq.membership) != "Platinum") { //멤버쉽 기능이 완성되면 처리
			System.out.println("멤버쉽 등급을 만족하지 못해 대출을 실행할 수 없습니다. 메뉴로 돌아갑니다.");
			return;
		} 
           if(loanAmount != 0) {
			System.out.println("이미 대출하신 내역이 존재합니다. 상환 완료 후에 대출이  가능합니다. 메뉴로 돌아갑니다.");
			return;
		}
		
        System.out.println("멤버쉽 등급을 만족하여 대출 진행이 가능합니다.");
		System.out.println("대출 실행 화면 입니다.");		
		System.out.println("=====================");
		System.out.println("어떤 대출을 진행하시겠습니까?");
		System.out.println("1. 단기 대출");
		System.out.println("2. 장기 대출");
		System.out.println("3. 이전 화면");
		System.out.println("=====================");
				
        		
		int select = 0;
			
		// 메뉴값 예외처리
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
		        System.out.println("단기 대출 화면입니다. ");		        
		        System.out.println("고객님의 이름을 입력해주세요.");		
				String name = SC.nextLine();
				System.out.println("대출 가능한 금액과 금리를 확인해주세요.");
				
						
				
		        // 고객의 이름과 일치하는 계좌의 배열 인덱스를 찾아서 잔액을 반환 -> executeShortLoan 메서드의 매개변수에 대입
		        for(int i=0; account.getAccountArray()[i] != null ; i++) {			        	
		        	if(account.getAccountArray()[i].getAccountName().equals(name)) {	        			
		        		 executeShortLoan(name, account.getAccountArray()[i].getBalance());	        		                   
		        	}	else {
		        	 System.out.println("일치하는 정보를 찾을 수 없습니다.");
		        	 return;		        	 
		        }
		        }
		       	break out;        	
		       	
		        case 2 :
		    	System.out.println("장기 대출 화면입니다. 대출 가능한 금액과 금리를 확인해주세요.");		    	
		    	System.out.println("고객님의 이름을 입력해주세요.");		
				name = SC.nextLine();
		    	
		    	// 고객의 이름과 일치하는 계좌의 배열 인덱스를 찾아서 잔액을 반환 -> executeLongLoan 메서드의 매개변수에 대입
		        for(int i=0;account.getAccountArray()[i] != null ; i++) {		        	
		        	if(account.getAccountArray()[i].getAccountName().equals(name)) {
		              executeLongLoan(name, account.getAccountArray()[i].getBalance());	
		                     
	            } else {
		        	 System.out.println("일치하는 정보를 찾을 수 없습니다.");
		        	 return;
		        }
		        }					    	
		    	break out;	    
		    	
		        case 3 :
		    	System.out.println("이전 화면으로 돌아갑니다.");
		    	return;		    	
		    	
		  
		}   
	    }//while end
	}	
	

	
	
	
	// 단기대출 진행 메서드
	private void executeShortLoan(String name, long balance) {		
		

		loanPeriod = "1년"; // 단기 대출 상환 기간
		
		double possibleAmount;
		
		if(60000 <= balance && balance < 100000) {
			possibleAmount = balance*0.5;
		} else if(10000<= balance && balance <150000) {
			possibleAmount = balance*0.7;		
		} else {
			possibleAmount = balance*0.9;
		}	
		
		System.out.println("===================================================");
		System.out.println("( 상환기간 : "+ loanPeriod +", 금리 : "+ SHORT_INTEREST_RATE +"% )");				
		System.out.println("---------------------------------------------------");
		System.out.println("대출 가능 금액 : " + possibleAmount +"원.");
		System.out.println("===================================================");
		
		System.out.println("원하시는 금액을 입력해주세요.(가능 금액 : "+ possibleAmount +"원)");		
		loanAmount = SC.nextInt();
		System.out.println("입력 완료>>");
						
//		checkMember();		
		
		
		System.out.println("===================================================");
		System.out.println("※ 대출이 정상처리되었습니다. 아래 내용을 확인해주세요.");
		System.out.println("---------------------------------------------------");
		System.out.print("이번 달 이자 "+ infor.ShortLoanInterest(loanAmount)+"원을 제외한 금액,");
		loanAmount = loanAmount-infor.ShortLoanInterest(loanAmount);  //대출금액 - 이번달 이자
		System.out.println(loanAmount+ "원이 고객님의 계좌로 입금됩니다.");		
		System.out.println("===================================================");
		
	
		// 계좌 잔액 + 대출금		
		Account account2 = new Account();
		account2.setBalance(account.getBalance()+loanAmount);			
	
		// 대출이 이루어지면 LoanInfor에 고객의 대출 정보를 저장.
        loan.add(new LoanInfor(name, loanAmount, loanPeriod, infor.ShortLoanInterest(loanAmount)));
		
		
    //      return loanAmount;	
  }

	
	
	 
	// 장기대출 진행 메서드
  private void executeLongLoan(String name, long balance) {
	
	  loanPeriod = "5년";  // 장기 대출 상환 기간
	  
	  double possibleAmount;
	  
	  if(60000 <= balance && balance < 100000) {
			possibleAmount = balance*0.5;
		} else if(10000<= balance && balance <150000) {
			possibleAmount = balance*0.7;		
		} else {
			possibleAmount = balance*0.9;
		}		
	    System.out.println("===================================================");
		System.out.println("( 상환기간 : "+loanPeriod+ ", 금리 : "+ LONG_INTEREST_RATE +"% )");			
		System.out.println("---------------------------------------------------");
		System.out.println("가능금액 : " + possibleAmount +"원.");
		System.out.println("===================================================");
		
		System.out.println("원하시는 금액을 입력해주세요.(가능 금액 : "+ possibleAmount +"원)");		
		loanAmount = SC.nextInt();
		System.out.println("입력 완료>>");		
		
//		checkMember();	
		
		System.out.println("===================================================");
		System.out.println("※ 대출이 정상처리되었습니다. 아래 내용을 확인해주세요.");
		System.out.println("---------------------------------------------------");
		System.out.print("이번 달 이자 "+ infor.LongLoanInterest(loanAmount)+"원을 제외한 금액 ");
		loanAmount = loanAmount-infor.LongLoanInterest(loanAmount); //대출금액 - 이번달 이자
		System.out.println(loanAmount+ "원이 고객님의 계좌로 입금됩니다.");
		System.out.println("===================================================");
		
		// 계좌 잔액 + 대출금
		Account account2 = new Account();
		account2.setBalance(account2.getBalance()+loanAmount);	
		
		// 대출이 이루어지면 LoanInfor에 고객의 대출 정보를 저장.
        loan.add(new LoanInfor(name, loanAmount, loanPeriod, infor.ShortLoanInterest(loanAmount)));
		
		
   	//	return loanAmount;
  }



  


   
  
}


	
	

