import java.util.*;

public class Dragontest {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	final int PLAYTIME = 30; //�÷���Ÿ��
	String name; //�÷��̾� �̸�
	int type; //�巡�� �Ӽ�
	String []time = {"����ħ��","�����ɢ�","�����ᢸ"};
	int []dayplan;
	int food=50;//��θ� ����, max : 100%
	int stress=50;//��Ʈ���� ����, max : 100%
	int health = 30;//ü�� �ɷ�ġ
	int knowledge = 50;//���� �ɷ�ġ
	int anger = 50;//������ 
	int travel;//ù��° ������� ����
	
	String select = "";
	
	public void opening() { //������ : �躸��
		System.out.println("�ε����Դϴ�...");
		for(int i = 1 ; i<=30 ; i++) {
			this.sleep(200);
			if(i<30) System.out.print("��");
			else System.out.println(" 100%!!\n");
		}
		System.out.print("����� �̸��� �Է����ּ���! : ");
		name = scan.next(); 
		this.sleep(1500);
		System.out.println("Made by 3��");
		this.sleep(1500);
		System.out.println("������ ���ؿ� �躸��\n");
		this.sleep(2000);
		System.out.println("������������������������������������������������������������������������������������������������������������\n");
		 this.sleep(1500);
		 System.out.println("���ϸ����� �Ѱ��� "+name+"�� ������ �������� �մϴ�");
		 System.out.println("�������� ���� ���ұ��?(���ڷ� �Է����ּ���)");
		this.sleep(1000);
		System.out.println("1.���� ������ �ִ� �߿��");
		System.out.println("2.������ �ִ� ��");
		System.out.println("3.����츲");
		travel=scan.nextInt();
		if(travel==1) {
			this.sleep(1500);
			System.out.println("������ �幰�� ���� ������ ����� �ȴ� �����");
			System.out.println("��� ���� �߰��ϰ� ������ �����ɴϴ�");
		}
		if(travel==2) {
			this.sleep(1500);
			System.out.println("���� ����� ������ �������� �����");
			System.out.println("�������� ���� �߰��ϰ� ������ �����ɴϴ�");
		}
		if(travel==3) {
			this.sleep(1500);
			System.out.println("����츲�� ���� ������ Ž���ϴ� �����");
			System.out.println("�������� ���� �߰��ϰ� ������ �����ɴϴ�");
		}
		this.sleep(1500);
		System.out.println("������ ������ ��ġ�� ������ ���ƿԽ��ϴ�");
		System.out.println("���࿡�� �߰��� �ź��� ���� �˰� �Բ��Դϴ�");
		System.out.println("�˿��� ������ ������, ��ȭ��ų �� �������� ������");
		System.out.println("�ϴ� ��� �� ������ �մϴ�.");
		System.out.println("������ �˰� �Բ��ϴ� 1�����Դϴ�.");
		System.out.println("���� ������ �� �����?");
	}
	public void showstatus(){// ����â ���
		for(int i=0 ; i<8 ; i++) {
			switch(i) {
			case 0:
				System.out.print("�������� �޴���������������������������������������������������");
				break;
			case 1:
				System.out.print("���� �̸�  :"+name);
				break;
			case 2:
				System.out.print("��������   :");
				break;
			case 3:
				System.out.print("����Ʈ����:");
				break;
			case 4:
				this.sleep(200);
				System.out.print("��ä��      :"+health);
				break;
			case 5:
				this.sleep(200);
				System.out.print("������      :"+knowledge);
				break;
			case 6:
				this.sleep(200);
				System.out.print("��������   :"+anger);
				break;
			case 7:
				System.out.print("������������������������������������������������������������������");
			}
		
			for(int j=0 ; j<10 ; j++) {
				if(i==2) {
					if(j<(food/10)) { 
						this.sleep(100);
						System.out.print("��");
						}
					else{
						this.sleep(100);
						System.out.print("��");
					}
				} 
				if(i==3) {
					if(j<(stress/10)) {
						this.sleep(100);
						System.out.print("��");
					}
					else { 
						this.sleep(100);
						System.out.print("��");
					}
				}
			}
			System.out.println();
		}
	}	
	
	
	public void showmenu(int i){// �ܰ躰 �޴����	
			System.out.println("��           "+(i+1)+"�� ");			
		if(i<4) {//1�ܰ��� �޴� ���
			System.out.println("�����ൿ ���æ�������������������������������������������������");
			System.out.println("��1. ���ٵ��.  ");
			System.out.println("��2. ǰ���ֱ�.  ");
			System.out.println("��3. ��ġ�ϱ�.  ");
			System.out.println("��4. �뱼�뱼.  ");
			System.out.println("��������������                   ��������������");	
			
		}
		else if(i>=4&&i<=16) {//2�ܰ��� �޴� ���
			System.out.println("�����ൿ ���æ�������������������������������������������������");
			System.out.println("��1. �Ա�.  ");
			System.out.println("��2. �Ʒ�.  ");
			System.out.println("��3. �޽�.  ");
			System.out.println("��4. �߰�����  ");
			System.out.println("��������������                   ��������������");
		}
		else {//3�ܰ��� �޴����
			System.out.println("�����ൿ ���æ�������������������������������������������������");
			System.out.println("��1. �Ա�.  ");
			System.out.println("��2. �Ʒ�.  ");
			System.out.println("��3. ���.  ");
			System.out.println("��4. �޽�.  ");
			System.out.println("��������������                   ��������������");
		}
	}
	public void playplan(int i) {//������ ����
		if(i<4) {//1�ܰ� ����������
			for(int j = 0; j<3 ; j+=2) {//��ħ ���������� ���ù���
				this.showmenu(i);
				System.out.print("���� "+(i+1)+"�� "+time[j]+" ���� ���� : ");				
	
				switch(this.selecter()) {
				case 1 : 
					System.out.print("����ü�Ҹ��� ���� ����� ������ ���ٵ�����ϴ�.\n");
					anger-=5;
					break;
				case 2 : 
					System.out.print("����ü�Ҹ��� ���� �����ϰ� ǰ�����ϴ�.\n");
					anger-=5;
					break;
				case 3 : 
					System.out.print("����ü�Ҹ��� ���� �������ϰ� ��ġ�صξ����ϴ�.\n");
					anger+=5;
					break;
				case 4 : 
					System.out.print("������������ ����Դϴ�.\n");
					anger+=5;
					break;
				default :
					System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
					j-=2;
				}
			}
		}
		else if(i>=4&&i<=16) {//2�ܰ� 1���޴��� ����ϰ� �÷��̾�� 2���޴��� ���� ������ ����
			for(int j = 0; j<3 ; j++) {//��ħ ���� ���������� ���ù���
				this.showmenu(i);//2�ܰ� 1�� �޴� ���
				System.out.print("����"+(i+1)+"�� "+time[j]+" ���� ���� : ");
				
				switch(this.selecter()) {//2�ܰ� 2���޴� ����
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
					System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
					j--;
				}
			}
		}
		else {//3�ܰ� ������ ����
			for(int j = 0; j<3 ; j++) {
				this.showmenu(i);
				System.out.print("��"+(i+1)+"�� "+time[j]+" ���� ���� : ");
				
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
					System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
					j--;
				}
			}
		}
	}
	public void eat() {//�Դ� �޼ҵ� : ������
		System.out.println("�������� �޴� ���æ�������������������������������������������");
		System.out.println("������ �Ұ��.  ");
		System.out.println("������ ����.  ");
		System.out.println("������ ä��.  ");
		System.out.println("������ ���İ�Ƽ.  ");
		System.out.println("������������������������������������������������������������������");
		System.out.print("���޴� ���� : ");
		
		for(int k=0; k<1 ; k++) {
			switch(this.selecter()) {
			case 1 :
				System.out.println("���Ұ��!");
				break;
			case 2 :
				System.out.println("������!");
				break;
			case 3 :
				System.out.println("��ä��!");
				break;
			case 4 :
				System.out.println("�����İ�Ƽ!");
				break;
			default :
				System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
				k--;
			}
		}
		System.out.println("��");
	}
	
	public void relax() {//��� �޼ҵ�
		System.out.println("�������� �޴� ���æ�������������������������������������������");
		System.out.println("������ �౸.  ");
		System.out.println("������ ����.  ");
		System.out.println("������ ���̵���.  ");
		System.out.println("������ ��պ��.  ");
		System.out.println("������������������������������������������������������������������");
		System.out.print("���޴� ���� : ");
		
		for(int k=0; k<1 ; k++) {
		switch(this.selecter()) {
		case 1 :
			System.out.println("���౸!");//�̺κп� ���̿� �´� ������������ ����
			break;
		case 2 :
			System.out.println("������!");//�̺κп� ���̿� �´� ������������ ����
			break;
		case 3 :
			System.out.println("�����̵���!");//�̺κп� ���̿� �´� ������������ ����
			break;
		case 4 :
			System.out.println("����պ��!");//�̺κп� ���̿� �´� ������������ ����
			break;
		default :
			System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
			k--;
			}
		}
		System.out.println("��");
	}
	
	
	
	public void practice() {//�Ʒ� �޼ҵ�
		System.out.println("�����Ʒ� �޴� ���æ�������������������������������������������");
		System.out.println("������ �Ʒ�1.  ");
		System.out.println("������ �Ʒ�2.  ");
		System.out.println("������ �Ʒ�3.  ");
		System.out.println("������ �Ʒ�4.  ");
		System.out.println("������������������������������������������������������������������");
		System.out.print("���޴� ���� : ");
		for(int k=0; k<1 ; k++) {
			switch(this.selecter()) {
			case 1 :
				System.out.println("���Ʒ�1");//�̺κп� �Ʒÿ� �´� ������������ ����
				break;
			case 2 :
				System.out.println("���Ʒ�2");//�̺κп� �Ʒÿ� �´� ������������ ����
				break;
			case 3 :
				System.out.println("���Ʒ�3");//�̺κп� �Ʒÿ� �´� ������������ ����
				break;
			case 4 :
				System.out.println("���Ʒ�4");//�̺κп� �Ʒÿ� �´� ������������ ����
				break;
			default :
				System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
				k--;
			}
		
		}
		System.out.println("��");
	}
	
	public void hunting() {//��� �޼ҵ�
		System.out.println("������� �޴� ���æ�������������������������������������������");
		System.out.println("������ ���1.  ");
		System.out.println("������ ���2.  ");
		System.out.println("������ ���3.  ");
		System.out.println("������ ���4.  ");
		System.out.println("������������������������������������������������������������������");
		System.out.print("���޴� ���� : ");
		
		for(int k=0; k<1 ; k++) {
			switch(this.selecter()) {
			case 1 :
				System.out.println("�����1");//�̺κп� ��ɿ� �´� ������������ ����
				break;
			case 2 :
				System.out.println("�����!2");//�̺κп� ��ɿ� �´� ������������ ����
				break;
			case 3 :
				System.out.println("�����3");//�̺κп� ��ɿ� �´� ������������ ����
				break;
			case 4 :
				System.out.println("������4!");//�̺κп� ��ɿ� �´� ������������ ����
				break;
			default :
				System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
				k--;
			}
		}
		System.out.println("��");
	}
	public void event() {//Ư���� �� �߻�, 10%�� Ȯ��
		int a = rand.nextInt(10);//0~9������ ���� ����, �� 10���� ����
		if(a==1) {//���� 1�̶�� ���ڰ� ���ö��� �̺�Ʈ ���� , 10%�� Ȯ���� �̺�Ʈ�� �߻��Ѵ�
			switch(a=rand.nextInt(4)+1){//1~4������ ���� ���� 
			case 1 :
				System.out.println("��-----1�� �̺�Ʈ �߻�!!!!-----");
				break;
			case 2 :
				System.out.println("��-----2�� �̺�Ʈ �߻�!!!!-----");
				break;
			case 3 :
				System.out.println("��-----3�� �̺�Ʈ �߻�!!!!-----");
				break;
			case 4 :
				System.out.println("��-----4�� �̺�Ʈ �߻�!!!!-----");
				break;
			}
		}
	}
	
	public void turnend() {//�ϸ��� ������ �ݿ�
		
	}
	
	//�̺κ� ���ʹ� �߰���� �κ�
	public void sleep(int time){//(time)m/s ��ŭ ���
	    try {
	      Thread.sleep(time);
	    } catch (InterruptedException e) { }
	}
	
	public int selecter() { // ������ �޴� �޼ҵ�, ������ ��ȣ�� �ٸ� ����,����,���ڿ��� ������ 
		select = scan.next();// ������ ���°��� �����ϰ� ���ð��� �ʱ�ȭ �����ְ� return
		try {
			int a=Integer.parseInt(select);
		}catch(NumberFormatException e) {select = "999";}
		return Integer.parseInt(select);
	}
}
