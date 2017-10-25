
/**
 * 3조 첫 번째 조별과제 프로그램(class name : Dragonclass.java)
 * 프로그램명 : 드래곤키우기
 * Made by 3조
 * 조장 : 정준우 / 조원 : 공욱진, 김보령
 * 과제기간 : 17.9.11 ~ 17.10.22
 * version. 0.01 
 */

import java.util.*;
					
public class Dragonclass {
	Scanner scan = new Scanner(System.in);//스케너 클레스
	Random rand = new Random();//렌덤 클레스
	
	DragonPicture pc = new DragonPicture();//도트이미지클레스 객체 생성 
	DragonMiniGame game = new DragonMiniGame();//미니게임클레스 객체 생성 
	DragonAddon addon = new DragonAddon();//추가기능클레스 객체 생성 
	
	int PLAYTIME = 20; // 플레이타임
	int EGGTIME = 2; // 에그타임
	
	String name; // 플래이어 이름
	String dname; //드레곤 이름
	int type; // 드래곤 속성, (1,2,3)
	String[] time = { "「아침」", "「점심」", "「저녁」" };//타임 문자열
	int food = 50;// 배부름 지수, 초기값 : 50%, max : 100%
	int stress = 50;// 스트레스 지수, 초기값 : 50%, max : 100%
	int health;// 체력 능력치
	int knowledge;// 지식 능력치
	int anger;// 포악함 능력치
	
	int turnOff = 0;//게임종료 변수
	
