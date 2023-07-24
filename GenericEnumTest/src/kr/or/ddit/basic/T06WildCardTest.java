package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox = new FruitBox<>(); //jdk8 => new FruitBox<Fruit>() - 생략 가능
		FruitBox<Apple> appleBox = new FruitBox<>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		System.out.println(fruitBox.getFruitList());
		
		appleBox.add(new Apple());
		//appleBox.add(new Grape());  //에러 => apple 타입 한정이니까
		appleBox.add(new Apple());
		
		System.out.println(appleBox.getFruitList());
	}
}

class Juicer {
	
	static void makeJuice(FruitBox<Fruit> box) {
		
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
class FruitBox<T> {
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