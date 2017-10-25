/**
 * 3�� ù ��° �������� ���α׷�(class name : DragonMiniGame.java)
 * ���α׷��� : �巡��Ű���
 * Made by 3��
 * ���� : ���ؿ� / ���� : ������, �躸��
 * �����Ⱓ : 17.9.11 ~ 17.10.22
 * version. 0.01 
 */
import java.util.Random;
import java.util.Scanner;
public class DragonMiniGame {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	DragonAddon addon1 = new DragonAddon();
	
	public class bitGameClass{//���ؿ찡 ����
		int[]arr1 = randArray();//1��° �׸��� ��� �迭,randArray �޼ҵ� Ȱ��
		int[]arr2 = randArray();//2���� �׸��� ��� �迭,randArray �޼ҵ� Ȱ��
		
		int[]answer = new int[5];//���� ��Ʈ�� �迭�� ��Ƶδ� ����
		String[]answerString = new String [5];//���� 2���� ���ڿ� �迭�� ��Ƶδ� ����
		
		int[]uAnswer = new int[5];//������� ���� ��Ʈ�� �迭�� ��Ƶδ� ����
		String[]uAnswerString = new String[5];//������� ���� 2���� ���ڿ� �迭�� ��Ƶδ� ����
		
		public int[] randArray() {//1~32���� ������ ���ڸ� �迭�� ����ִ� �żҵ�
			int[] b=new int[5];
			for(int i = 0 ; i<b.length ; i++) {
				b[i] = rand.nextInt(31)+1;
			} 
			return b;
		}
		
		
		public void makeAnswer(){//���� ����, ��Ʈ������'|'���
			for(int i = 0; i<5 ; i++) {
				this.answer[i]=this.arr1[i]|this.arr2[i];
			}
		}
		
		public void printArr(int[]a, int[]b) {//�׸� ���
			for(int i = 0; i<5 ; i++) {
				for(int j = 4; j>=0; j--) {
					if((a[i]>>j&1)==1) {
						System.out.print("��");
					}
					else {
						System.out.print("��");
					}
				}
				System.out.print("��"+Integer.toHexString(a[i])+"(16)������");
				if(a[i]<10) System.out.print("��");
				for(int j = 4; j>=0; j--) {
					if((b[i]>>j&1)==1) {
						System.out.print("��");
					}
					else {
						System.out.print("��");
					}
				}
				System.out.println("��"+Integer.toHexString(b[i])+"(16)");
			}
			
		}
		
		
		public String[] binaryToString(int []a) {//���ڿ��� �ٲ�, ��� �����ֱ� ����
			String[]b = new String[5];
			for(int i = 0; i<5 ; i++) {
				b[i]=Integer.toBinaryString(a[i]);
				while((b[i].length()%5)!=0) {
					b[i] = "0"+b[i];
				}
			}
			return b;
		}
		
		
		
		public void inputAnswer() {//����ڰ� 0~4��° ��ȣ �ӷ�
			for(int i = 0 ; i<5 ; i++) {
				System.out.println((i+1)+"��° ��ȣ : ");
				this.uAnswer[i] = scan.nextInt();
			}
		}
		
		public boolean equalAnswer() {//���� �´��� ��
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
		System.out.println("��Ʈ : 5��Ʈ�� 2����, �� ����  : ");
		
		bt.inputAnswer();
		bt.uAnswerString=bt.binaryToString(bt.uAnswer);
		
		if(bt.equalAnswer()) {
			System.out.println("�����Դϴ�.");
		}
		else{
			System.out.println("Ʋ�Ƚ��ϴ�.");
		}
		System.out.println("������ : ");
		for(int i = 0; i<5 ; i++) {
			System.out.println(bt.answer[i]);
		}
	}
	
	public void rockScissorPaperGame() {//�躸���� ����
		int user, uWin = 0, cWin = 0, result;
		while (true) {
			System.out.print("(1:����/2:����/3:��)������Է� : ");
			String number = scan.next();
			user = Integer.parseInt(number);
			if (user == 1) {
				System.out.print("��� : ����");
			} else if (user == 2) {
				System.out.print("��� : ����");
			} else {
				System.out.print("��� : ��");
			}

			System.out.println();


			int comp = rand.nextInt(3)+1;//1~3���ڻ����� ���� ���� ����
			if (comp == 1) {
				System.out.print("���� : ����  ");
			} else if (comp == 2) {
				System.out.print("���� : ����  ");
			} else {
				System.out.print("���� : ��  ");
			}

			System.out.println();


			result = user-comp;

			if (result >= 1) {
				System.out.println("����� �¸��Դϴ�");
				uWin += 1;
			} else if (result == 0) {
				System.out.println("�����ϴ�");
			} else {
				System.out.println("������ �¸��Դϴ�");
				cWin -= 1;
			}

			System.out.println();

			//���� 2���� �̱�� ����
			if (uWin == 2) {
				System.out.print("�����  ���� �¸��Դϴ�");
				break;
			} else if (cWin == 2) {
				System.out.print("������ ���� �¸��Դϴ�");
				break;
			}
		}
	}
	
	public void numberMatchingGame() {//�������� ����
		int rdnumber = rand.nextInt(100)+1;
		int usernumber;
		int i = 0;
		
		System.out.println("1~100 �� �ϳ��� ���ڰ� �������� ������ �����˴ϴ�.\n 7���� ��ȸ�� �ֽ��ϴ�.");
		
		
		do {
			System.out.println("���纸����~");

			while (!scan.hasNextInt()) {	//���ڸ� �Է����� ��� ����ó��
				scan.next();
				System.out.println("���ڸ� �Է��ϼ���..");
			}
			
			usernumber = scan.nextInt();
			
			while (usernumber <= 0 || usernumber > 100) {	//0���� ���� �۰ų� 100���� ũ�ų� �Ҷ� �ٽ��Է¿�û
				System.out.println("�ٽ� �Է����ּ���..");
				
				while (!scan.hasNextInt()) {	//���ڸ� �Է����� ��� ����ó��
					scan.next();
					System.out.println("���ڸ� �Է��ϼ���..");
				}
				
				usernumber = scan.nextInt();
			}
			
				if (usernumber> rdnumber) {	//�Է°��� ���亸�� ���� ���
					System.out.println("���亸�� �Է°��� �����ϴ�.");
				}
				if (usernumber< rdnumber) {	//�Է°��� ���亸�� ���� ���
					System.out.println("���亸�� �Է°��� �����ϴ�.");
				}
				if (usernumber== rdnumber) {	//�������ڿ� ����ڼ��ڰ� ���� ���
					System.out.println("���ϵ帳�ϴ�~");
					break;
				}
				if (i == 6) {	//i���� 6�� �Ǿ��� ���� ���
					System.out.println("�� 5���� ��ȸ�� ���Ұ����ϴ�~");
					break;
				}
				i++;
			}while(true);
	}
}

