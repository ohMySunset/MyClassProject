package form;

import java.util.Arrays;

//Form에서 전송되는 데이터를 저장하는 beans 정의
public class FormData {

	// 속성 : 변수는 private
	private String name; // 사용자의 이름 name=null;
	private String job;  // 사용자의 직업 job=null;
	private String[] interest; // 사용자의 관심사항 
	
	
	// beans는 컨테이너(외부패키지)가 객체를 생성하기 때문에 디폴트 생성자는 필수
	public FormData() {

	}


	public FormData(String name, String job, String[] interest) {
		super();
		this.name = name;
		this.job = job;
		this.interest = interest;
	}


	// 각 변수들의 getter/setter 메소드를 정의 (public)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String[] getInterest() {
		return interest;
	}


	public void setInterest(String[] interest) {
		this.interest = interest;
	}


	@Override
	public String toString() {
		return "FormData [name=" + name + ", job=" + job + ", interest=" + Arrays.toString(interest) + "]";
	}
	
	
	
	
	
	
}