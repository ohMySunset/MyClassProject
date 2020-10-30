import java.util.Scanner;

public class LoanProgress extends LoanInfor{

	
	
	private String loanPeriod;
	private double interestRate;
	private double possibleAmount;
	private int loanAmount;
	private String membership;
	
	
	public LoanProgress() {
		this.loanPeriod = "0";
		this.interestRate = 0.0;
		this.possibleAmount = 0;
		this.loanAmount = 0;
	}

	Scanner sc = new Scanner(System.in);
	
	void excuteLoan(int select) {	
		
         if(membership != platinum) {
			System.out.println("멤버쉽 등급을 만족하지 못해 대출을 실행할 수 없습니다. 메뉴로 돌아갑니다.");
			return;
		} 
         if(loanAmount!=0) {
 			System.out.println("이미 대출하신 내역이 존재합니다. 상환 완료 후에 대출이 가능합니다. 메뉴로 돌아갑니다.");
 			return;
 		}
		
		System.out.println("대출 실행 화면 입니다.");
		System.out.println("=====================");
		System.out.println("어떤 대출을 실행하시겠습니까?");
		System.out.println("1. 단기 대출");
		System.out.println("2. 장기 대출");
		System.out.println("=====================");
				
		
		switch(select) {
		      	
		       case 1 :
		        System.out.println("단기 대출 화면입니다. 대출 가능한 금액과 금리를 확인해주세요.");
		        executeShortLoan(balance);
		       case 2 :
		    	System.out.println("장기 대출 화면입니다. 대출 가능한 금액과 금리를 확인해주세요.");
		    	   
		}					
	}		
	
	
	public int executeShortLoan(int balance) {	
				
		interestRate = 7.0;
		loanPeriod = "1년";
		
		if(60000 <= balance && balance < 100000) {
			possibleAmount = balance*0.5;
		} else if(10000<= balance && balance <150000) {
			possibleAmount = balance*0.7;		
		} else {
			possibleAmount = balance*0.9;
		}		
		System.out.println("( 상환기간 : "+ loanPeriod +", 금리 : "+ interestRate +"% )");				
		System.out.println("가능금액 : " + possibleAmount +"원 입니다.");
		System.out.println("대출하실 금액을 입력해주세요.");
		
		loanAmount = sc.nextInt();
				
		System.out.println("대출이 완료되었습니다. 내용을 확인해주세요.");
		System.out.println("가능금액 : " + possibleAmount +"원" + "대출금액 : "+ loanAmount +"원");
	
		return loanAmount;
	}
		
	
	
  public int executeLongLoan(int balance) {

	  interestRate = 3.5;
	  loanPeriod = "5년";
	  
	  if(60000 <= balance && balance < 100000) {
			possibleAmount = balance*0.5;
		} else if(10000<= balance && balance <150000) {
			possibleAmount = balance*0.7;		
		} else {
			possibleAmount = balance*0.9;
		}		
		System.out.println("( 상환기간 : "+loanPeriod+ ", 금리 : "+ interestRate +"% )");				
		System.out.println("가능금액 : " + possibleAmount +"원 입니다.");
		System.out.println("대출하실 금액을 입력해주세요.");
		
		loanAmount = sc.nextInt();
				
		System.out.println("대출이 완료되었습니다. 내용을 확인해주세요.");
		System.out.println("가능금액 : " + possibleAmount +"원" + "대출금액 : "+ loanAmount +"원");	
	  		  
     return loanAmount;
  }
  }
	

