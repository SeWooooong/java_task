import java.util.Scanner;

abstract class GameObject {
	protected int x,y; // 현재 위치(화면 맶 상의 위치)
	public GameObject(int x, int y) {
		this.x=x; this.y=y;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public boolean collide(GameObject p) {
		if(this.x == p.getX() && this.y == p.getY()) return true;
		else return false;
	}
	public abstract boolean move(); //이동 후의 새로운 위치로 x,y변경, 도둑질을 했는지 리턴
	public abstract char getSahpe(); // 갹채의 모양을 나타내는 문자 리턴
}

class Police extends GameObject{
    public Police(int x, int y) {
    	super(x,y);
    }
    public boolean move() {
    	int movepolice = (int)(Math.random()*5+1);
    	boolean ch = true;
    	switch(movepolice) {
    	case 1: //상
    		if(y<=0) {
    			y=0;
    		}
    		else y-=1;
    		ch=true;
    		break;
    	case 2: //하
    		if(y>=2) {
    			y=2;
    		}
    		else y+=1;
    		ch=true;
    		break;
    	case 3: //좌
    		if(x<=0) {
    			x=0;
    		}
    		else x-=1;
    		ch=true;
    		break;
    	case 4: //우
    		if(x>=2) {
    			x=2;
    		}
    		else x+=1;
    		ch=true;
    		break;
    	case 5:
    		x=this.getX(); 
    		y=this.getY();
    		ch=false;
    		break;
        }
    	return ch;
    }
    public char getSahpe() {
    	return 'P';
    }
}

class Thief extends GameObject{
	 public Thief(int x, int y) {
		 super(x,y);
	 }
	 public boolean move() {
		 System.out.print("왼쪽(a),아래(s),위(w),오른쪽(d),도둑질(r) >> ");
		 Scanner scanner = new Scanner(System.in);
		 String a = scanner.next();
		 boolean ch = true;
		 switch(a) {
		 case"a":
		    if(x<=0) {
	    	   x=0;
	    	}
	    	 else x-=1;
		    ch=false;
	    	break;
		 case"s":
		   if(y>=2) {
	         y=2;
	       }
	       else y+=1;
		   ch=false;
	       break;
		 case"w":
		    if(y<=0) {
	    	y=0;
	    	}
	    	else y-=1;
		    ch=false;
		    break;
		 case"d":
			if(x>=2) {
	    		x=2;
	    	}
	    	else x+=1;
			ch=false;
			break; 
		 case "r":
			x=this.getX(); 
	    	y=this.getY();
	    	ch=true;
	    	break;
	     }
		 return ch;
	 }
	 public char getSahpe() {
	    	return '&';
	    }
}

public class Game {
	static boolean check(char a[][]) { //이겼는지 check하는 메소드
		int count =0;
		boolean ch=false;
		for(int i=0; i<a.length; ++i) {
			for(int j=0; j<a[i].length; ++j) {
				if(a[i][j] == '-') {
					++count;
				}
			}
		}
		if(count == 9) {
			ch=true;
		}
		return ch;
	}
	public static void main(String args[]) {
		Police p = new Police(0,0);
		Thief t = new Thief(2,2);
		char gameArray[][] = new char[3][3];
		char checkArray[][] = new char[3][3];
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				gameArray[i][j] = '^';
				checkArray[i][j]='^';
			}
		}
		gameArray[p.getX()][p.getY()] = p.getSahpe();
		gameArray[t.getX()][t.getY()] = t.getSahpe();
		System.out.println("박세웅/컴퓨터공학과/12191604");
		System.out.print("**도둑 잡기 게임을 시작합니다.**");
		while(true) {
			for(int i=0; i<3; ++i) {//array 출력
				System.out.print("\n");
				for(int j=0; j<3; ++j) {
					System.out.print(gameArray[i][j]);
				}
			}
			System.out.print("\n");
			boolean a = t.move();
			boolean b = p.move();
			if(a==true) {
				checkArray[t.getY()][t.getX()] ='-';
			}
			if(p.collide(t)) {
				for(int i=0; i<3; ++i) {//array 출력
					System.out.print("\n");
					for(int j=0; j<3; ++j) {
						System.out.print(gameArray[i][j]);
					}
				}
				System.out.print("\n");
				System.out.print("당신이 졌습니다!");
				break;
			}
			if(check(checkArray)==true) {
				for(int i=0; i<3; ++i) {//array 출력
					System.out.print("\n");
					for(int j=0; j<3; ++j) {
						System.out.print(gameArray[i][j]);
					}
				}
				System.out.print("\n");
				System.out.print("당신이 이겼습니다!");
				break;
			}
			for(int i=0; i<3; ++i) {//array 출력
				for(int j=0; j<3; ++j) {
					if(checkArray[i][j]=='-') {
						gameArray[i][j]='-';
					}
					else gameArray[i][j]='^';
				}
			}
			gameArray[p.getY()][p.getX()]=p.getSahpe();
			gameArray[t.getY()][t.getX()]=t.getSahpe();
		}
	}
}
