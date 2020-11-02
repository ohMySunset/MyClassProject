package bitBankProject;


public class AccountMain implements Util {



	static int money; // 돈


	public static void main(String[] args) {



		Account manage = Account.getInstance();

		Transaction t = Transaction.getInstance();



		while(true) {

			System.out.println(" 안녕하세요. 무엇을 도와드릴까요? ");

			System.out.println("========================== ");

			System.out.println("1. 계좌 생성");

			System.out.println("2. 계좌 조회");

			System.out.println("3. 계좌 해지");

			System.out.println("4. 예금");

			System.out.println("5. 출금");

			System.out.println("6. 이체");

			System.out.println("7. 계좌 거래내역 조회");

			System.out.println("========================== ");



		/*	int MenuSelect = SC.nextInt();

			if (MenuSelect == 1)

				manage.AccountOpening();

			else if (MenuSelect == 2)



			else if (MenuSelect == 3)



			else if (MenuSelect == 4)

				manage.saving();

			else if (MenuSelect == 5)

				manage.withdraw();

			else if (MenuSelect == 6)

				manage.transfer();

			else (MenuSelect == 7)

				t.trans();

*/

			

		}



	}


			
	

}
