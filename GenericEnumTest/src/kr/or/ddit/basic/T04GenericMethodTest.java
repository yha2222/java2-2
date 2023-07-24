package kr.or.ddit.basic;

class Util {
	/*
	   제너릭 메서드? 파라미터 타입과 리턴 타입으로 제너릭 타입 글자를 가지는 메서드
	   선언 방법 : 리턴 타입(R) 앞에 <> 기호를 추가하고 타입 제너릭 타입 글자를 기술한 후 사용
	   ex. <T, R> R(-제너릭  선언) method(T t)
	 */
	public static <K, V> boolean  					// <K, V> => 지금은 모르지만 일단 컴파일 ㄱ, 오타 아님 알려줌
		compare(Pair<K, V> p1, Pair<K, V> p2) {  	//제너릭 메서드 필요
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;			//true + true => return;
	}
}

public class T04GenericMethodTest {
	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");
		
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		
		if(result1) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체 아님.");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("002", "홍길동");
		
		//구체적 타입 생략 가능
		//compare->제너릭 메서드 => Util.<String, String>compare(p3, p4);
		boolean result2 = Util.compare(p3, p4); 
		
		if(result2) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체 아님.");
		}
		
		p1.printKeyValue("키", 180); //p1.<String, Integer>printKeyValue
		
	}
}

class Pair<K, V> {
	
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public <K, V> void printKeyValue(K key, V val) {
		System.out.println(key + " : " + val);
	}
	
}