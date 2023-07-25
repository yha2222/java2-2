package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	/*
	 	와일드 카드
	 	와일드 카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의
	 	인수(argument)로서, 변수 선언, 객체 생성 및 메서드 정의할 때 사용
	 	
	 	<? extends T>	=> 와일드 카드의 상한 제한. T와 그 자손들만 가능
	 	<? super T> 	=> 와일드 카드의 하한 제한. T와 그 조상들만 가능
	 	<?> 			=> 허용 가능한 모든 타입 가능
	 */
	
	
	public static void main(String[] args) {
		//generic에서 특정한 타입 지정 위해서
		List<?> list = new ArrayList<String>();
		
		FruitBox<Fruit> fruitBox = new FruitBox<>(); //jdk8 => new FruitBox<Fruit>() - 생략 가능
		FruitBox<Apple> appleBox = new FruitBox<>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		System.out.println(fruitBox.getFruitList());
		
		appleBox.add(new Apple());
		//appleBox.add(new Grape());  //에러 => apple 타입 한정이니까
		appleBox.add(new Apple());
		
		System.out.println(appleBox.getFruitList());
		
		Juicer.makeJuice(fruitBox);
		
		Juicer.makeJuice(appleBox); //에러=> 파라미터로 받는 타입이 아니라서(Fruit/Apple)
	}
}

class Juicer {	
	//generic method
	//extends Fruit => Fruit / extends Fruit한 애들만 올 수 있음 
	//static <T extends Fruit> void makeJuice(FruitBox<T> box) {
	
	//wildcard <?> => 타입 제한 필요(쓰레기 들어올 수도 있으니까) => extends
	//static void makeJuice(FruitBox<? extends Fruit> box) {
	
	//과일이나 과일 하위만 허용
	static void makeJuice(FruitBox<?> box) {
		
		String fruitListStr = "";   //과일 목록
		
		int cnt = 0;
		for(Object f : box.getFruitList()) {
			
			if(cnt == 0) {				
				fruitListStr += f;
			}else {
				fruitListStr += ", "+ f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + " => 쥬스 완성!");
	}
}

class Fruit {
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일 [" + name + "]";
	}
}

class Apple extends Fruit {
	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {
	public Grape() {
		super("포도");
	}
}

//제너릭 클래스
class FruitBox<T extends Fruit> {
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<T>();
	}
	
	//과일 담기
	public void add(T fruit) {
		fruitList.add(fruit);
	}

	public List<T> getFruitList() {
		return fruitList;
	}
}