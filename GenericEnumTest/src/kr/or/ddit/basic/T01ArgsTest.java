package kr.or.ddit.basic;

public class T01ArgsTest {

/*
 가변형 인수 => 메서드 매개변수의 개수가 실행될 때마다 다를 때 사용함
 - 가변형 인수는 메서드 안에서는 배열로 처리
 - 가변현 인수는 한 가지 자료형만 사용 가능
*/
	//int값 여러개 처리
	public int sumArr(int[] data) {
		
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	//가변형 인수 문법 - 원하는 개수만큼 넣어도 됨 : 정해진 거 없을 떄(가변적)
	//호출 편리
	public int sumArgs(int... data) {
		
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		T01ArgsTest arg = new T01ArgsTest();
		int sum = arg.sumArgs(1, 2, 3, 5, 6, 8);
		System.out.println(sum);
		
	}
	
}
