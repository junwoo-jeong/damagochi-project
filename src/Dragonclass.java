
/**
 * 3�� ù ��° �������� ���α׷�(class name : Dragonclass.java)
 * ���α׷��� : �巡��Ű���
 * Made by 3��
 * ���� : ���ؿ� / ���� : ������, �躸��
 * �����Ⱓ : 17.9.11 ~ 17.10.22
 * version. 0.01 
 */

import java.util.*;
					
public class Dragonclass {
	Scanner scan = new Scanner(System.in);//���ɳ� Ŭ����
	Random rand = new Random();//���� Ŭ����
	
	DragonPicture pc = new DragonPicture();//��Ʈ�̹���Ŭ���� ��ü ���� 
	DragonMiniGame game = new DragonMiniGame();//�̴ϰ���Ŭ���� ��ü ���� 
	DragonAddon addon = new DragonAddon();//�߰����Ŭ���� ��ü ���� 
	
	int PLAYTIME = 20; // �÷���Ÿ��
	int EGGTIME = 2; // ����Ÿ��
	
	String name; // �÷��̾� �̸�
	String dname; //�巹�� �̸�
	int type; // �巡�� �Ӽ�, (1,2,3)
	String[] time = { "����ħ��", "�����ɡ�", "�����᡹" };//Ÿ�� ���ڿ�
	int food = 50;// ��θ� ����, �ʱⰪ : 50%, max : 100%
	int stress = 50;// ��Ʈ���� ����, �ʱⰪ : 50%, max : 100%
	int health;// ü�� �ɷ�ġ
	int knowledge;// ���� �ɷ�ġ
	int anger;// ������ �ɷ�ġ
	
	int turnOff = 0;//�������� ����
	
