import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.Vector;


public class Calculator extends JFrame{
	JLabel pro = new JLabel(" "); // 문제
	JLabel sol = new JLabel(" "); //답
	String str="";
	String dstr="";
	JButton btn[] = new JButton[20]; //button 20개
	String[] buttons= {"","DEL","CE","/","1","2","3","X","4","5","6","+","7","8","9","-",
			  "","0",".","="};  //button 초기화 할 문자들
	static String solution(String str) { //사칙연산을 해결할 함수
		StringTokenizer st = new StringTokenizer(str, "/X+-",true);
		Vector<String> sol = new Vector<String>(st.countTokens());
	    while(st.hasMoreTokens()) {
	    	sol.add(st.nextToken());
	    }
	    while(true) {
	    	boolean ch = false;
	    	int b=sol.size();
	    	  while(true) {
	    		b=sol.size();
			    for(int i=0; i<b; ++i) { // 곱학기와 나누기 먼저 계산하기	  
				 if(sol.get(i).equals("X") || sol.get(i).equals("/")) {
					if(sol.get(i).equals("X")) {
					   double num1=Double.parseDouble(sol.get(i-1));
					   double num2=Double.parseDouble(sol.get(i+1));
					   double result = num1*num2;
					   sol.remove(i-1); sol.remove(i-1); sol.remove(i-1);
					   sol.add(i-1,Double.toString(result));
					   ch=true;
					   break;
					   
					}
					else if(sol.get(i).equals("/")) {
						double num1=Double.parseDouble(sol.get(i-1));
						double num2=Double.parseDouble(sol.get(i+1));
						double result = num1/num2;
						sol.remove(i-1); sol.remove(i-1); sol.remove(i-1);
						sol.add(i-1,Double.toString(result));
						ch=true;
						break;
					}
				   }
				 if(i==b-1) {
				   ch=false;
					}
			     }
			   if(ch==false) {
				  break;
	    	    }
	    	  }
			  for(int i=0; i<b;++i) {
				if(sol.get(i).equals("+")) {
					double num1=Double.parseDouble(sol.get(i-1));
					double num2=Double.parseDouble(sol.get(i+1));
					double result = num1+num2;
					 sol.remove(i-1); sol.remove(i-1); sol.remove(i-1);
					 sol.add(i-1,Double.toString(result));
					 break;
				}
				else if(sol.get(i).equals("-")) {
					double num1=Double.parseDouble(sol.get(i-1));
					double num2=Double.parseDouble(sol.get(i+1));
					double result = num1-num2;
					sol.remove(i-1); sol.remove(i-1); sol.remove(i-1);
					sol.add(i-1,Double.toString(result));
					break;
				}
			  }
			  if(sol.size()==1) {
				  break;
			    }
			  }
	    Double retry = Double.parseDouble(sol.get(0));
	    double retr = retry * 10;
	    if(retr%10==0) { //답이 소수점이 없을경우 .0을 제외하고 출력하기
	    	retr /=10;
	    	int res = (int) retr;
	    	sol.add(0,Integer.toString(res));
	    }
		return sol.get(0);
	}
    public Calculator() {
    	setTitle("Calculator");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Container cont = getContentPane();
    	GridLayout grid = new GridLayout(5,4,2,2); //GrindLayout으로 계산기 버튼 부분 설정
    	JPanel pan = new JPanel(new BorderLayout());//Label이 들어갈 부분 BorderLayout으로 설정 
    	JPanel cal = new JPanel(grid);
    	pro.setFont(new Font("Serif",Font.BOLD,30));
    	sol.setFont(new Font("Serif",Font.BOLD,30));
    	pan.add(pro,BorderLayout.NORTH); //문제가 나오는 부분을 위에
    	pan.add(sol,BorderLayout.CENTER); //답이 나오는 부분은 중간에 설정
    	cont.add(pan,BorderLayout.NORTH); // 이 panel을 전체 컨테이너에 North에 설정
        cal.addKeyListener(new MyKeyActionListener());
    	for(int i=0; i<20; ++i) { //button 추가
    		btn[i] = new JButton(buttons[i]);
    		btn[i].addMouseListener(new MyMouseActionListener());
    		btn[i].addKeyListener(new MyKeyActionListener());
    		cal.add(btn[i]);
    		btn[i].setFocusable(true);
        	btn[i].requestFocus();
    	}
    	cont.add(cal, BorderLayout.CENTER);
    	setVisible(true);
    	setSize(500,500);
    }
    class MyMouseActionListener extends MouseAdapter{
    	public void mouseEntered(MouseEvent e) { //마우스가 button에 들어가면 GRAY
    		JButton btn = (JButton)e.getSource();
    		if(btn.getText().equals("1")) { 
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("2")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("3")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("4")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("5")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("6")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("7")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("8")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("9")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("0")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("DEL")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("CE")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("/")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("X")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("+")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("-")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals("=")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    		else if(btn.getText().equals(".")) {
    			btn.setBackground(Color.LIGHT_GRAY);
    		}
    	}
    	public void mouseExited(MouseEvent e) { //빠져나오면 다시 색 돌아옴
    		JButton btn = (JButton)e.getSource();
    		if(btn.getText().equals("1")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("2")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("3")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("4")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("5")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("6")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("7")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("8")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("9")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("0")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("DEL")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("CE")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("/")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("X")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("+")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("-")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals("=")) {
    			btn.setBackground(null);
    		}
    		else if(btn.getText().equals(".")) {
    			btn.setBackground(null);
    		}
    	}
    	
    	public void mousePressed(MouseEvent e) { //마우스 클릭 했을때 숫자 써짐
    		JButton btn = (JButton)e.getSource();
    		if(btn.getText().equals("1")) {	
    			if(str.equals(" ")) {
    				str="1";
    				pro.setText(str);
    			}
    			else{str = str.concat("1");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("2")) {
    			if(str.equals(" ")) {
    				str="2";
    				pro.setText(str);
    			}
    			else{str = str.concat("2");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("3")) {
    			if(str.equals(" ")) {
    				str="3";
    				pro.setText(str);
    			}
    			else{str = str.concat("3");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("4")) {
    			if(str.equals(" ")) {
    				str="4";
    				pro.setText(str);
    			}
    			else{str = str.concat("4");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("5")) {
    			if(str.equals(" ")) {
    				str="5";
    				pro.setText(str);
    			}
    			else{str = str.concat("5");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("6")) {
    			if(str.equals(" ")) {
    				str="6";
    				pro.setText(str);
    			}
    			else{str = str.concat("6");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("7")) {
    			if(str.equals(" ")) {
    				str="7";
    				pro.setText(str);
    			}
    			else{str = str.concat("7");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("8")) {
    			if(str.equals(" ")) {
    				str="8";
    				pro.setText(str);
    			}
    			else{str = str.concat("8");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("9")) {
    			if(str.equals(" ")) {
    				str="9";
    				pro.setText(str);
    			}
    			else{str = str.concat("9");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("0")) {
    			if(str.equals(" ")) {
    				str="0";
    				pro.setText(str);
    			}
    			else{str = str.concat("0");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("+")) {
    			if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat("+");
    				pro.setText(str);
    			}
    			else{
    				str = str.concat("+");
				    pro.setText(str);
				}
    		}
    		else if(btn.getText().equals("-")) {
    			if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat("-");
    				pro.setText(str);
    			}
    			else{str = str.concat("-");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("X")) {
    			if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat("X");
    				pro.setText(str);
    			}
    			else{str = str.concat("X");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("/")) {
    			if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat("/");
    				pro.setText(str);
    			}
    			else{str = str.concat("/");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals(".")) {
    			if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat(".");
    				pro.setText(str);
    			}
    			else{str = str.concat(".");
				pro.setText(str);}
    		}
    		else if(btn.getText().equals("CE")) {
    			str = " ";
    			pro.setText(str);
    			sol.setText(str);
    		}
    		else if(btn.getText().equals("DEL")) {
    			dstr=pro.getText();
    			if(dstr.length()==1) {
    				dstr=" ";
    				str=" ";
    				pro.setText(str);
    			}
    			else {
    				dstr = dstr.substring(0,dstr.length()-1);
    				str=dstr;
    				pro.setText(str);
    			}
    		}
    		else if(btn.getText().equals("=")) {
    			str = solution(str);
    		    sol.setText(str);
    		}
    	}
    }
    class MyKeyActionListener extends KeyAdapter{
    	public void keyReleased(KeyEvent e) {
    		char keychar = e.getKeyChar();
    		if(keychar == '1') {
    			Calculator.this.btn[4].setBackground(null);
    		}
    		else if(keychar == '2') {
    			Calculator.this.btn[5].setBackground(null);
    		}
    		else if(keychar == '3') {
    			Calculator.this.btn[6].setBackground(null);
    		}
    		else if(keychar == 'X') {
    			Calculator.this.btn[7].setBackground(null);
    		}
    		else if(keychar == '4') {
    			Calculator.this.btn[8].setBackground(null);
    		}
    		else if(keychar == '5') {
    			Calculator.this.btn[9].setBackground(null);
    		}
    		else if(keychar == '6') {
    			Calculator.this.btn[10].setBackground(null);
    		}
    		else if(keychar == '+') {
    			Calculator.this.btn[11].setBackground(null);
    		}
    		else if(keychar == '7') {
    			Calculator.this.btn[12].setBackground(null);
    		}
    		else if(keychar == '8') {
    			Calculator.this.btn[13].setBackground(null);
    		}
    		else if(keychar == '9') {
    			Calculator.this.btn[14].setBackground(null);
    		}
    		else if(keychar == '-') {
    			Calculator.this.btn[15].setBackground(null);
    		}
    		else if(keychar == '0') {
    			Calculator.this.btn[17].setBackground(null);
    		}
    		else if(keychar == '.') {
    			Calculator.this.btn[18].setBackground(null);
    		}
    		else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
    			Calculator.this.btn[19].setBackground(null);
    		}
    		else if(keychar == '/') {
    			Calculator.this.btn[3].setBackground(null);
    		}
    	}
    	
		public void keyPressed(KeyEvent e) { //키보드 입력했을때 숫자써짐
			char keychar = e.getKeyChar();
			int keycode = e.getKeyCode();
			if(keychar == '1') {
				Calculator.this.btn[4].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="1";
    				pro.setText(str);
    			}
				else{str = str.concat("1");
				pro.setText(str);}
			}
			else if(keychar =='2') {
				Calculator.this.btn[5].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="2";
    				pro.setText(str);
    			}
				else{str = str.concat("2");
				pro.setText(str);}
			}
			else if(keychar =='3') {
				Calculator.this.btn[6].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="3";
    				pro.setText(str);
    			}
				else{str = str.concat("3");
				pro.setText(str);}
			}
			else if(keychar =='4') {
				Calculator.this.btn[8].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="4";
    				pro.setText(str);
    			}
				else{str = str.concat("4");
				pro.setText(str);}
			}
			else if(keychar =='5') {
				Calculator.this.btn[9].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="5";
    				pro.setText(str);
    			}
				else{str = str.concat("5");
				pro.setText(str);}
			}
			else if(keychar =='6') {
				Calculator.this.btn[10].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="6";
    				pro.setText(str);
    			}
				else{str = str.concat("6");
				pro.setText(str);}
			}
			else if(keychar =='7') {
				Calculator.this.btn[12].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="7";
    				pro.setText(str);
    			}
				else{str = str.concat("7");
				pro.setText(str);}
			}
			else if(keychar =='8') {
				Calculator.this.btn[13].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="8";
    				pro.setText(str);
    			}
				else{str = str.concat("8");
				pro.setText(str);}
			}
			else if(keychar =='9') {
				Calculator.this.btn[14].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="9";
    				pro.setText(str);
    			}
				else{str = str.concat("9");
				pro.setText(str);}
			}
			else if(keychar =='0') {
				Calculator.this.btn[17].setBackground(Color.gray);
				if(str.equals(" ")) {
    				str="0";
    				pro.setText(str);
    			}
				else{str = str.concat("0");
				pro.setText(str);}
			}
			else if(keychar =='+') {
				Calculator.this.btn[11].setBackground(Color.gray);
				if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat("+");
    				pro.setText(str);
    			}
				else{str = str.concat("+");
				pro.setText(str);}
			}
			else if(keychar =='-') {
				Calculator.this.btn[15].setBackground(Color.gray);
				if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat("-");
    				pro.setText(str);
    			}
				else{str = str.concat("-");
				pro.setText(str);}
			}
			else if(keychar =='X') {
				Calculator.this.btn[7].setBackground(Color.gray);
				if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat("X");
    				pro.setText(str);
    			}
				else{str = str.concat("X");
				pro.setText(str);}
			}
			else if(keychar =='/') {
				Calculator.this.btn[3].setBackground(Color.gray);
				if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat("/");
    				pro.setText(str);
    			}
				else{str = str.concat("/");
				pro.setText(str);}
			}
			else if(keychar =='.') {
				Calculator.this.btn[18].setBackground(Color.gray);
				if(sol.getText() != " ") {
    				str=sol.getText();
    				sol.setText(" ");
    				str = str.concat(".");
    				pro.setText(str);
    			}
				else{str = str.concat(".");
				pro.setText(str);}
			}
			else if(keycode == KeyEvent.VK_ENTER) {
				Calculator.this.btn[19].setBackground(Color.gray);
				str = solution(str);
    		    sol.setText(str);
			}
		}
	}
   	
	public static void main(String[] args) {
		new Calculator();

	}

}