	public void playgame() {// 로딩화면, 메인화면, 다른 메소드를 활용하여 게임이 시작되는 부분
		
		System.out.println("로딩중입니다...");//로딩화면 출력하는 시작부분
		for (int i = 1; i <= 30; i++) {//로딩바 출력, 0.2초마다 29개의 ■를 출력 후 마지막에 100% 라는 문자열 출력한 후 줄바꿈
			addon.sleep(200);
			if (i < 30)
				System.out.print("■");
			else
				System.out.println(" 100%!!\n");
		}
		
		addon.sleep(1500);
		System.out.println("　Made by 3조");
		addon.sleep(1500);
		System.out.println("　공욱진 정준우 김보령\n");
		addon.sleep(2000);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
		
		do {// 게임 메인화면 출력하는 do-while문 의 시작부분
			System.out.println();//
			System.out.println();//
			addon.sleep(2000);
			pc.logo();//Dragonpicture에 있는 logo를 호출하여 출력,
			System.out.println("　1. 게임시작");// 매뉴출력
			System.out.println("　2. 플레이 타임 설정");
			System.out.println("　3. 게임 종료");
			System.out.println("선택하십시오 : ");//메뉴 선택
			switch(addon.selecter()) {//추가기능 클래스에 있는 selecter()메소드를 호출, 선택지름 유저에게 숫자문자열로 입력받아 int형 정수로 변환하여 return 하는 메소드, 사용자가 문자열을 입력하는 예외적인 상황을 처리해줌
			case 1: //게임시작부, 1번을 선택했을때
				System.out.println();
				System.out.println();
				opening();
				for(int i = 0; i<PLAYTIME ; i++){//플레이타임
					playplan(i);//이부분에서 오늘 날짜, 상태창 출력
					
					if(turnOff == 1) break;
				}		
					ending();	//이부분에서 엔딩출력
					System.out.println("--끝--");
					addon.sleep(3000);
					
					break;
			case 2://플레이타임 설정부, 2번을 선택했을때
				System.out.println("　1. 긴 플레이 타임");//선택지 메뉴 출력
				System.out.println("　2. 중간 플레이 타임");
				System.out.println("　3. 짧은 플레이타임");
				System.out.println("선택하십시오 : ");
					switch(addon.selecter()) {//유저에게 선택을 입력받아 선택에 따른 PLAYTIME, EGGTIME 변수를 선택지에 맞게 대입
					case 1:
						PLAYTIME=30;
						EGGTIME=4;
						System.out.print("　설정중 입니다");
						addon.loadingbar();//추가기능클래스에서 로딩바메소드 호출
						break;
					case 2:
						PLAYTIME=20;
						EGGTIME=4;
						System.out.print("　설정중 입니다");
						addon.loadingbar();//추가기능클래스에서 로딩바메소드 호출
						break;
					case 3:
						PLAYTIME=10;
						EGGTIME=2;
						System.out.print("　설정중 입니다");
						addon.loadingbar();//추가기능클래스에서 로딩바메소드 호출
						break;
					default ://예외가 발생한 상황에서 실행되는 부분, selecter메소드는 기본적으로 숫자문자열로 입력받고 인트형 숫자로 반환하는데, 사용자가 문자열을 입력하여 인트형 변환이 불가능한 경우를 처리
						System.out.println("잘못된 값을 입력하셨습니다. 초기화면으로 돌아갑니다.");
					}
				break;
			case 3:
				System.out.println("　플레이 해주셔서 감사합니다.");
				turnOff=1;
				break;
			default :
				System.out.println("잘못된 값을 입력하셨습니다. 초기화면으로 돌아갑니다.");
			}
		}while(turnOff!=1);
	}
	
	
	public void opening() { // 오프닝 : 스토리 출력, 사용자 이름, 드레곤 이름 설정, playplan메소드에서 실행됨
		System.out.print("　당신의 이름을 입력해주세요! : ");//사용자 이름 입력받기
		name = scan.next();
		addon.sleep(3000);
		System.out.println("\n　매일매일이 한가한 " + name + "은 여행을 떠나려고 합니다");
		addon.sleep(1500);
		System.out.println("　목적지는 어디로 정할까요?(숫자로 입력해주세요)");
		addon.sleep(1000);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("　1.눈이　내리고 있는 추운곳");
		System.out.println("　2.동굴이 있는 곳");
		System.out.println("　3.열대우림");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		for(int i=0 ; i<1 ; i++)//1번만 실행되는 반복문 이지만 1,2,3 이외의 선택지를 입력했을때 i--를 해주어 정상적인 값이 입력될 때 까지 루핑 하는 구조
		switch(addon.selecter()) {
		case 1 :
			addon.sleep(2000);
			System.out.println("　인적이 드물고 눈이 내리는 산속을 걷던 당신은");
			addon.sleep(1500);
			System.out.println("　흰색 알을 발견하고 집까지 데려옵니다");
			health = 70;
			knowledge = 10;
			anger = 40;
			type=1;
			break;
		case 2:
			addon.sleep(2000);
			System.out.println("　동굴 깊숙한 곳까지 내려갔던 당신은");
			addon.sleep(1500);
			System.out.println("　붉은빛의 알을 발견하고 집으로 데려옵니다");
			health = 70;
			knowledge = 30;
			anger = 20;
			type=2;
			break;
		case 3:
			addon.sleep(2000);
			System.out.println("　열대우림의 깊은 곳까지 탐험하던 당신은");
			addon.sleep(1500);
			System.out.println("　검은색의 알을 발견하고 집으로 데려옵니다");
			health = 70;
			knowledge = 20;
			anger = 30;
			type=3;
			break;
		default ://비정상적인 입력을 받았을 때 분기
			System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
			i--;		
		}
		addon.sleep(1000);
		System.out.println("이 이상한 알의 이름을 정해주세요 : ");
		dname = scan.next();
		addon.sleep(1500);
		System.out.println("　무사히 여행을 마치고 집으로 돌아왔습니다");
		addon.sleep(1500);
		System.out.println("　여행에서 발견한 신비한 색의 알과 함께입니다");
		addon.sleep(1500);
		System.out.println("　알에서 무엇이 나올지, 부화시킬 수 있을지도 모르지만");
		addon.sleep(1500);
		System.out.println("　일단 노력 해 보려고 합니다.");
		addon.sleep(1500);
		System.out.println("　오늘은 알과 함께하는 1일차입니다.");
		addon.sleep(1500);
		System.out.println("　먼저 무엇을 해 볼까요?\n\n\n");
	}