	public void playgame() {// �ε�ȭ��, ����ȭ��, �ٸ� �޼ҵ带 Ȱ���Ͽ� ������ ���۵Ǵ� �κ�
		
		System.out.println("�ε����Դϴ�...");//�ε�ȭ�� ����ϴ� ���ۺκ�
		for (int i = 1; i <= 30; i++) {//�ε��� ���, 0.2�ʸ��� 29���� �Ḧ ��� �� �������� 100% ��� ���ڿ� ����� �� �ٹٲ�
			addon.sleep(200);
			if (i < 30)
				System.out.print("��");
			else
				System.out.println(" 100%!!\n");
		}
		
		addon.sleep(1500);
		System.out.println("��Made by 3��");
		addon.sleep(1500);
		System.out.println("�������� ���ؿ� �躸��\n");
		addon.sleep(2000);
		System.out.println("������������������������������������������������������������������������������������������������������������\n");
		
		do {// ���� ����ȭ�� ����ϴ� do-while�� �� ���ۺκ�
			System.out.println();//
			System.out.println();//
			addon.sleep(2000);
			pc.logo();//Dragonpicture�� �ִ� logo�� ȣ���Ͽ� ���,
			System.out.println("��1. ���ӽ���");// �Ŵ����
			System.out.println("��2. �÷��� Ÿ�� ����");
			System.out.println("��3. ���� ����");
			System.out.println("�����Ͻʽÿ� : ");//�޴� ����
			switch(addon.selecter()) {//�߰���� Ŭ������ �ִ� selecter()�޼ҵ带 ȣ��, �������� �������� ���ڹ��ڿ��� �Է¹޾� int�� ������ ��ȯ�Ͽ� return �ϴ� �޼ҵ�, ����ڰ� ���ڿ��� �Է��ϴ� �������� ��Ȳ�� ó������
			case 1: //���ӽ��ۺ�, 1���� ����������
				System.out.println();
				System.out.println();
				opening();
				for(int i = 0; i<PLAYTIME ; i++){//�÷���Ÿ��
					playplan(i);//�̺κп��� ���� ��¥, ����â ���
					
					if(turnOff == 1) break;
				}		
					ending();	//�̺κп��� �������
					System.out.println("--��--");
					addon.sleep(3000);
					
					break;
			case 2://�÷���Ÿ�� ������, 2���� ����������
				System.out.println("��1. �� �÷��� Ÿ��");//������ �޴� ���
				System.out.println("��2. �߰� �÷��� Ÿ��");
				System.out.println("��3. ª�� �÷���Ÿ��");
				System.out.println("�����Ͻʽÿ� : ");
					switch(addon.selecter()) {//�������� ������ �Է¹޾� ���ÿ� ���� PLAYTIME, EGGTIME ������ �������� �°� ����
					case 1:
						PLAYTIME=30;
						EGGTIME=4;
						System.out.print("�������� �Դϴ�");
						addon.loadingbar();//�߰����Ŭ�������� �ε��ٸ޼ҵ� ȣ��
						break;
					case 2:
						PLAYTIME=20;
						EGGTIME=4;
						System.out.print("�������� �Դϴ�");
						addon.loadingbar();//�߰����Ŭ�������� �ε��ٸ޼ҵ� ȣ��
						break;
					case 3:
						PLAYTIME=10;
						EGGTIME=2;
						System.out.print("�������� �Դϴ�");
						addon.loadingbar();//�߰����Ŭ�������� �ε��ٸ޼ҵ� ȣ��
						break;
					default ://���ܰ� �߻��� ��Ȳ���� ����Ǵ� �κ�, selecter�޼ҵ�� �⺻������ ���ڹ��ڿ��� �Է¹ް� ��Ʈ�� ���ڷ� ��ȯ�ϴµ�, ����ڰ� ���ڿ��� �Է��Ͽ� ��Ʈ�� ��ȯ�� �Ұ����� ��츦 ó��
						System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
					}
				break;
			case 3:
				System.out.println("���÷��� ���ּż� �����մϴ�.");
				turnOff=1;
				break;
			default :
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
			}
		}while(turnOff!=1);
	}
	
	
	public void opening() { // ������ : ���丮 ���, ����� �̸�, �巹�� �̸� ����, playplan�޼ҵ忡�� �����
		System.out.print("������� �̸��� �Է����ּ���! : ");//����� �̸� �Է¹ޱ�
		name = scan.next();
		addon.sleep(3000);
		System.out.println("\n�����ϸ����� �Ѱ��� " + name + "�� ������ �������� �մϴ�");
		addon.sleep(1500);
		System.out.println("���������� ���� ���ұ��?(���ڷ� �Է����ּ���)");
		addon.sleep(1000);
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1.���̡������� �ִ� �߿��");
		System.out.println("��2.������ �ִ� ��");
		System.out.println("��3.����츲");
		System.out.println("����������������������������������������������������������������");
		for(int i=0 ; i<1 ; i++)//1���� ����Ǵ� �ݺ��� ������ 1,2,3 �̿��� �������� �Է������� i--�� ���־� �������� ���� �Էµ� �� ���� ���� �ϴ� ����
		switch(addon.selecter()) {
		case 1 :
			addon.sleep(2000);
			System.out.println("�������� �幰�� ���� ������ ����� �ȴ� �����");
			addon.sleep(1500);
			System.out.println("����� ���� �߰��ϰ� ������ �����ɴϴ�");
			health = 70;
			knowledge = 10;
			anger = 40;
			type=1;
			break;
		case 2:
			addon.sleep(2000);
			System.out.println("������ ����� ������ �������� �����");
			addon.sleep(1500);
			System.out.println("���������� ���� �߰��ϰ� ������ �����ɴϴ�");
			health = 70;
			knowledge = 30;
			anger = 20;
			type=2;
			break;
		case 3:
			addon.sleep(2000);
			System.out.println("������츲�� ���� ������ Ž���ϴ� �����");
			addon.sleep(1500);
			System.out.println("���������� ���� �߰��ϰ� ������ �����ɴϴ�");
			health = 70;
			knowledge = 20;
			anger = 30;
			type=3;
			break;
		default ://���������� �Է��� �޾��� �� �б�
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			i--;		
		}
		addon.sleep(1000);
		System.out.println("�� �̻��� ���� �̸��� �����ּ��� : ");
		dname = scan.next();
		addon.sleep(1500);
		System.out.println("�������� ������ ��ġ�� ������ ���ƿԽ��ϴ�");
		addon.sleep(1500);
		System.out.println("�����࿡�� �߰��� �ź��� ���� �˰� �Բ��Դϴ�");
		addon.sleep(1500);
		System.out.println("���˿��� ������ ������, ��ȭ��ų �� �������� ������");
		addon.sleep(1500);
		System.out.println("���ϴ� ��� �� ������ �մϴ�.");
		addon.sleep(1500);
		System.out.println("�������� �˰� �Բ��ϴ� 1�����Դϴ�.");
		addon.sleep(1500);
		System.out.println("������ ������ �� �����?\n\n\n");
	}

