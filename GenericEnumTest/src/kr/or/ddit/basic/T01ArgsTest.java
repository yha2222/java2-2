package kr.or.ddit.basic;

public class T01ArgsTest {

/*
 가변형 인수 => 메서드 매개변수의 개수가 실행될 때마다 다를 때 사용함
 - 가변형 인수는 메서드 안에서는 배열로 처리
 - 가변현 인수는 한 가지 자료형만 사용 가능
*/
	/*
	 * 배열을 이용한 메서드
	 */
		
	//int값 여러개 처리
	public int sumArr(int[] data) {
		
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	//가변형 인수를 이용한 메서드
	//가변형 인수 문법 - 원하는 개수만큼 넣어도 됨 : 정해진 거 없을 떄(가변적)
	//호출 편리
	public int sumArgs(int... data) {
		
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	/*
	 * 가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야 함
	 */
	public String sumArgs2(String name, int...data) {
		int sum = 0;
		
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		
		return name +"씨 점수 : " + sum;
	}
	
	public static void main(String[] args) {
		
		T01ArgsTest arg = new T01ArgsTest();
		
		int[] nums = {100,200,300};
		System.out.println(arg.sumArr(nums));
		System.out.println(arg.sumArr(new int[] {1, 2, 3, 4, 5}));
		System.out.println();
		
		System.out.println(arg.sumArgs(100,200,300));
		System.out.println(arg.sumArgs(1,2,3,4,5));
		System.out.println();
		
		System.out.println(arg.sumArgs2("홍길동", 1, 2, 3,4 ,5,6,7,8));
		
	}
	
}
