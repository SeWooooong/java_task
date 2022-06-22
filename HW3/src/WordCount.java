import java.io.*;
import java.util.*;

public class WordCount {
	public static String check(String str) { //특수문자 제거 하기 위한 메소드
	   StringTokenizer st = new StringTokenizer(str," ,.:;!?[]()'");
	   return st.nextToken();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("박세웅/컴퓨터공학과/12191604");
			System.out.print("Input file name: "); //입력 파일 
			String filein = scanner.next();
			System.out.print("Onput file name: "); //출력 파일
			String fileout = scanner.next();
			FileReader fin = new FileReader(filein);
			Scanner sc = new Scanner(fin);
			
			HashMap<String, Integer> map = new HashMap<String, Integer>(); //문자와 나온 횟수를 가지기 위한 HashMap
			
			String s = sc.next();
			s=check(s);
			s=s.toLowerCase(); 
			map.put(s, 1);
			
			String a="";
         	while(sc.hasNext()) {
         	    s = sc.next();
    			s=check(s);
    			s=s.toLowerCase();
			    for(String key : map.keySet()) { //문자가 같으면 value값을 하나 올린다.
			    	if(key.equals(s)) {
			    		a=s;
			    		map.put(s, map.get(key)+1);
			    	}
			    }
			    if(a.equals(s)) { // 같으면 put을 안하기위해 continue를 사용한다.
			    	continue;
			    }
			    map.put(s, 1);;
			}
         	
         	FileWriter fout = new FileWriter(fileout);
         	
             for(String key : map.keySet()) { //조건에 맞게 출력
            	 fout.write(key + "  " + map.get(key) + "\n");
             }
         	
         	System.out.println("Word count finished");
         	fin.close();  
         	fout.close(); 
         	sc.close();
         	scanner.close();
		}
        catch(IOException e) {
        	System.out.println("IOException");
        }
		
	}

}