	public void showstatus() {// ����â ���, showmenu�޼ҵ� ���� ����
		for (int i = 0; i < 8; i++) {//���� for�� ����, �� 8���� ������ ��µȴ�.
			switch (i) { // case i �� �ִ� �������
			case 0:
				System.out.print("�������ݡ��޴���������������������������������������������������");
				break;
			case 1:
				System.out.print("���̡�����:��" + dname);
				break;
			case 2:
				System.out.print("����������:��");
				break;
			case 3:
				System.out.print("����Ʈ����:��");
				break;
			case 4:
				System.out.print("��ä���¡�:��" +health);
				break;
			case 5:
				System.out.print("�������ġ�:��" +knowledge);
				break;
			case 6:
				System.out.print("�������ԡ�:��"+anger);
				break;
			case 7:
				System.out.print("����������������������������������������������������������������");
			}

			for (int j = 0; j < 10; j++) {//�������� ��Ʈ������ sleep�޼ҵ带 Ȱ���Ͽ� �ۼ�Ʈ�� �ð������� ����ϱ����� ����ϴ� ���� for��
				if (i == 2) {// case 2���� ����
					if (j < (food / 10)) {//food�� 10���� ���� ���� 0~10 ������ ������ ����, j�� ���� ������ ������ 10%�� �ǹ��ϴ� '��'�� ����ϰ�, 
						addon.sleep(100);
						System.out.print("��");
					} else {//�ƴ� ���� '��' ���
						addon.sleep(100);
						System.out.print("��");
					}
				}
				if (i == 3) {//case 3 ���� ����
					if (j < (stress / 10)) {//�ٷ� ���� ���İ� ����
						addon.sleep(100);
						System.out.print("��");
					} else {
						addon.sleep(100);
						System.out.print("��");
					}
				}
			}
			System.out.println();
		}
	}

