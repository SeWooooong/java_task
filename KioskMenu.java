package Kiosk;
import java.util.Scanner;
class Menu{
	public String coffee; 
	public int price;
	public int inv;
	public int n; //�ֹ� �� coffee ��
	public Menu(String _coffee, int _price, int _inv) {
		coffee = _coffee; price = _price; inv=_inv; n=0;
	}
	public void semenu(){
		this.inv = this.inv - this.n;
	}
}

public class KioskMenu {
	public boolean check(Menu menu[]) { // ��� �������� �˻��Ѵ�.
		for(int i=0; i<menu.length; ++i) {
			if(menu[i].inv < menu[i].n ) {
				return false;
			}
		}
		return true;
	}
	public void setinv(Menu menu[]) { //������ ��带 ����
		System.out.println("[������ ���]");
		System.out.print("������ ��带 �������� '����', ��� ������ ���ϸ� �޴� �̸��� �Է��ϼ��� >>");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int chainv;
		while(!str.equals("����")) {
		for(int i=0; i<menu.length; ++i) {
			if(menu[i].coffee.equals(str)) {
				System.out.println(str + "�� ���� ���� " + menu[i].inv + "�Դϴ�. ������ ���Ͻô� ������ �Է��ϼ��� >>" );
				chainv = scanner.nextInt();
				menu[i].inv =chainv;
				break;
			}
		}
		 System.out.print("������ ��带 �������� '����', ��� ������ ���ϸ� �޴� �̸��� �Է��ϼ��� >>");
		 str = scanner.next();
		}
	}
	public static void main(String[] args) {
		KioskMenu ki = new KioskMenu();
		System.out.println("[Ű����ũ �ʱ�ȭ]"); //Ű����ũ �ʱ�ȭ �κ�
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Ǹ��ϰ��� �ϴ� �޴� ���� ���� �Է��ϼ��� >> ");
		int n=0;
		n=scanner.nextInt();
		String coffee; int price; int inv;
		Menu menu[] = new Menu[n];
		for(int i=0; i<n; ++i) {
			System.out.print("�Ǹ��ϰ��� �ϴ� " +i+ "�� �޴� �̸�, ����, ��� �Է��ϼ���(��: �Ƹ޸�ī�� 2000 10) >> ");
			coffee = scanner.next(); price = scanner.nextInt(); inv = scanner.nextInt();
			menu[i]=new Menu(coffee, price, inv);
		}
		System.out.println("[�ʱ�ȭ �Ϸ�]");
		while(true) { //�޴��� ���
			int sum=0;
			System.out.println("�޴���");
			for(int i=0; i<menu.length; ++i) {
			System.out.println(menu[i].coffee + ":" +menu[i].price+ "��(���:" + menu[i].inv +")");
			}
			System.out.println("���ϴ� �޴��� �Է��ϼ���(����� �޴� ����, ���������� '�ֹ�' �Է�) >> ");
			String str;
			str = scanner.next();
			if(str.equals("����")) {
				System.out.println("����Ǿ����ϴ�");
				break;
			}
			else if(str.equals("������")){
			ki.setinv(menu);
			}
			else {
				 while(!str.equals("�ֹ�")) {
					 for(int i=0; i<menu.length; ++i) {
						 if(menu[i].coffee.equals(str)) {
							 menu[i].n++;
						 }
					 }
					 str = scanner.next();
				 }
				 for(int i=0; i<menu.length;++i) {
					 sum += menu[i].price * menu[i].n;
				 }
				 if(!ki.check(menu)) {
					 System.out.println("��� ������ ��ǰ�� �ֽ��ϴ�. �ٽ� �ֹ����ּ���.");
					 for(int i=0; i<menu.length;++i) {
						 menu[i].n=0;
					 }
				 }
				 else {System.out.println("��ä �ݾ��� " +sum+ "���Դϴ�");
				 for(int i=0; i<menu.length;++i) {
					 menu[i].semenu();
					 menu[i].n=0;
				 }
				 }
			}		
        }
		scanner.close();
    }	
}
