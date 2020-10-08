
public class MainClass {

	public static void main(String[] args) {
		
	/*
	  Array : 배열 (varieables)
		            같은 자료형 변수들의 묶음.	(주소/값)
		            
                목적	: 같은 목적의 다수의 변수를 관리하기 위함.
                            접근 요소는 번호(index)	      
                  형식 : 자료형 배열변수명[] = new 자료형[ 배열의 총수 ]; *[] 위치는 달라질 수 있음
                            자료형[] 배열변수명 = new 자료형[ 배열의 총수 ];
                            자료형  []배열변수명 = new 자료형[ 배열의 총수 ];
             
             ** []위치는 세가지로 만들 수 있음.
              int arrVar[] = new int[5]; 
              char []arrChar = new char[10];
              double[] arrDou = new double[5];
              
            cf) char *arrChar = new char[10]; ->포인터 사용법
            
              동적할당 : 배열의 총수는 마음대로 정할 수 있음. 그에 따라 개수가 달라짐
              정적할당 : 동적할당으로 변수의 개수를 정해놓은 후에는 앞에 배열값을 바꿀수 없음         
                
          int arrVar[] = new int[5]; //1~5(X) 0~4(O)번지
                                         index number -> 배열은 번호로 관리됨                    
       배열 접근요소는 index -> 1번지, 2번지 ....
           arrVar[0] = 90;
           arrVar[1] = 85;
           arrVar[2] = 90;
                  .
                  .
          arrVar[n-1] = 70;      
           
               형식 :   arrWar[index umber] = 값     
               
                                
	 */
	//5명 학생의 국어점수 총점, 평균 (변수 5개 필요)
		
	int lang1, lang2, lang3, lang4, lang5;
	
	lang1 = 90;
    lang2 = 85;			
    lang3 = 100;
    lang4 = 95;
    lang5 = 75;
    
    int sum = 0;
    
    sum = lang1 + lang2 + lang3 + lang4 + lang5;
    //평균구하기
    
    double avg = 0;
    
    avg = (double)sum / 5; //-> 강제 형변환 해야 정확한 값을 얻을 수 있음.
    System.out.println("avg:"+avg);
	
    
   // 1. 배열선언과 크기 할당! (그릇준비)
    int arraylang[] = new int[5];
   // int arraylang[]앞부분은 아직 값이 입력되지 않은 빈공간(0) 
   // = new int[5]; []값을 입력하면서 메모리에 주소값이 생성 하지만 내용물은 없는 상태
    
   // int arraylang[];          한번에 잡아도 되고 나누어서 선언해도됨
   // arraylang = new int[5];
    
   // * int arraylang[] = null; 전체값을 0으로 만들어줌(초기화)
    
    System.out.println("arraylang:" + arraylang);
    System.out.println("arraylang[0]:" + arraylang);
  // 출력 -> arraylang:[I@15db9742 -> 8자리 16진수 (32bit) 메모리 저장주소가 나옴
  // 아직 값을 입력하지 않았을 때는 자동으로 값에 0이 들어감 -> arraylang[0]:[I@15db9742

   /* int t;
    System.out.println("t:"+t);//동적할당 참조
         값을 정해주지 않았기 때문에 출력이되지 않음.
      */
    
   // 2. 값 입력! (내용물 채우기)
    arraylang[0] = 90;
    arraylang[1] = 85;
    arraylang[2] = 100;
    arraylang[3] = 95;
    arraylang[4] = 75;
    
   // 3. 출력! 
    System.out.println("arraylang[3]:" + arraylang[3]);
    		
    //배열 초기화
    int arrNum[] = { 90, 100, 85 };  //-> 선언과 동시에 초기화
    System.out.println("arrNum[0]"+arrNum[0]);
    
  /*  char arrChar[] = {'A','B','C'};
    System.out.println("arrChar[1]" +arrChar[1);  */
    
  
     char arrChar[];
    // arrChar = {'A,'B','C'};   -> 두 개로 나누어서 배열선언 불가능 
    // arrChar = new Char[1]; //->동적활동을 거친 후에 가능
   
     
    		 
     
     
     //alias (별명)  ->분신같은 존재 
     int array[] = {11, 22, 33};
     int alias[] = array;
     System.out.println("alias[1]"+alias[1]);
     
     alias[1] =222;
     System.out.println("alias[1]"+ alias[1]);
     System.out.println("array[1]"+ array[1]);
    
     int Atype[] = {1,2,3};
     int Btype[] = {11,22,33};
    int temp;
    
 
	
   /* temp = Atype[0];
    Atype[0] = Btype[0];
    Btype[0] = temp;
    
    temp = Atype[1];
    Atype[1] = Btype[1];
    Btype[1] = temp;
    
    temp = Atype[2];
    Atype[2] = Btype[2];
    Btype[2] = temp;
    System.out.println("Atype[1]"+Atype[1]);
    */
    
    int aliasA[] = Atype;
    int aliasB[] = Btype;
    int aliastemp[];
    
    System.out.println("aliasA[0]"+ aliasA[0]);
    System.out.println("aliasA[1]"+ aliasA[1]);
    System.out.println("aliasA[2]"+ aliasA[2]);
    
    aliastemp = aliasA;   //1번만 바꿔도 되기 때문에 간단해짐
    aliasA = aliasB;
    aliasB = aliastemp;
    
    System.out.println("Atype[0]"+ Atype[0]);
    System.out.println("Atype[1]"+ Atype[1]);
    System.out.println("Atype[2]"+ Atype[2]);
   
    System.out.println("aliasA[0]"+ aliasA[0]);
    System.out.println("aliasA[1]"+ aliasA[1]);
    System.out.println("aliasA[2]"+ aliasA[2]);
	
	}
    
    
	}


