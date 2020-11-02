package bitBankProject;

import java.util.Calendar;

public class Transaction implements Util {
	private String transactionDate; // 거래일자

	private String transactionTime; // 거래시간

	private String transType; // 입금 or 출금 or 이체

	private long amount; // 거래금액

	

	// 내부에서 인스턴스 생성

	private static Transaction t = new Transaction();



	// 생성자 호출 제한

	private Transaction() {



	}



	// 외부에서 참조변수를 받을 수 있는 메서드

	public static Transaction getInstance() {

		return t;

	}

	

	Transaction(String type, long money){

		Calendar c = Calendar.getInstance();

		transactionDate = c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DATE);

		transactionTime = c.get(Calendar.HOUR)+"시 "+c.get(Calendar.MINUTE)+"분 "+c.get(Calendar.SECOND)+"초";

		transType = type; //거래종류

		amount = money; //거래량

		

	}



	public void trans() {



		Account manage = Account.getInstance();

		

		System.out.print("계좌 번호: ");

		String Accountnumber = SC.next();

		Account account = FindAccount_Nu(Accountnumber);

		System.out.println("비밀번호 입력 : ");

		String password = SC.next();

		if (account != null) {

			if (!password.equals(account.getPassword())) {

				System.err.println("비밀번호가 일치하지 않습니다.");

				System.err.println("확인 후 이용 바랍니다.");

				System.out.println();

			} else {

				System.out.print(" 고객님의 계좌 : "+ Accountnumber + "의 거래내역입니다.");

				System.out.println("잔액 : " + manage.getBalance());

				Transaction ts[] = manage.getTransaction();

				for (int i = 0; i < manage.getTotalTrans(); i++) {

					System.out.printf(" %15d원 %5s,		거래일자 : %10s		거래시간 : %10s	\n",

							ts[i].getAmount(), ts[i].getTransType(), ts[i].getTransactionDate(), ts[i].getTransactionTime());

				}

			}

		}

	}

	

//고치기

	private static Account AccountArray[] = new Account[100];	// 베열 생성

	private static Account FindAccount_Nu(String AccountNumber) {

		for (int i = 0; AccountArray[i] != null; i++)

			if (AccountArray[i].getAccountNumber().equals(AccountNumber))

				return AccountArray[i];

		return null;

	}

	

		public String toString() {

			return transType;

		}



		public String getTransactionDate() {

			return transactionDate;

		}



		public void setTransactionDate(String transactionDate) {

			this.transactionDate = transactionDate;

		}



		public String getTransactionTime() {

			return transactionTime;

		}



		public void setTransactionTime(String transactionTime) {

			this.transactionTime = transactionTime;

		}



		public String getTransType() {

			return transType;

		}



		public void setTransType(String transType) {

			this.transType = transType;

		}



		public long getAmount() {

			return amount;

		}



		public void setAmount(long amount) {

			this.amount = amount;

		}
}