	public void showmenu(int i) {// �ܰ躰 �޴����, playplan�޼ҵ忡�� ����
		if (i<EGGTIME) {// 1�ܰ��� �޴� ���, �� ���� ���, if�� ���� ������ ����ڰ� ������ �÷���Ÿ�Ӱ� ����Ÿ�ӿ� ����  �ܰ躰 �÷���Ÿ���� ������ �� �ֵ��� ����� ����
			//���� ��� �÷���Ÿ���� 20���̰� ����Ÿ���� 4���̸�  1�ܰ� �Ŵ��� �� ���� 4�� ������ ����,
			pc.egg();//Ÿ�Կ� �´� �� ���
			System.out.println("��" + (i + 1) + "�ϡ�");//�� ���� ����Ǵ� for���� i�� 0���� �����ϱ⶧���� ����� �� 1�� ���Ͽ� ���
			showstatus();//����â ���
			addon.sleep(200);
			System.out.println("�����ൿ�����æ�������������������������������������������������");
			System.out.println("��1. ���ٵ��.  ");
			System.out.println("��2. ǰ���ֱ�.  ");
			System.out.println("��3. ��ġ�ϱ�.  ");
			System.out.println("��4. �뱼�뱼.  ");
			System.out.println("����������������������������������������������������������������");
			
		} else if (i>=EGGTIME && i<(PLAYTIME+EGGTIME)/2) {// 2�ܰ��� �޴� ���, if�� ���� ������ ����ڰ� ������ �÷���Ÿ�Ӱ� ����Ÿ�ӿ� ����  �ܰ躰 �÷���Ÿ���� ������ �� �ֵ��� ����� ����
			//2�ܰ� �Ŵ��� 4���� ũ�ų� ���� 12���� ���� ���, �� 8�� ���� 2�ܰ� �޴����
			pc.childDragon(type);//Ÿ�Կ� �´� � �巡�� ���
			System.out.println("��" + (i + 1) + "�ϡ�");//�� ���� ����Ǵ� for���� i�� 0���� �����ϱ⶧���� ����� �� 1�� ���Ͽ� ���
			showstatus();//����â ���
			addon.sleep(200);
			System.out.println("�����ൿ�����æ�������������������������������������������������");
			System.out.println("��1. �Ա�.  ");
			System.out.println("��2. �Ʒ�.  ");
			System.out.println("��3. �޽�.  ");
			System.out.println("��4. �߰�����  ");
			System.out.println("����������������������������������������������������������������");
		} else {// 3�ܰ��� �޴����
			//3�ܰ� �Ŵ��� �� ���� ��Ȳ, �� 12�Ϻ��� ũ�ų� ���� PLAYTIME���ٴ� ���� 8�ϵ��� 3�ܰ� �޴� ���
			pc.Dragon(type);//� �巡�� ���
			System.out.println("��" + (i + 1) + "�ϡ�");//�� ���� ����Ǵ� for���� i�� 0���� �����ϱ⶧���� ����� �� 1�� ���Ͽ� ���
			showstatus();//Ÿ�Կ� �´� ����â ���
			addon.sleep(200);
			System.out.println("�����ൿ�����æ�������������������������������������������������");
			System.out.println("��1. �Ա�.  ");
			System.out.println("��2. �Ʒ�.  ");
			System.out.println("��3. ���.  ");
			System.out.println("��4. �޽�.  ");
			System.out.println("����������������������������������������������������������������");
		}
	}

	public void playplan(int i) {// ������ ����, �ܺ� �ϼ��� ī��Ʈ �ϴ� for������ �Ű����� i�� �Է¹޾ƿ�, playgame�޼ҵ忡�� ����
		if (i<EGGTIME) {// 1�ܰ� ����������
			egg(i);
		} 
		else if (i>=EGGTIME && i<(PLAYTIME+EGGTIME)/2) {// 2�ܰ� 1���޴��� ����ϰ� �÷��̾�� 2���޴��� ���� ������ ����
			for (int j = 0; j < 3; j++) {// ��ħ ���� ���������� ���ù���
				addon.sleep(1000);
				showmenu(i);// 2�ܰ� 1�� �޴� ���
				System.out.print(time[j]+"�� ���� ���� : ");
				switch (addon.selecter()) {// 2�ܰ� 2���޴� ����
				case 1:
					eat();
					event();
					turnend();//�ð��� ���������� ����������� �Ǵ� ������h �ѹ��� ó�� 
					break;
				case 2:
					practice();
					event();
					turnend();//�ð��� ���������� ����������� �Ǵ� ������h �ѹ��� ó�� 
					break;
				case 3:
					relax();
					event();
					turnend();//�ð��� ���������� ����������� �Ǵ� ������h �ѹ��� ó�� 
					break;
				default:
					System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
					j--;
				}
				
			}
			System.out.println("��");
		} else {// 3�ܰ� ������ ����
			for (int j = 0; j < 3; j++) {
				addon.sleep(1000);
				showmenu(i);
				System.out.print(time[j]+"�� ���� ���� : ");

				addon.sleep(200);
				switch (addon.selecter()) {
				case 1:
					eat();
					event();
					turnend();//�ð��� ���������� ����������� �Ǵ� ������h �ѹ��� ó�� 
					break;
				case 2:
					practice();
					event();
					turnend();//�ð��� ���������� ����������� �Ǵ� ������h �ѹ��� ó�� 
					break;
				case 3:
					hunting();
					event();
					turnend();//�ð��� ���������� ����������� �Ǵ� ������h �ѹ��� ó�� 
					break;
				case 4:
					relax();
					event();
					turnend();//�ð��� ���������� ����������� �Ǵ� ������h �ѹ��� ó�� 
					break;
				default:
					System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
					j--;
				}
			}
		}
		System.out.println("");
	}

