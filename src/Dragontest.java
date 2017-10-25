import java.util.*;

public class Dragontest {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	final int PLAYTIME = 30; //플레이타임
	String name; //플래이어 이름
	int type; //드래곤 속성
	String []time = {"▶아침◀","▶점심◀","▶저녁◀"};
	int []dayplan;
	int food=50;//배부름 지수, max : 100%
	int stress=50;//스트레스 지수, max : 100%
	int health = 30;//체력 능력치
	int knowledge = 50;//지식 능력치
	int anger = 50;//포악함 
	int travel;//첫번째 여행장소 선택
	
	String select = "";
	
	public void opening() { //오프닝 : 김보령
		System.out.println("로딩중입니다...");
		for(int i = 1 ; i<=30 ; i++) {
			this.sleep(200);
			if(i<30) System.out.print("■");
			else System.out.println(" 100%!!\n");
		}
		System.out.print("당신의 이름을 입력해주세요! : ");
		name = scan.next(); 
		this.sleep(1500);
		System.out.println("Made by 3조");
		this.sleep(1500);
		System.out.println("공욱진 정준우 김보령\n");
		this.sleep(2000);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
		 this.sleep(1500);
		 System.out.println("매일매일이 한가한 "+name+"은 여행을 떠나려고 합니다");
		 System.out.println("목적지는 어디로 정할까요?(숫자로 입력해주세요)");
		this.sleep(1000);
		System.out.println("1.눈이 내리고 있는 추운곳");
		System.out.println("2.동굴이 있는 곳");
		System.out.println("3.열대우림");
		travel=scan.nextInt();
		if(travel==1) {
			this.sleep(1500);
			System.out.println("인적이 드물고 눈이 내리는 산속을 걷던 당신은");
			System.out.println("흰색 알을 발견하고 집까지 데려옵니다");
		}
		if(travel==2) {
			this.sleep(1500);
			System.out.println("동굴 깊숙한 곳까지 내려갔던 당신은");
			System.out.println("붉은빛의 알을 발견하고 집으로 데려옵니다");
		}
		if(travel==3) {
			this.sleep(1500);
			System.out.println("열대우림의 깊은 곳까지 탐험하던 당신은");
			System.out.println("검은색의 알을 발견하고 집으로 데려옵니다");
		}
		this.sleep(1500);
		System.out.println("무사히 여행을 마치고 집으로 돌아왔습니다");
		System.out.println("여행에서 발견한 신비한 색의 알과 함께입니다");
		System.out.println("알에서 무엇이 나올지, 부화시킬 수 있을지도 모르지만");
		System.out.println("일단 노력 해 보려고 합니다.");
		System.out.println("오늘은 알과 함께하는 1일차입니다.");
		System.out.println("먼저 무엇을 해 볼까요?");
	}
	public void showstatus(){// 상태창 출력
		for(int i=0 ; i<8 ; i++) {
			switch(i) {
			case 0:
				System.out.print("┏━스텟 메뉴━━━━━━━━━━━━━━━━━━━━━━━━┓");
				break;
			case 1:
				System.out.print("┣내 이름  :"+name);
				break;
			case 2:
				System.out.print("┣포만감   :");
				break;
			case 3:
				System.out.print("┣스트레스:");
				break;
			case 4:
				this.sleep(200);
				System.out.print("┣채력      :"+health);
				break;
			case 5:
				this.sleep(200);
				System.out.print("┣지식      :"+knowledge);
				break;
			case 6:
				this.sleep(200);
				System.out.print("┣포악함   :"+anger);
				break;
			case 7:
				System.out.print("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
			}
		
			for(int j=0 ; j<10 ; j++) {
				if(i==2) {
					if(j<(food/10)) { 
						this.sleep(100);
						System.out.print("■");
						}
					else{
						this.sleep(100);
						System.out.print("□");
					}
				} 
				if(i==3) {
					if(j<(stress/10)) {
						this.sleep(100);
						System.out.print("■");
					}
					else { 
						this.sleep(100);
						System.out.print("□");
					}
				}
			}
			System.out.println();
		}
	}	
	
	
	public void showmenu(int i){// 단계별 메뉴출력	
			System.out.println("┣           "+(i+1)+"일 ");			
		if(i<4) {//1단계의 메뉴 출력
			System.out.println("┣━행동 선택━━━━━━━━━━━━━━━━━━━━━━━━┫");
			System.out.println("┣1. 쓰다듬기.  ");
			System.out.println("┣2. 품어주기.  ");
			System.out.println("┣3. 방치하기.  ");
			System.out.println("┣4. 대굴대굴.  ");
			System.out.println("┣━━━━━━                   ━━━━━━┫");	
			
		}
		else if(i>=4&&i<=16) {//2단계의 메뉴 출력
			System.out.println("┣━행동 선택━━━━━━━━━━━━━━━━━━━━━━━━┫");
			System.out.println("┣1. 먹기.  ");
			System.out.println("┣2. 훈련.  ");
			System.out.println("┣3. 휴식.  ");
			System.out.println("┣4. 추가예정  ");
			System.out.println("┣━━━━━━                   ━━━━━━┫");
		}
		else {//3단계의 메뉴출력
			System.out.println("┣━행동 선택━━━━━━━━━━━━━━━━━━━━━━━━┫");
			System.out.println("┣1. 먹기.  ");
			System.out.println("┣2. 훈련.  ");
			System.out.println("┣3. 사냥.  ");
			System.out.println("┣4. 휴식.  ");
			System.out.println("┣━━━━━━                   ━━━━━━┫");
		}
	}
	public void playplan(int i) {//선택지 실행
		if(i<4) {//1단계 선택지실행
			for(int j = 0; j<3 ; j+=2) {//아침 저녁순서대로 선택받음
				this.showmenu(i);
				System.out.print("┣━ "+(i+1)+"일 "+time[j]+" 할일 선택 : ");				
	
				switch(this.selecter()) {
				case 1 : 
					System.out.print("┣정체불명의 알을 사랑을 가득담아 쓰다듬었습니다.\n");
					anger-=5;
					break;
				case 2 : 
					System.out.print("┣정체불명의 알을 따뜻하게 품었습니다.\n");
					anger-=5;
					break;
				case 3 : 
					System.out.print("┣정체불명의 알을 무관심하게 방치해두었습니다.\n");
					anger+=5;
					break;
				case 4 : 
					System.out.print("┣볼링공으로 재격입니다.\n");
					anger+=5;
					break;
				default :
					System.out.println("┣잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
					j-=2;
				}
			}
		}
		else if(i>=4&&i<=16) {//2단계 1차메뉴를 출력하고 플레이어에게 2차메뉴로 가는 선택을 받음
			for(int j = 0; j<3 ; j++) {//아침 점심 저녁순서대로 선택받음
				this.showmenu(i);//2단계 1차 메뉴 출력
				System.out.print("┣━"+(i+1)+"일 "+time[j]+" 할일 선택 : ");
				
				switch(this.selecter()) {//2단계 2차메뉴 선택
				case 1 : 
					this.eat();
					this.event();
					break;
				case 2 : 
					this.practice();
					this.event();
					break;
				case 3 : 
					this.relax();
					this.event();
					break;
				default :
					System.out.println("┣잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
					j--;
				}
			}
		}
		else {//3단계 선택지 실행
			for(int j = 0; j<3 ; j++) {
				this.showmenu(i);
				System.out.print("┣"+(i+1)+"일 "+time[j]+" 할일 선택 : ");
				
				switch(this.selecter()) {
				case 1 : 
					this.eat();
					this.event();
					break;
				case 2 : 
					this.practice();
					this.event();
					break;
				case 3 : 
					this.hunting();
					this.event();
					break;
				case 4 : 
					this.relax();
					this.event();
					break;
				default :
					System.out.println("┣잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
					j--;
				}
			}
		}
	}
	public void eat() {//먹는 메소드 : 공욱진
		System.out.println("┣━음식 메뉴 선택━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┣━① 소고기.  ");
		System.out.println("┣━② 양고기.  ");
		System.out.println("┣━③ 채식.  ");
		System.out.println("┣━④ 스파게티.  ");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("┣메뉴 선택 : ");
		
		for(int k=0; k<1 ; k++) {
			switch(this.selecter()) {
			case 1 :
				System.out.println("┣소고기!");
				break;
			case 2 :
				System.out.println("┣양고기!");
				break;
			case 3 :
				System.out.println("┣채식!");
				break;
			case 4 :
				System.out.println("┣스파게티!");
				break;
			default :
				System.out.println("┣잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
				k--;
			}
		}
		System.out.println("┃");
	}
	
	public void relax() {//노는 메소드
		System.out.println("┣━놀이 메뉴 선택━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┣━① 축구.  ");
		System.out.println("┣━② 수영.  ");
		System.out.println("┣━③ 놀이동산.  ");
		System.out.println("┣━④ 빈둥빈둥.  ");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("┣메뉴 선택 : ");
		
		for(int k=0; k<1 ; k++) {
		switch(this.selecter()) {
		case 1 :
			System.out.println("┣축구!");//이부분에 놀이에 맞는 스텟증감값을 조정
			break;
		case 2 :
			System.out.println("┣수영!");//이부분에 놀이에 맞는 스텟증감값을 조정
			break;
		case 3 :
			System.out.println("┣놀이동산!");//이부분에 놀이에 맞는 스텟증감값을 조정
			break;
		case 4 :
			System.out.println("┣빈둥빈둥!");//이부분에 놀이에 맞는 스텟증감값을 조정
			break;
		default :
			System.out.println("┣잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
			k--;
			}
		}
		System.out.println("┃");
	}
	
	
	
	public void practice() {//훈련 메소드
		System.out.println("┣━훈련 메뉴 선택━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┣━① 훈련1.  ");
		System.out.println("┣━② 훈련2.  ");
		System.out.println("┣━③ 훈련3.  ");
		System.out.println("┣━④ 훈련4.  ");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("┣메뉴 선택 : ");
		for(int k=0; k<1 ; k++) {
			switch(this.selecter()) {
			case 1 :
				System.out.println("┣훈련1");//이부분에 훈련에 맞는 스텟증감값을 조정
				break;
			case 2 :
				System.out.println("┣훈련2");//이부분에 훈련에 맞는 스텟증감값을 조정
				break;
			case 3 :
				System.out.println("┣훈련3");//이부분에 훈련에 맞는 스텟증감값을 조정
				break;
			case 4 :
				System.out.println("┣훈련4");//이부분에 훈련에 맞는 스텟증감값을 조정
				break;
			default :
				System.out.println("┣잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
				k--;
			}
		
		}
		System.out.println("┃");
	}
	
	public void hunting() {//사냥 메소드
		System.out.println("┣━사냥 메뉴 선택━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┣━① 사냥1.  ");
		System.out.println("┣━② 사냥2.  ");
		System.out.println("┣━③ 사냥3.  ");
		System.out.println("┣━④ 사냥4.  ");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("┣메뉴 선택 : ");
		
		for(int k=0; k<1 ; k++) {
			switch(this.selecter()) {
			case 1 :
				System.out.println("┣사냥1");//이부분에 사냥에 맞는 스텟증감값을 조정
				break;
			case 2 :
				System.out.println("┣사냥!2");//이부분에 사냥에 맞는 스텟증감값을 조정
				break;
			case 3 :
				System.out.println("┣사냥3");//이부분에 사냥에 맞는 스텟증감값을 조정
				break;
			case 4 :
				System.out.println("┣샤냥4!");//이부분에 사냥에 맞는 스텟증감값을 조정
				break;
			default :
				System.out.println("┣잘못된 값을 입력하셨습니다. 번호만 입력해주세요");
				k--;
			}
		}
		System.out.println("┃");
	}
	public void event() {//특별한 일 발생, 10%의 확률
		int a = rand.nextInt(10);//0~9까지의 난수 생성, 총 10개의 숫자
		if(a==1) {//그중 1이라는 숫자가 나올때만 이벤트 실행 , 10%의 확륭로 이벤트가 발생한다
			switch(a=rand.nextInt(4)+1){//1~4까지의 난수 생성 
			case 1 :
				System.out.println("┣-----1번 이벤트 발생!!!!-----");
				break;
			case 2 :
				System.out.println("┣-----2번 이벤트 발생!!!!-----");
				break;
			case 3 :
				System.out.println("┣-----3번 이벤트 발생!!!!-----");
				break;
			case 4 :
				System.out.println("┣-----4번 이벤트 발생!!!!-----");
				break;
			}
		}
	}
	
	public void turnend() {//턴마다 증감값 반영
		
	}
	
	//이부분 부터는 추가기능 부분
	public void sleep(int time){//(time)m/s 만큼 대기
	    try {
	      Thread.sleep(time);
	    } catch (InterruptedException e) { }
	}
	
	public int selecter() { // 선택을 받는 메소드, 선택지 번호와 다른 숫자,문자,문자열을 받으면 
		select = scan.next();// 오류가 나는것을 방지하고 선택값을 초기화 시켜주고 return
		try {
			int a=Integer.parseInt(select);
		}catch(NumberFormatException e) {select = "999";}
		return Integer.parseInt(select);
	}
}
