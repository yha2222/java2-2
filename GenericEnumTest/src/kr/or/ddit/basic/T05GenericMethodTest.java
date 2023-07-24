package kr.or.ddit.basic;

//제한된 타입 파라미터 문법 - 타입 제한 extends
class Util2 {
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
	}
}

public class T05GenericMethodTest {
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util2.compare(3.14, 3);  //Util2.<Number>compare
		System.out.println(result2);
		
		//Util2.compare(3, "Java"); //String => 에러
		
	}
}