	public void showstatus() {// 상태창 출력, showmenu메소드 에서 실행
		for (int i = 0; i < 8; i++) {//이중 for문 구조, 총 8줄의 문장이 출력된다.
			switch (i) { // case i 에 있는 문장출력
			case 0:
				System.out.print("┏━스텟　메뉴━━━━━━━━━━━━━━━━━━━━━━━━┓");
				break;
			case 1:
				System.out.print("　이　름　:　" + dname);
				break;
			case 2:
				System.out.print("　포만감　:　");
				break;
			case 3:
				System.out.print("　스트레스:　");
				break;
			case 4:
				System.out.print("　채　력　:　" +health);
				break;
			case 5:
				System.out.print("　지　식　:　" +knowledge);
				break;
			case 6:
				System.out.print("　포악함　:　"+anger);
				break;
			case 7:
				System.out.print("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			}

			for (int j = 0; j < 10; j++) {//포만감과 스트레스를 sleep메소드를 활용하여 퍼센트로 시각적으로 출력하기위해 사용하는 안쪽 for문
				if (i == 2) {// case 2에서 실행
					if (j < (food / 10)) {//food를 10으로 나눈 값은 0~10 사이의 값으로 형성, j가 나눈 값보다 작을때 10%를 의미하는 '■'를 출력하고, 
						addon.sleep(100);
						System.out.print("■");
					} else {//아닌 경우는 '□' 출력
						addon.sleep(100);
						System.out.print("□");
					}
				}
				if (i == 3) {//case 3 에서 실행
					if (j < (stress / 10)) {//바로 위의 형식과 같음
						addon.sleep(100);
						System.out.print("■");
					} else {
						addon.sleep(100);
						System.out.print("□");
					}
				}
			}
			System.out.println();
		}
	}

	public void showmenu(int i) {// 단계별 메뉴출력, playplan메소드에서 실행
		if (i<EGGTIME) {// 1단계의 메뉴 출력, 알 때의 경우, if문 안의 조건은 사용자가 설정한 플레이타임과 에그타임에 따라서  단계별 플래이타임이 조정될 수 있도록 만드는 수식
			//예를 들면 플래이타임은 20일이고 에그타임이 4일이면  1단계 매뉴는 일 수가 4일 지날때 변겅,
			pc.egg();//타입에 맞는 알 출력
			System.out.println("『" + (i + 1) + "일』");//일 수가 변경되는 for문은 i가 0부터 시작하기때문에 출력할 때 1을 더하여 출력
			showstatus();//상태창 출력
			addon.sleep(200);
			System.out.println("┏━행동　선택━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("　1. 쓰다듬기.  ");
			System.out.println("　2. 품어주기.  ");
			System.out.println("　3. 방치하기.  ");
			System.out.println("　4. 대굴대굴.  ");
			System.out.println("┗━━━━━━━━━━　　　　　　　　　　━━━━━━━━━━┛");
			
		} else if (i>=EGGTIME && i<(PLAYTIME+EGGTIME)/2) {// 2단계의 메뉴 출력, if문 안의 조건은 사용자가 설정한 플레이타임과 에그타임에 따라서  단계별 플래이타임이 조정될 수 있도록 만드는 수식
			//2단계 매뉴는 4보다 크거나 같고 12보다 작은 경우, 즉 8일 동안 2단계 메뉴출력
			pc.childDragon(type);//타입에 맞는 어린 드래곤 출력
			System.out.println("『" + (i + 1) + "일』");//일 수가 변경되는 for문은 i가 0부터 시작하기때문에 출력할 때 1을 더하여 출력
			showstatus();//상태창 출력
			addon.sleep(200);
			System.out.println("┏━행동　선택━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("　1. 먹기.  ");
			System.out.println("　2. 훈련.  ");
			System.out.println("　3. 휴식.  ");
			System.out.println("　4. 추가예정  ");
			System.out.println("┗━━━━━━━━━━　　　　　　　　　　━━━━━━━━━━┛");
		} else {// 3단계의 메뉴출력
			//3단계 매뉴는 그 외의 상황, 즉 12일보다 크거나 같고 PLAYTIME보다는 작은 8일동안 3단계 메뉴 출력
			pc.Dragon(type);//어른 드래곤 출력
			System.out.println("『" + (i + 1) + "일』");//일 수가 변경되는 for문은 i가 0부터 시작하기때문에 출력할 때 1을 더하여 출력
			showstatus();//타입에 맞는 상태창 출력
			addon.sleep(200);
			System.out.println("┏━행동　선택━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("　1. 먹기.  ");
			System.out.println("　2. 훈련.  ");
			System.out.println("　3. 사냥.  ");
			System.out.println("　4. 휴식.  ");
			System.out.println("┗━━━━━━━━━━　　　　　　　　　　━━━━━━━━━━┛");
		}
	}

	public void playplan(int i) {// 선택지 실행, 외부 일수를 카운트 하는 for문에서 매개변수 i를 입력받아옴, playgame메소드에서 실행
		if (i<EGGTIME) {// 1단계 선택지실행
			egg(i);
		} 
		else if (i>=EGGTIME && i<(PLAYTIME+EGGTIME)/2) {// 2단계 1차메뉴를 출력하고 플레이어에게 2차메뉴로 가는 선택을 받음
			for (int j = 0; j < 3; j++) {// 아침 점심 저녁순서대로 선택받음
				addon.sleep(1000);
				showmenu(i);// 2단계 1차 메뉴 출력
				System.out.print(time[j]+"의 할일 선택 : ");
				switch (addon.selecter()) {// 2단계 2차메뉴 선택
				case 1:
					eat();
					event();
					turnend();//시간이 지날때마다 증감시켜줘야 되는 값들을h 한번에 처리 
					break;
				case 2:
					practice();
					event();
					turnend();//시간이 지날때마다 증감시켜줘야 되는 값들을h 한번에 처리 
					break;
				case 3:
					relax();
					event();
					turnend();//시간이 지날때마다 증감시켜줘야 되는 값들을h 한번에 처리 
					break;
				default:
					System.out.println("　잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
					j--;
				}
				
			}
			System.out.println("　");
		} else {// 3단계 선택지 실행
			for (int j = 0; j < 3; j++) {
				addon.sleep(1000);
				showmenu(i);
				System.out.print(time[j]+"의 할일 선택 : ");

				addon.sleep(200);
				switch (addon.selecter()) {
				case 1:
					eat();
					event();
					turnend();//시간이 지날때마다 증감시켜줘야 되는 값들을h 한번에 처리 
					break;
				case 2:
					practice();
					event();
					turnend();//시간이 지날때마다 증감시켜줘야 되는 값들을h 한번에 처리 
					break;
				case 3:
					hunting();
					event();
					turnend();//시간이 지날때마다 증감시켜줘야 되는 값들을h 한번에 처리 
					break;
				case 4:
					relax();
					event();
					turnend();//시간이 지날때마다 증감시켜줘야 되는 값들을h 한번에 처리 
					break;
				default:
					System.out.println("　잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
					j--;
				}
			}
		}
		System.out.println("");
	}

	public void egg(int i) {
		for (int j = 0; j < 3; j += 2) {// 아침 저녁순서대로 선택받음
			addon.sleep(1000);
			showmenu(i);
			System.out.print(time[j]+"의 할일 선택 : ");
			switch (addon.selecter()) {
			case 1:
				System.out.print("　정체불명의 알을 사랑을 가득담아 쓰다듬었습니다.\n");
				anger -= 5;
				break;
			case 2:
				System.out.print("　정체불명의 알을 따뜻하게 품었습니다.\n");
				anger -= 5;
				break;
			case 3:
				System.out.print("　정체불명의 알을 무관심하게 방치해두었습니다.\n");
				anger += 5;
				break;
			case 4:
				System.out.print("　볼링공으로 재격입니다.\n");
				anger += 5;
				break;
			default:
				System.out.println("　잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
				j -= 2;
			}
			System.out.println("　");
		
	}
		System.out.println("　");
	}
	public void eat() {// 먹는 메소드 : 공욱진
		addon.sleep(200);
		System.out.println("┏━음식　메뉴　선택━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("　　① 육식.  ");
		System.out.println("　　② 채식.  ");
		System.out.println("　　③ 보양식.  ");
		System.out.println("　　④ 사료.  ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("　메뉴 선택 : ");

		for (int k = 0; k < 1; k++) {
			switch (addon.selecter()) {
			case 1:
				System.out.println("　소고기!");
				food += 30;
				stress -=5;
				break;
			case 2:
				System.out.println("　양고기!");
				food += 25;
				stress -=5;
				break;
			case 3:
				System.out.println("　채식!");
				food += 20;
				stress -=5;
				break;
			case 4:
				System.out.println("　스파게티!");
				food += 25;
				stress -=5;
				break;
			default:
				System.out.println("　잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
				k--;
			}
		}
		System.out.println("");
	}

	public void relax() {// 노는 메소드
		addon.sleep(200);
		System.out.println("┏━놀이　메뉴　선택━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("　　① 축구.  ");
		System.out.println("　　② 수영.  ");
		System.out.println("　　③ 놀이동산.  ");
		System.out.println("　　④ 빈둥빈둥.  ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("　메뉴 선택 : ");

		for (int k = 0; k < 1; k++) {
			switch (addon.selecter()) {
			case 1:
				System.out.println("　축구를 즐겁게 했습니다.(채력 대량 상승!)");// 이부분에 놀이에 맞는 스텟증감값을 조정
				health+=20;
				stress-=5;
				food-=20;
				break;
			case 2:
				System.out.println("　수영!(채력 대량 상승!)");// 이부분에 놀이에 맞는 스텟증감값을 조정
				health+=20;
				stress-=5;
				food-=20;
				break;
			case 3:
				System.out.println("　놀이동산!(체력 소량 상승!) ");// 이부분에 놀이에 맞는 스텟증감값을 조정
				health+=5;
				stress-=10;
				food-=30;
				break;
			case 4:
				System.out.println("　빈둥빈둥!(스트레스 대량 감소!)");// 이부분에 놀이에 맞는 스텟증감값을 조정
				stress-=10;
				food-=10;
				break;
			default:
				System.out.println("　잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
				k--;
			}
		}
		System.out.println("");
	}

	public void practice() {// 훈련 메소드
		addon.sleep(200);
		System.out.println("┏━훈련　메뉴　선택━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("　　① 길들이기  ");
		System.out.println("　　② 산책시키기  ");
		System.out.println("　　③ 비행 훈련  ");
		System.out.println("　　④ 사냥 훈련  ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("　메뉴 선택 : ");
		for (int k = 0; k < 1; k++) {
			switch (addon.selecter()) {
			case 1:
				System.out.println("　길들이기(채력 대량 상승!)");// 이부분에 훈련에 맞는 스텟증감값을 조정
				health+=40;
				knowledge+=10;
				stress+=20;
				anger-=5;
				break;
			case 2:
				System.out.println("　산책시키기(지식 대량 상승!)");// 이부분에 훈련에 맞는 스텟증감값을 조정
				health+=10;
				knowledge+=40;
				stress+=20;
				anger-=5;
				break;
			case 3:
				System.out.println("　비행 훈련(채력 지식 상승!)");// 이부분에 훈련에 맞는 스텟증감값을 조정
				health+=20;
				knowledge+=30;
				stress+=20;
				anger+=5;
				break;
			case 4:
				System.out.println("　사냥 훈련(채력 지식 상승!)");// 이부분에 훈련에 맞는 스텟증감값을 조정
				health+=30;
				knowledge+=20;
				stress+=20;
				anger+=5;
				break;
			default:
				System.out.println("　잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
				k--;// k를 1 빼주면서 1번만 도는 루프를 한번더 돌게 하기 위함
			}

		}
		System.out.println("　");
	}

	public void hunting() {// 사냥 메소드
		addon.sleep(200);
		System.out.println("┏━사냥　메뉴　선택━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("　　① 크림슨 발록 사냥  ");
		System.out.println("　　② 자쿰 사냥  ");
		System.out.println("　　③ 혼테일 사냥  ");
		System.out.println("　　④ 킹슬라임 사냥  ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("┣메뉴 선택 : ");

		for (int k = 0; k < 1; k++) {
			switch (addon.selecter()) {
			case 1:
				System.out.println("　"+dname+"이 크림슨 발록을 잡았습니다!!!");// 이부분에 사냥에 맞는 스텟증감값을 조정
				health+=40;
				knowledge+=20;
				stress+=15;
				anger+=5;
				break;
			case 2:
				System.out.println("　"+dname+"이 자쿰을 잡았습니다!!!");// 이부분에 사냥에 맞는 스텟증감값을 조정
				health+=20;
				knowledge+=40;
				stress+=15;
				anger+=5;
				break;
			case 3:
				System.out.println("　"+dname+"이 혼테일을 잡았습니다!!!");// 이부분에 사냥에 맞는 스텟증감값을 조정
				health+=40;
				knowledge+=40;
				stress+=20;
				anger+=5;
				break;
			case 4:
				System.out.println("　"+dname+"이 킹슬라임을 잡았습니다!!!");// 이부분에 사냥에 맞는 스텟증감값을 조정
				health+=50;
				knowledge+=10;
				stress+=15;
				anger+=5;
				break;
			default:
				System.out.println("　잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
				k--;
			}
		}
		System.out.println("　");
	}

	public void event() {// 매 선택마다 이벤트 발생, 20%의 확률
		int a = rand.nextInt(5);// 0~5까지의 난수 생성, 총 5개의 숫자
		if (a == 1) {// 그중 1이라는 숫자가 나올때만 이벤트 실행 , 20%의 확륭로 이벤트가 발생한다
			switch (a = rand.nextInt(4) + 1) {// 1~4까지의 난수 생성 25%의 확률로 분기
			case 1:
				System.out.println("　미니게임 1");
				game.bitGame();//정준우
				break;
			case 2:
				System.out.println("　미니게임 2");
				game.rockScissorPaperGame();//김보령
				break;
			case 3:
				System.out.println("　미니게임 3");
				game.numberMatchingGame();//공욱진
				break;
			}
		}
	}

	public void turnend() {// 턴마다 증감값 반영
			food-=5;//턴마다 포만감 5감소
			if(food>=90) {//포만감이 90이상이 되면 실행
				addon.sleep(2000);
				System.out.println("※드래곤이 폭식으로 힘들어 합니다!!. 능력치가 대량 감소합니다!!※");
				addon.sleep(2000);
				
				knowledge -=rand.nextInt(10)+10;//10~19사이의 숫자생성, 스트레스가 체력 능력치 랜덤하게 감소
				health -=rand.nextInt(10)+10;//10~19사이의 숫자생성, 스트레스가 높으면 지식 랜덤하게 감소
				anger +=rand.nextInt(5)+5;//5~10까지의 난수생성, 스트레스가 높으면 포악함 랜덤하게 증가.
				
				if(food>=100)food=100;// 100이 넘으면 100으로 초기화
			} 
			
			if(food<=15) {//포만감이 15이하가 되면 실행
				addon.sleep(2000);
				System.out.println("※드래곤이 굶주림으로 힘들어 합니다!!. 능력치가 대량 감소합니다!!※");
				addon.sleep(2000);
				
				knowledge -=rand.nextInt(10)+10;//10~19사이의 숫자생성, 스트레스가 체력 능력치 랜덤하게 감소
				health -=rand.nextInt(10)+10;//10~19사이의 숫자생성, 스트레스가 높으면 지식 랜덤하게 감소
				anger +=rand.nextInt(5)+5;//5~10까지의 난수생성, 스트레스가 높으면 포악함 랜덤하게 증가.
				
				if(food<=0)food=0;
				}
			
			if(stress>80&&stress<=90) {//스트레스가 80~90까지가 되면 능력치 감소 
				addon.sleep(2000);
				System.out.println("※드래곤의 스트레스로 너무 힘들어 합니다!!. 하루마다 지식과 체력이 대량 감소합니다!!※");
				addon.sleep(2000);
				
				knowledge -=rand.nextInt(10)+10;//10~19사이의 숫자생성, 스트레스가 체력 능력치 랜덤하게 감소
				health -=rand.nextInt(10)+10;//10~19사이의 숫자생성, 스트레스가 높으면 지식 랜덤하게 감소
				anger +=rand.nextInt(5)+5;//5~10까지의 난수생성, 스트레스가 높으면 포악함 랜덤하게 증가.
			}
			if (stress>=100) {//스트레스가 100이 되면 게임 종료
				turnOff = 1;
			}		
	}
	
	public void ending() {
		//이부분에 엔딩 스토리,분기
		if(turnOff==1) {
			System.out.println("당신의 드래곤은 스트래스때문에 당신의 떠났습니다");
		}
		else if(anger>70) {//엔딩분기 포악함에 따라 주인을 떠날지 말지 정함
			System.out.println("포악한 드래곤은 당신을 잡아먹고 집을 떠났습니다.");
			if(health<knowledge) {//스텟값에 따라 어떤 드래곤이 된지 정함
				System.out.println("집을 떠난 드래곤은 그동안 갈고닦은 지식으로 세상을 파괴했습니다.");				
			}
			else if(health>=knowledge) {//스텟값에 따라 어떤 드래곤이 된지 정함
				System.out.println("집을 떠난 드래곤은 그동안 강력한 힘으로 세상을 파괴했습니다.");
			}
		}
		else {//엔딩 분기 포악함에따라 주인을 떠날지 말지 정함
			System.out.println("온순한 드래곤은 어른이 되었지만 집을 떠나지 않고 당신의 곁을 지키기로 했습니다.");
			if(health<knowledge) {//스텟값에 따라 어떤 드래곤이 된지 정함
				System.out.println("당신의 곁을 지키는 드래곤은 높은 지능으로 마을의 문제를 해결해주는 현자가 되었습니다.");				
			}
			else if(health>=knowledge) {//스텟값에 따라 어떤 드래곤이 된지 정함
				System.out.println("당신의 곁을 지키는 드래곤은 강력한 힘으로 마을을 지키는 수호자가 되었습니다.");
			}
		}
		System.out.println("");
	}
	
}
