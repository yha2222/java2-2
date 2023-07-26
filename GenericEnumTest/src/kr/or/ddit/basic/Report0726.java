package kr.or.ddit.basic;

/*
 문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 
(태양계 행성의 반지름을 이용하여 면적구하기)
예) 행성의 반지름(KM):
수성(2439), 
금성(6052), 
지구(6371), 
성(3390), 
목성(69911), 
토성(58232), 
천왕성(25362), 
해왕성(24622)
 */
public class Report0726 {
	
	//public enum 
	
	public static void main(String[] args) {
		
	}
}

/*
 * package enum_;

public class EnumEx {
	
	enum Planet {
		
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 
		목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
		
		private final int radius;
		
		private static final double PI = 3.1415926;
		
		private Planet(int radius) {
			this.radius = radius;
		}
		
		public int getRadius() {	
			return radius;
		}
		
		public double getArea() {
			return 4*PI*radius*radius;
		}
	}
	
	public static void main(String[] args) {
		for (Planet planet : Planet.values()) {
			System.out.println(planet.name() + "의 반지름 : " + planet.getRadius() + "Km\n면적 : " 
							+ planet.getArea() + "Km²");
			System.out.println("----------------------------------------");
		}
	}
	
	
}




 */
