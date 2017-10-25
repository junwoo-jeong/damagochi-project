/**
 * 3조 첫 번째 조별과제 프로그램(class name : DragonAddon.java)
 * 프로그램명 : 드래곤키우기
 * Made by 3조
 * 조장 : 정준우 / 조원 : 공욱진, 김보령
 * 과제기간 : 17.9.11 ~ 17.10.22
 * version. 0.01 
 */
import java.util.Scanner;

public class DragonAddon {
	Scanner scan = new Scanner(System.in);
	public void sleep(int time) {// (time)m/s 만큼 대기
		try {
			Thread.sleep(time);//인터럽트예외 발생
		} catch (InterruptedException e) {//예외가 발생했을때 실행할 문장
		}
	}

	public int selecter() { // 선택을 받는 메소드, 선택지 번호와 다른 숫자,문자,문자열을 받으면
		String select = scan.next();// 오류가 나는것을 방지하고 선택값을 초기화 시켜주고 return
		try {
			int a = Integer.parseInt(select);// 문자열 숫자를 정수형 숫자로 바꾸어주는 역할, but 문자나 문자열을 바꿀려고 하면
												// 'NumberFormatException'이라는 오류발생!
		} catch (NumberFormatException e) {select = "999";} // 앞에나온 오류를 예외처리하는 부분, 999라는 의미없는 숫자를 select에 넣어서 초기화 
		// 문자열을 select에 대입 시킴!
		return Integer.parseInt(select);
	}
	
	public void loadingbar() {//로딩바를 만드는 메소드, 5개의 .을 0.4초마다 찍어주고 줄바꿈
		for(int i = 0;i<5;i++) {
			sleep(400);
			System.out.print(".");
		}
		System.out.println();
	}
}
