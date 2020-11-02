package bitBankProject;

import java.util.ArrayList;

public class Account implements Util {


	private String AccountName;    // 계좌주 이름
	
	private String AccountNumber;	// 계좌번호

	private String password;	// 계좌 비밀번호

	private long balance;	// 잔액

	static Account AccountArray[] = new Account[100];	// 베열 생성

	private Transaction[] transactions;	// 거래내역

	private int totalTrans;	// 횟수



	// 내부에서 인스턴스 생성

	private static Account manage = new Account();



	// 생성자 호출 제한

	private Account() {



	}



	// 외부에서 참조변수를 받을 수 있는 메서드

	public static Account getInstance() {

		return manage;

	}



	

	// 계좌 생성

		public void AccountOpening() {

		System.out.println("[===계좌  생성===]");

		for (int i = 0; i < AccountArray.length; i++)

			if (AccountArray[i] == null) {

				System.out.print("계좌 번호 :  ");

				String AccountNumber = SC.next();

				if (FindAccount_Nu(AccountNumber) != null) {

					System.err.println("※ 계좌번호가 중복됩니다. ");

					return;

				} else {

					System.out.print("계좌주 : ");

					String AccountName = SC.next();

					System.out.println(

							(new StringBuilder(String.valueOf(AccountName))).append(" 고객의 주민등록번호 : ").toString());

					String ReNumber = SC.next();

					System.out.print("새 비밀번호 : ");

					String Password = SC.next();

					System.out.print("입금 금액 : \r");

					long DepositAmount = SC.nextLong();

					AccountArray[i] = new Account(SelectBank, AccountNumber, AccountName, ReNumber, Password, DepositAmount);

					System.out.println("========================================");

					System.out.println(

							(new StringBuilder("※ ")).append(FindAccount_Nu(AccountNumber).getAccountName()).append("님의 계좌가 정상적으로 개설되었습니다.").toString());

					System.out.println((new StringBuilder("[은행 명 : ")).append(AccountArray[0].getSelectBank()).append("]\n[계좌 주 : ").append(AccountArray[0].getAccountName()).append("]\n[계좌 번호 : ").append(AccountArray[0].getAccountNumber()).append("] 입니다.").toString());

					System.out.println("========================================");

					System.out.println("※ 위 내용을 확인 바랍니다. \r");

					return;

				}

			}



		System.err.println("※ 계좌를 개설 할 수 없습니다.");

	}

	 

	

	

	// 계좌 입금

	public void saving() {

		System.out.println("[===입  금===]");

		System.out.print("계좌 번호: ");

		String number = SC.next();

		Account account = FindAccount_Nu(number);

		if(FindAccount_Nu(AccountNumber) == null) {

			System.out.println("존재하지 않는 계좌입니다.");

			System.out.println("계좌번호를 다시 확인하시기 바랍니다.");

			return;

		}

		System.out.println("비밀번호 입력 : ");

		String password = SC.next();

		if (account != null) {

			if (!password.equals(account.getPassword())) {

				System.err.println("비밀번호가 일치하지 않습니다.");

				System.err.println("확인 후 이용 바랍니다.");

				System.out.println();

			} else {

				System.out.print("입금 금액 : ");

				long money = SC.nextLong();

				System.out.println();

				account.setBalance(account.getBalance() + money);	// 잔액+입금 금액

				transactions[totalTrans++] = new Transaction("입금", money);	// 거래내역 추가

				System.out.println("계좌에 " + money + "원이 입금되었습니다.");

				System.out.println("현재 잔액은 " + account.getBalance() + "원 입니다.\r");

			}

		} else {

			System.out.println("존재하지 않는 계좌입니다.");

			System.out.println("계좌번호를 다시 확인하시기 바랍니다.");

		}

	}



	// 계좌 출금

	public void withdraw() {

		System.out.println("[===출  금===]");

		System.out.print("계좌 번호: ");

		String number = SC.next();

		Account account = FindAccount_Nu(number);

		if(FindAccount_Nu(AccountNumber) == null) {

			System.out.println("존재하지 않는 계좌입니다.");

			System.out.println("계좌번호를 다시 확인하시기 바랍니다.");

			return;

		}

		System.out.println("비밀번호 입력 : ");

		String password = SC.next();

		if (!password.equals(account.getPassword())) {

			System.err.println("입력하신 비밀번호가 일치하지 않습니다.");

			System.err.println("확인 후 이용 바랍니다.");

		}

		if (account != null) {

			System.out.print("출금 금액: \r");

			long money = SC.nextLong();

			if (money > account.getBalance()) {

				System.out.println("잔액이 부족하여 출금할 수 없습니다.");

			} else {

				account.setBalance(account.getBalance() - money);	// 잔액-출금 금액

				transactions[totalTrans++] = new Transaction("출금", money);	// 거래내역 추가

				System.out.println("계좌에서 " + money + "원이 출금되었습니다.");

				System.out.println("현재 잔액은 " + account.getBalance() + "원 입니다.\r");

			}

		}

		

	}



	// 계좌 이체

	public void transfer() {

		System.out.println("[===이  체===]");

		System.out.print("계좌 번호: ");

		String number = SC.next();

		Account account = FindAccount_Nu(number);

		if(FindAccount_Nu(AccountNumber) == null) {

			System.out.println("존재하지 않는 계좌입니다.");

			System.out.println("계좌번호를 다시 확인하시기 바랍니다.");

			return;

		}

		System.out.println("비밀번호 입력 : ");

		String password = SC.next();

		if (!password.equals(account.getPassword())) {

			System.err.println("입력하신 비밀번호가 일치하지 않습니다.");

			System.err.println("확인 후 이용 바랍니다.");

		}

		System.out.println("보내실 금액: ");

		long money = SC.nextInt();

		if (money > account.getBalance()) {

			System.out.println("잔액이 부족하여 이체할 수 없습니다.");

		} else {

			System.out.println("이체할 계좌 : ");

			String number1 = SC.next();

			Account account1 = FindAccount_Nu(number1);



			if(FindAccount_Nu(number1)==null) {

				System.out.println("존재하지 않는 계좌입니다.");

			}



			account.setBalance(account.getBalance() - money);	// account의 잔액-이체금액

			account1.setBalance(account1.getBalance() + money);	// account1의 잔액+이체금액

			transactions[totalTrans++] = new Transaction("이체", money);	// 거래내역 추가

			System.out.println("현재 잔고는 " + account.getBalance() + "원 입니다.\r");



		}



	}



	private static Account FindAccount_Nu(String AccountNumber) {

		for (int i = 0; AccountArray[i] != null; i++)

			if (AccountArray[i].getAccountNumber().equals(AccountNumber))

				return AccountArray[i];

		return null;

	}



	public String getAccountNumber() {

		return AccountNumber;

	}



	public void setAccountNumber(String AccountNumber) {

		this.AccountNumber = AccountNumber;

	}



	public String getPassword() {

		return password;

	}



	public void setPassword(String password) {

		this.password = password;

	}



	public long getBalance() {

		return balance;

	}



	public void setBalance(long balance) {

		this.balance = balance;

	}



	public Transaction[] getTransaction() {

		return transactions;

	}



	public int getTotalTrans() {

		return totalTrans;

	}



	public void setTotalTrans(int totalTrans) {

		this.totalTrans = totalTrans;

	}



	public String getAccountName() {
		return AccountName;
	}



	public void setAccountName(String accountName) {
		AccountName = accountName;
	}



	
	
	 
	
}