	public void egg(int i) {
		for (int j = 0; j < 3; j += 2) {// ��ħ ���������� ���ù���
			addon.sleep(1000);
			showmenu(i);
			System.out.print(time[j]+"�� ���� ���� : ");
			switch (addon.selecter()) {
			case 1:
				System.out.print("����ü�Ҹ��� ���� ����� ������ ���ٵ�����ϴ�.\n");
				anger -= 5;
				break;
			case 2:
				System.out.print("����ü�Ҹ��� ���� �����ϰ� ǰ�����ϴ�.\n");
				anger -= 5;
				break;
			case 3:
				System.out.print("����ü�Ҹ��� ���� �������ϰ� ��ġ�صξ����ϴ�.\n");
				anger += 5;
				break;
			case 4:
				System.out.print("������������ ����Դϴ�.\n");
				anger += 5;
				break;
			default:
				System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
				j -= 2;
			}
			System.out.println("��");
		
	}
		System.out.println("��");
	}
	public void eat() {// �Դ� �޼ҵ� : ������
		addon.sleep(200);
		System.out.println("�������ġ��޴������æ�������������������������������������������");
		System.out.println("������ ����.  ");
		System.out.println("������ ä��.  ");
		System.out.println("������ �����.  ");
		System.out.println("������ ���.  ");
		System.out.println("����������������������������������������������������������������");
		System.out.print("���޴� ���� : ");

		for (int k = 0; k < 1; k++) {
			switch (addon.selecter()) {
			case 1:
				System.out.println("���Ұ��!");
				food += 30;
				stress -=5;
				break;
			case 2:
				System.out.println("������!");
				food += 25;
				stress -=5;
				break;
			case 3:
				System.out.println("��ä��!");
				food += 20;
				stress -=5;
				break;
			case 4:
				System.out.println("�����İ�Ƽ!");
				food += 25;
				stress -=5;
				break;
			default:
				System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
				k--;
			}
		}
		System.out.println("");
	}

	public void relax() {// ��� �޼ҵ�
		addon.sleep(200);
		System.out.println("�������̡��޴������æ�������������������������������������������");
		System.out.println("������ �౸.  ");
		System.out.println("������ ����.  ");
		System.out.println("������ ���̵���.  ");
		System.out.println("������ ��պ��.  ");
		System.out.println("����������������������������������������������������������������");
		System.out.print("���޴� ���� : ");

		for (int k = 0; k < 1; k++) {
			switch (addon.selecter()) {
			case 1:
				System.out.println("���౸�� ��̰� �߽��ϴ�.(ä�� �뷮 ���!)");// �̺κп� ���̿� �´� ������������ ����
				health+=20;
				stress-=5;
				food-=20;
				break;
			case 2:
				System.out.println("������!(ä�� �뷮 ���!)");// �̺κп� ���̿� �´� ������������ ����
				health+=20;
				stress-=5;
				food-=20;
				break;
			case 3:
				System.out.println("�����̵���!(ü�� �ҷ� ���!) ");// �̺κп� ���̿� �´� ������������ ����
				health+=5;
				stress-=10;
				food-=30;
				break;
			case 4:
				System.out.println("����պ��!(��Ʈ���� �뷮 ����!)");// �̺κп� ���̿� �´� ������������ ����
				stress-=10;
				food-=10;
				break;
			default:
				System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
				k--;
			}
		}
		System.out.println("");
	}

