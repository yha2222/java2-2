package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//

public class Report0724 {
	private Scanner scan;
	Map<String, String> roomReserveList = new HashMap<String, String>();
	
	public static void main(String[] args) {
		new Report0724().lob();
	}
	
	public void lob() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println();
		
		hotel();
	}
	
	public void hotel() {
		scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("메뉴선택 => ");
			
			int lobNum = scan.nextInt();
			
			switch(lobNum) {
			case 1: checkIn();
				break;
			case 2: checkOut();
				break;
			case 3: roomCheck();
				break;
			case 4: 
				System.out.println("**************************\r\n" + 
						"호텔 문을 닫았습니다.\r\n" + 
						"**************************");
				return;
			default :
				System.out.println("잘못된 입력!");
				break;
			}
		}
	}
	
	private void checkIn() {
		scan = new Scanner(System.in);
		
		System.out.println("어느 방에 체크인 하시겠습니까?\r\n" + 
				"방번호 입력 => ");
		String roomNum = scan.next();
		System.out.println("누구를 체크인 하시겠습니까?\r\n" + 
				"이름 입력 => ");
		String name = scan.next();
		
		//keySet()메소드는 뭐냐면 map안에 키랑 밸류쌍이 막 들어있자너?
		//근데 map이름.keySet()의 반환타입은 Set()이야 그냥 키들을 모아서 Set을 만든다음 리턴해주는겨
		//왜Set이냐? 기본적으로 키랑 Set은 거의 동일한 성질임(중복이 불가 등등..)
		if(roomReserveList.get(roomNum) == null) {
			roomReserveList.put(roomNum, name);
			System.out.println("체크인 되었습니다.");
		}else {
			System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
		}
	}
	
	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?\r\n" + 
				"방번호 입력 => ");
		String roomNum = scan.next();
		
		if(roomReserveList.get(roomNum) != null) {			
			roomReserveList.remove(roomNum);
			System.out.println("체크아웃 되었습니다");
		}else {
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
		}
		
	}
	
	private void roomCheck() {
//		Set<String> keySet = roomReserveList.keySet();
//		Iterator<String> it = keySet.iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			System.out.println("방번호 : " + key +", 투숙객 : " + roomReserveList.get(key));
//		}
//		System.out.println();
		
//		for(String key : keySet) {
//			System.out.println("방번호 : " + key +", 투숙객 : " + roomReserveList.get(key));
//		}
		
//		for(String value : roomReserveList.values()) {
//			System.out.println("방번호 : "  +", 투숙객 : " + value);
//		}
		
		//Entry는 Map안에있는 인터페이스인데 왜 Map안에있냐면 Map밖에 Entry를 사용하지 않으니 그냥 Map안에둔거임ㅇㅋ?
		//근데 Entry가뭐냐면 나도 좀 헷갈리긴하긴한데 뭐냐면 그냥 쉽게말하면 키와 밸류를 합쳐놓은거임 ㅇㅋ?
		//근데이제 이 Entry들을 묶어 묶어가지고 Set에 담아놓는게 entrySet() 메소드야 ㅇㅋ? 그니까 Entry들의 집합인 Set을 리턴하는거지
		//
		Set<Map.Entry<String, String>> entrySet = roomReserveList.entrySet();
		Iterator<Map.Entry<String, String>> entryIt = entrySet.iterator();
		while(entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.print("방번호: " + entry.getKey() +", ");
			System.out.println("투숙객: " + entry.getValue());
			System.out.println();
		}
		
	}
}
