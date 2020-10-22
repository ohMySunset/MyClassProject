package ver06_Self;

public class CafePhoneInfor extends PhoneInfor {

	
		private String cafeName; // 동호회 이름
		private String nickName; // 닉네임

		// 생성자
		public CafePhoneInfor(String name, String phoneNum, String addr, String email, String cafeName, String nickName) {
			super(name, phoneNum, addr, email);
			this.cafeName = cafeName;
			this.nickName = nickName;
		}
		
		
	    // getter / setter 
		public String getCafeName() {
			return cafeName;
		}		
		public void setCafeName(String cafeName) {
			this.cafeName = cafeName;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		
		
		@Override
		public void showInfor() {	
			super.showInfor();
			System.out.println("동호회 이름 : " + cafeName);
			System.out.println("닉네임 : " + nickName);
		}


		@Override
		public void showBasicInfor() {
			super.showBasicInfor();		
		}

	
	
}