	public void practice() {// �Ʒ� �޼ҵ�
		addon.sleep(200);
		System.out.println("�����Ʒá��޴������æ�������������������������������������������");
		System.out.println("������ ����̱�  ");
		System.out.println("������ ��å��Ű��  ");
		System.out.println("������ ���� �Ʒ�  ");
		System.out.println("������ ��� �Ʒ�  ");
		System.out.println("����������������������������������������������������������������");
		System.out.print("���޴� ���� : ");
		for (int k = 0; k < 1; k++) {
			switch (addon.selecter()) {
			case 1:
				System.out.println("������̱�(ä�� �뷮 ���!)");// �̺κп� �Ʒÿ� �´� ������������ ����
				health+=40;
				knowledge+=10;
				stress+=20;
				anger-=5;
				break;
			case 2:
				System.out.println("����å��Ű��(���� �뷮 ���!)");// �̺κп� �Ʒÿ� �´� ������������ ����
				health+=10;
				knowledge+=40;
				stress+=20;
				anger-=5;
				break;
			case 3:
				System.out.println("������ �Ʒ�(ä�� ���� ���!)");// �̺κп� �Ʒÿ� �´� ������������ ����
				health+=20;
				knowledge+=30;
				stress+=20;
				anger+=5;
				break;
			case 4:
				System.out.println("����� �Ʒ�(ä�� ���� ���!)");// �̺κп� �Ʒÿ� �´� ������������ ����
				health+=30;
				knowledge+=20;
				stress+=20;
				anger+=5;
				break;
			default:
				System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
				k--;// k�� 1 ���ָ鼭 1���� ���� ������ �ѹ��� ���� �ϱ� ����
			}

		}
		System.out.println("��");
	}

	public void hunting() {// ��� �޼ҵ�
		addon.sleep(200);
		System.out.println("������ɡ��޴������æ�������������������������������������������");
		System.out.println("������ ũ���� �߷� ���  ");
		System.out.println("������ ���� ���  ");
		System.out.println("������ ȥ���� ���  ");
		System.out.println("������ ŷ������ ���  ");
		System.out.println("����������������������������������������������������������������");
		System.out.print("���޴� ���� : ");

		for (int k = 0; k < 1; k++) {
			switch (addon.selecter()) {
			case 1:
				System.out.println("��"+dname+"�� ũ���� �߷��� ��ҽ��ϴ�!!!");// �̺κп� ��ɿ� �´� ������������ ����
				health+=40;
				knowledge+=20;
				stress+=15;
				anger+=5;
				break;
			case 2:
				System.out.println("��"+dname+"�� ������ ��ҽ��ϴ�!!!");// �̺κп� ��ɿ� �´� ������������ ����
				health+=20;
				knowledge+=40;
				stress+=15;
				anger+=5;
				break;
			case 3:
				System.out.println("��"+dname+"�� ȥ������ ��ҽ��ϴ�!!!");// �̺κп� ��ɿ� �´� ������������ ����
				health+=40;
				knowledge+=40;
				stress+=20;
				anger+=5;
				break;
			case 4:
				System.out.println("��"+dname+"�� ŷ�������� ��ҽ��ϴ�!!!");// �̺κп� ��ɿ� �´� ������������ ����
				health+=50;
				knowledge+=10;
				stress+=15;
				anger+=5;
				break;
			default:
				System.out.println("���߸��� ���� �Է��ϼ̽��ϴ�. ��ȣ�� �Է����ּ���");
				k--;
			}
		}
		System.out.println("��");
	}

	public void event() {// �� ���ø��� �̺�Ʈ �߻�, 20%�� Ȯ��
		int a = rand.nextInt(5);// 0~5������ ���� ����, �� 5���� ����
		if (a == 1) {// ���� 1�̶�� ���ڰ� ���ö��� �̺�Ʈ ���� , 20%�� Ȯ���� �̺�Ʈ�� �߻��Ѵ�
			switch (a = rand.nextInt(4) + 1) {// 1~4������ ���� ���� 25%�� Ȯ���� �б�
			case 1:
				System.out.println("���̴ϰ��� 1");
				game.bitGame();//���ؿ�
				break;
			case 2:
				System.out.println("���̴ϰ��� 2");
				game.rockScissorPaperGame();//�躸��
				break;
			case 3:
				System.out.println("���̴ϰ��� 3");
				game.numberMatchingGame();//������
				break;
			}
		}
	}

