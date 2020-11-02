package bitBankProject;

public class JudgeQualification implements Util {	// 대출 자격 심사 클래스

		

		int Balance;				// 계좌잔액

		// 생성자

		public JudgeQualification() {

		}

		

		// 대출 가능 금액 		
	public void showPossibleAmound() {
		System.out.println("멤버십 등급을 입력해주세요 >> ");

		String membership = SC.nextLine();

		

		if(membership=="Platinum") {							// 멤버십 등급이 플래티넘 이상일 경우 대출 가능

			if(Balance>=60000 && Balance<100000) {			// 6만원 <= 계좌잔액 < 10만원 

				System.out.println("최대 대출 가능 금액 : "/*+Balance*0.5*/);

			} else if(Balance>=100000 && Balance<200000) {	// 10만원 <= 계좌잔액 < 20만원 

				System.out.println("최대 대출 가능 금액 : "/*+Balance*0.7*/);

			} else if(Balance>=200000) {					// 계좌잔액 >= 20만원

				System.out.println("최대 대출 가능 금액 : "/*+Balance*0.9*/);

			}

			return;

		} else if(membership=="Silver" && membership=="Gold"){	// 멤버십 등급이 플래티넘 미만일 경우 대출 불가능

			System.out.println("멤버십 등급이 Platinum 미만인 회원은 대출이 불가능합니다.");
			System.out.println("다시 메뉴로 이동합니다.");
			return;

		} else {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("다시 입력해주세요.");
			return;

		}
		
	}
	}
	

	


