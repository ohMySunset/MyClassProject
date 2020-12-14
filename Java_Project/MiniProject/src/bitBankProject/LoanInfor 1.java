package bitBankProject;


public class LoanInfor{

	private String name;           // 고객이름
	private String password;
	private String account;        // 계좌
	private String loanPeriod;     // 대출 기간
//	private double interestRate;   // 대출 금리
	private int loanAmount;        // 대출
	private int loanBalance;       // 대출 잔액
	private int balance;           // 계좌 잔액
	private int interest;       // 이자
		
	
	private final double SHORT_INTEREST_RATE = 0.07;	// 단기 대출 금리
	private final double LONG_INTEREST_RATE = 0.03;	// 장기 대출 금리

	
	// 생성자로 초기화 	

	public LoanInfor() {			
	}
	
	public LoanInfor(String name, int loanAmount, String loanPeriod, int interest) {
		this.loanPeriod = loanPeriod;
		this.loanAmount = loanAmount;
		this.loanBalance = loanBalance;
		this.balance = balance;
		this.interest = interest;

	}


	// getter / setter 
	public String getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(String loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(int loanBalance) {
		this.loanBalance = loanBalance;
	}
	
    public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}


	public double getSHORT_INTEREST_RATE() {
		return SHORT_INTEREST_RATE;
	}

	public double getLONG_INTEREST_RATE() {
		return LONG_INTEREST_RATE;
	}

	
	



	// 단기 대출 이자 반환 메서드
	int ShortLoanInterest(int loanAmount) {
		interest = (int)(loanAmount*SHORT_INTEREST_RATE/12);
		return interest;
	}
	
	// 장기 대출 이자 반환 메서드
	int LongLoanInterest(int loanAmount) {
		interest = (int)(loanAmount*LONG_INTEREST_RATE/5/12);
		return interest;
	}
	
	// 단기 대출 잔액 반환 메서드
	int ShortLoanBalance(int loanAmount) {
		loanBalance = loanAmount-(int)(loanAmount*SHORT_INTEREST_RATE/12);
		return loanBalance;
	}
	
	// 장기 대출 잔액 반환 메서드
	int LongLoanBalance(int loanAmount) {
		loanBalance = loanAmount-(int)(loanAmount*LONG_INTEREST_RATE/5/12);
		return loanBalance;
	}
	
	
	// 대출 내역 확인 메서드
	void ShowLoanInfor() {
		System.out.println("성       함 : "+name);
		System.out.println("대출 기간 : "+loanPeriod);
		System.out.println("대출 금액 : "+loanAmount);
		
		if(loanPeriod.equals("1년")) {	// 단기 대출
			System.out.println("금       리 : "+SHORT_INTEREST_RATE);
			System.out.println("대출 잔액 : "+ShortLoanBalance(loanAmount));
			System.out.println("이자 잔액 : "+ShortLoanInterest(loanAmount));
			
		} else {						// 장기 대출
			System.out.println("금       리 : "+LONG_INTEREST_RATE);
			System.out.println("대출 잔액 : "+LongLoanBalance(loanAmount));
			System.out.println("이자 잔액 : "+LongLoanInterest(loanAmount));
		}
		
	}
	

	
	
	
}