	public void turnend() {// �ϸ��� ������ �ݿ�
			food-=5;//�ϸ��� ������ 5����
			if(food>=90) {//�������� 90�̻��� �Ǹ� ����
				addon.sleep(2000);
				System.out.println("�ص巡���� �������� ����� �մϴ�!!. �ɷ�ġ�� �뷮 �����մϴ�!!��");
				addon.sleep(2000);
				
				knowledge -=rand.nextInt(10)+10;//10~19������ ���ڻ���, ��Ʈ������ ü�� �ɷ�ġ �����ϰ� ����
				health -=rand.nextInt(10)+10;//10~19������ ���ڻ���, ��Ʈ������ ������ ���� �����ϰ� ����
				anger +=rand.nextInt(5)+5;//5~10������ ��������, ��Ʈ������ ������ ������ �����ϰ� ����.
				
				if(food>=100)food=100;// 100�� ������ 100���� �ʱ�ȭ
			} 
			
			if(food<=15) {//�������� 15���ϰ� �Ǹ� ����
				addon.sleep(2000);
				System.out.println("�ص巡���� ���ָ����� ����� �մϴ�!!. �ɷ�ġ�� �뷮 �����մϴ�!!��");
				addon.sleep(2000);
				
				knowledge -=rand.nextInt(10)+10;//10~19������ ���ڻ���, ��Ʈ������ ü�� �ɷ�ġ �����ϰ� ����
				health -=rand.nextInt(10)+10;//10~19������ ���ڻ���, ��Ʈ������ ������ ���� �����ϰ� ����
				anger +=rand.nextInt(5)+5;//5~10������ ��������, ��Ʈ������ ������ ������ �����ϰ� ����.
				
				if(food<=0)food=0;
				}
			
			if(stress>80&&stress<=90) {//��Ʈ������ 80~90������ �Ǹ� �ɷ�ġ ���� 
				addon.sleep(2000);
				System.out.println("�ص巡���� ��Ʈ������ �ʹ� ����� �մϴ�!!. �Ϸ縶�� ���İ� ü���� �뷮 �����մϴ�!!��");
				addon.sleep(2000);
				
				knowledge -=rand.nextInt(10)+10;//10~19������ ���ڻ���, ��Ʈ������ ü�� �ɷ�ġ �����ϰ� ����
				health -=rand.nextInt(10)+10;//10~19������ ���ڻ���, ��Ʈ������ ������ ���� �����ϰ� ����
				anger +=rand.nextInt(5)+5;//5~10������ ��������, ��Ʈ������ ������ ������ �����ϰ� ����.
			}
			if (stress>=100) {//��Ʈ������ 100�� �Ǹ� ���� ����
				turnOff = 1;
			}		
	}
	
	public void ending() {
		//�̺κп� ���� ���丮,�б�
		if(turnOff==1) {
			System.out.println("����� �巡���� ��Ʈ���������� ����� �������ϴ�");
		}
		else if(anger>70) {//�����б� �����Կ� ���� ������ ������ ���� ����
			System.out.println("������ �巡���� ����� ��Ƹ԰� ���� �������ϴ�.");
			if(health<knowledge) {//���ݰ��� ���� � �巡���� ���� ����
				System.out.println("���� ���� �巡���� �׵��� ������� �������� ������ �ı��߽��ϴ�.");				
			}
			else if(health>=knowledge) {//���ݰ��� ���� � �巡���� ���� ����
				System.out.println("���� ���� �巡���� �׵��� ������ ������ ������ �ı��߽��ϴ�.");
			}
		}
		else {//���� �б� �����Կ����� ������ ������ ���� ����
			System.out.println("�¼��� �巡���� ��� �Ǿ����� ���� ������ �ʰ� ����� ���� ��Ű��� �߽��ϴ�.");
			if(health<knowledge) {//���ݰ��� ���� � �巡���� ���� ����
				System.out.println("����� ���� ��Ű�� �巡���� ���� �������� ������ ������ �ذ����ִ� ���ڰ� �Ǿ����ϴ�.");				
			}
			else if(health>=knowledge) {//���ݰ��� ���� � �巡���� ���� ����
				System.out.println("����� ���� ��Ű�� �巡���� ������ ������ ������ ��Ű�� ��ȣ�ڰ� �Ǿ����ϴ�.");
			}
		}
		System.out.println("");
	}
	
}
