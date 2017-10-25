/**
 * 3조 첫 번째 조별과제 프로그램(class name : DragonMiniGame.java)
 * 프로그램명 : 드래곤키우기
 * Made by 3조
 * 조장 : 정준우 / 조원 : 공욱진, 김보령
 * 과제기간 : 17.9.11 ~ 17.10.22
 * version. 0.01 
 */
import java.util.Random;
import java.util.Scanner;
public class DragonMiniGame {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	DragonAddon addon1 = new DragonAddon();
	
	public class bitGameClass{//정준우가 만듬
		int[]arr1 = randArray();//1번째 그림을 담는 배열,randArray 메소드 활용
		int[]arr2 = randArray();//2번쨰 그림을 담는 배열,randArray 메소드 활용
		
		int[]answer = new int[5];//답을 인트형 배열로 담아두는 변수
		String[]answerString = new String [5];//답을 2진수 문자열 배열로 담아두는 변수
		
		int[]uAnswer = new int[5];//사용자의 답을 인트형 배열로 담아두는 변수
		String[]uAnswerString = new String[5];//사용자의 답을 2진수 문자열 배열로 담아두는 변수
		
		public int[] randArray() {//1~32까지 랜덤한 숫자를 배열에 담아주는 매소드
			int[] b=new int[5];
			for(int i = 0 ; i<b.length ; i++) {
				b[i] = rand.nextInt(31)+1;
			} 
			return b;
		}
		
		
		public void makeAnswer(){//답을 만듬, 비트연산자'|'사용
			for(int i = 0; i<5 ; i++) {
				this.answer[i]=this.arr1[i]|this.arr2[i];
			}
		}
		
		public void printArr(int[]a, int[]b) {//그림 출력
			for(int i = 0; i<5 ; i++) {
				for(int j = 4; j>=0; j--) {
					if((a[i]>>j&1)==1) {
						System.out.print("■");
					}
					else {
						System.out.print("□");
					}
				}
				System.out.print("　"+Integer.toHexString(a[i])+"(16)　　　");
				if(a[i]<10) System.out.print("　");
				for(int j = 4; j>=0; j--) {
					if((b[i]>>j&1)==1) {
						System.out.print("■");
					}
					else {
						System.out.print("□");
					}
				}
				System.out.println("　"+Integer.toHexString(b[i])+"(16)");
			}
			
		}
		
		
		public String[] binaryToString(int []a) {//문자열로 바꿈, 답과 비교해주기 위함
			String[]b = new String[5];
			for(int i = 0; i<5 ; i++) {
				b[i]=Integer.toBinaryString(a[i]);
				while((b[i].length()%5)!=0) {
					b[i] = "0"+b[i];
				}
			}
			return b;
		}
		
		
		
		public void inputAnswer() {//사용자가 0~4번째 암호 임력
			for(int i = 0 ; i<5 ; i++) {
				System.out.println((i+1)+"번째 암호 : ");
				this.uAnswer[i] = scan.nextInt();
			}
		}
		
		public boolean equalAnswer() {//답이 맞는지 비교
			boolean right = true;	
			for(int i =0 ; i<5 ; i++){
				if(!(this.answerString[i].equals(this.uAnswerString[i]))) right=false; 
			}
				return right;
			}
		}
	
	public void bitGame(){
		bitGameClass bt = new bitGameClass();
		bt .makeAnswer();
		bt.answerString=bt.binaryToString(bt.answer);
		bt.printArr(bt.arr1,bt.arr2);
		System.out.println();
		System.out.println("힌트 : 5비트의 2진수, 합 연산  : ");
		
		bt.inputAnswer();
		bt.uAnswerString=bt.binaryToString(bt.uAnswer);
		
		if(bt.equalAnswer()) {
			System.out.println("정답입니다.");
		}
		else{
			System.out.println("틀렸습니다.");
		}
		System.out.println("정답은 : ");
		for(int i = 0; i<5 ; i++) {
			System.out.println(bt.answer[i]);
		}
	}
	
	public void rockScissorPaperGame() {//김보령이 만듬
		int user, uWin = 0, cWin = 0, result;
		while (true) {
			System.out.print("(1:가위/2:바위/3:보)사용자입력 : ");
			String number = scan.next();
			user = Integer.parseInt(number);
			if (user == 1) {
				System.out.print("당신 : 가위");
			} else if (user == 2) {
				System.out.print("당신 : 바위");
			} else {
				System.out.print("당신 : 보");
			}

			System.out.println();


			int comp = rand.nextInt(3)+1;//1~3숫자사이의 렌덤 숫자 생성
			if (comp == 1) {
				System.out.print("상인 : 가위  ");
			} else if (comp == 2) {
				System.out.print("상인 : 바위  ");
			} else {
				System.out.print("상인 : 보  ");
			}

			System.out.println();


			result = user-comp;

			if (result >= 1) {
				System.out.println("당신의 승리입니다");
				uWin += 1;
			} else if (result == 0) {
				System.out.println("비겼습니다");
			} else {
				System.out.println("상인의 승리입니다");
				cWin -= 1;
			}

			System.out.println();

			//먼저 2판을 이기면 종료
			if (uWin == 2) {
				System.out.print("당신의  최종 승리입니다");
				break;
			} else if (cWin == 2) {
				System.out.print("상인의 최종 승리입니다");
				break;
			}
		}
	}
	
	public void numberMatchingGame() {//공욱진이 만듬
		int rdnumber = rand.nextInt(100)+1;
		int usernumber;
		int i = 0;
		
		System.out.println("1~100 중 하나의 숫자가 랜덤으로 정답이 지정됩니다.\n 7번의 기회가 있습니다.");
		
		
		do {
			System.out.println("맞춰보세요~");

			while (!scan.hasNextInt()) {	//문자를 입력했을 경우 예외처리
				scan.next();
				System.out.println("숫자만 입력하세요..");
			}
			
			usernumber = scan.nextInt();
			
			while (usernumber <= 0 || usernumber > 100) {	//0보다 같고 작거나 100보다 크거나 할때 다시입력요청
				System.out.println("다시 입력해주세요..");
				
				while (!scan.hasNextInt()) {	//문자를 입력했을 경우 예외처리
					scan.next();
					System.out.println("숫자만 입력하세요..");
				}
				
				usernumber = scan.nextInt();
			}
			
				if (usernumber> rdnumber) {	//입력값이 정답보다 높을 경우
					System.out.println("정답보다 입력값이 높습니다.");
				}
				if (usernumber< rdnumber) {	//입력값이 정답보다 낮을 경우
					System.out.println("정답보다 입력값이 낮습니다.");
				}
				if (usernumber== rdnumber) {	//랜덤숫자와 사용자숫자가 같을 경우
					System.out.println("축하드립니다~");
					break;
				}
				if (i == 6) {	//i값이 6이 되었을 때의 경우
					System.out.println("땡 5번의 기회가 날았갔습니다~");
					break;
				}
				i++;
			}while(true);
	}
}

