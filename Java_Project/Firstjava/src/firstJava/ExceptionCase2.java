package firstJava;

public class ExceptionCase2 {

	public static void main(String[] args) {
	
		try {  //예외가 발생할 수 있는 코드를 하나의 try블록에 묶고 그에 따른 catch블록을 만들어도 된다. 
		 int[] arr = new int[3]; // index -> 0~2	
		 arr[10] =20;
		
		 arr = new int[-10];
		
		 Object obj = new int[10];		
		 String str = (String)obj;
		
		 String str1 = null;		
		 int len = str1.length();
		
	//	 catch(Exception e) {    //가장 넓은 범위의 예외클래스, 하나만 써주어도 위의 예외가 다 걸러짐.	 
	//		System.out.println(e.getMessage());
	//	}
		 
		}  catch(ArrayIndexOutOfBoundsException e){ 
			System.out.println(e.getMessage());
		} catch(NegativeArraySizeException e)    {
			System.out.println(e.getMessage());			
		} catch(ClassCastException e)            {
			System.out.println(e.getMessage());	
		} catch(NullPointerException e)          {
				System.out.println(e.getMessage());
		} catch(Exception e) { // 어떤 예외가 발생했는지 모르기 때문에 맨 뒤로 보내주던지 맨앞에 하나만 써줌. 
			    //가장 넓은 범위의 예외클래스
			System.out.println(e.getMessage());
		}
			System.out.println("메서드가 종료됩니다. ");
		
	
}
}