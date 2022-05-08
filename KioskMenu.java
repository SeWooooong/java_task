package Kiosk;
import java.util.Scanner;
class Menu{
	public String coffee; 
	public int price;
	public int inv;
	public int n; //주문 한 coffee 수
	public Menu(String _coffee, int _price, int _inv) {
		coffee = _coffee; price = _price; inv=_inv; n=0;
	}
	public void semenu(){
		this.inv = this.inv - this.n;
	}
}

public class KioskMenu {
	public boolean check(Menu menu[]) { // 재고가 부족한지 검사한다.
		for(int i=0; i<menu.length; ++i) {
			if(menu[i].inv < menu[i].n ) {
				return false;
			}
		}
		return true;
	}
	public void setinv(Menu menu[]) { //관리자 모드를 연다
		System.out.println("[관리자 모드]");
		System.out.print("관리자 모드를 나가려면 '종료', 재고 변경을 원하면 메뉴 이름을 입력하세요 >>");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int chainv;
		while(!str.equals("종료")) {
		for(int i=0; i<menu.length; ++i) {
			if(menu[i].coffee.equals(str)) {
				System.out.println(str + "의 재고는 현재 " + menu[i].inv + "입니다. 변경을 원하시는 수량을 입력하세요 >>" );
				chainv = scanner.nextInt();
				menu[i].inv =chainv;
				break;
			}
		}
		 System.out.print("관리자 모드를 나가려면 '종료', 재고 변경을 원하면 메뉴 이름을 입력하세요 >>");
		 str = scanner.next();
		}
	}
	public static void main(String[] args) {
		KioskMenu ki = new KioskMenu();
		System.out.println("[키오스크 초기화]"); //키오스크 초기화 부분
		Scanner scanner = new Scanner(System.in);
		System.out.print("판매하고자 하는 메뉴 종류 수를 입력하세요 >> ");
		int n=0;
		n=scanner.nextInt();
		String coffee; int price; int inv;
		Menu menu[] = new Menu[n];
		for(int i=0; i<n; ++i) {
			System.out.print("판매하고자 하는 " +i+ "번 메뉴 이름, 가격, 재고를 입력하세요(예: 아메리카노 2000 10) >> ");
			coffee = scanner.next(); price = scanner.nextInt(); inv = scanner.nextInt();
			menu[i]=new Menu(coffee, price, inv);
		}
		System.out.println("[초기화 완료]");
		while(true) { //메뉴판 출력
			int sum=0;
			System.out.println("메뉴판");
			for(int i=0; i<menu.length; ++i) {
			System.out.println(menu[i].coffee + ":" +menu[i].price+ "원(재고:" + menu[i].inv +")");
			}
			System.out.println("원하는 메뉴를 입력하세요(띄어쓰기로 메뉴 구분, 마지막에는 '주문' 입력) >> ");
			String str;
			str = scanner.next();
			if(str.equals("종료")) {
				System.out.println("종료되었습니다");
				break;
			}
			else if(str.equals("재고관리")){
			ki.setinv(menu);
			}
			else {
				 while(!str.equals("주문")) {
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
					 System.out.println("재고가 부족한 상품이 있습니다. 다시 주문해주세요.");
					 for(int i=0; i<menu.length;++i) {
						 menu[i].n=0;
					 }
				 }
				 else {System.out.println("전채 금액은 " +sum+ "원입니다");
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
