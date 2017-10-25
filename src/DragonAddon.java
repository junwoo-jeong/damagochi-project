/**
 * 3�� ù ��° �������� ���α׷�(class name : DragonAddon.java)
 * ���α׷��� : �巡��Ű���
 * Made by 3��
 * ���� : ���ؿ� / ���� : ������, �躸��
 * �����Ⱓ : 17.9.11 ~ 17.10.22
 * version. 0.01 
 */
import java.util.Scanner;

public class DragonAddon {
	Scanner scan = new Scanner(System.in);
	public void sleep(int time) {// (time)m/s ��ŭ ���
		try {
			Thread.sleep(time);//���ͷ�Ʈ���� �߻�
		} catch (InterruptedException e) {//���ܰ� �߻������� ������ ����
		}
	}

	public int selecter() { // ������ �޴� �޼ҵ�, ������ ��ȣ�� �ٸ� ����,����,���ڿ��� ������
		String select = scan.next();// ������ ���°��� �����ϰ� ���ð��� �ʱ�ȭ �����ְ� return
		try {
			int a = Integer.parseInt(select);// ���ڿ� ���ڸ� ������ ���ڷ� �ٲپ��ִ� ����, but ���ڳ� ���ڿ��� �ٲܷ��� �ϸ�
												// 'NumberFormatException'�̶�� �����߻�!
		} catch (NumberFormatException e) {select = "999";} // �տ����� ������ ����ó���ϴ� �κ�, 999��� �ǹ̾��� ���ڸ� select�� �־ �ʱ�ȭ 
		// ���ڿ��� select�� ���� ��Ŵ!
		return Integer.parseInt(select);
	}
	
	public void loadingbar() {//�ε��ٸ� ����� �޼ҵ�, 5���� .�� 0.4�ʸ��� ����ְ� �ٹٲ�
		for(int i = 0;i<5;i++) {
			sleep(400);
			System.out.print(".");
		}
		System.out.println();
	}
}
