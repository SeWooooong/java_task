import java.io.*;
import java.util.*;

public class WordCount {
	public static String check(String str) { //Ư������ ���� �ϱ� ���� �޼ҵ�
	   StringTokenizer st = new StringTokenizer(str," ,.:;!?[]()'");
	   return st.nextToken();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("�ڼ���/��ǻ�Ͱ��а�/12191604");
			System.out.print("Input file name: "); //�Է� ���� 
			String filein = scanner.next();
			System.out.print("Onput file name: "); //��� ����
			String fileout = scanner.next();
			FileReader fin = new FileReader(filein);
			Scanner sc = new Scanner(fin);
			
			HashMap<String, Integer> map = new HashMap<String, Integer>(); //���ڿ� ���� Ƚ���� ������ ���� HashMap
			
			String s = sc.next();
			s=check(s);
			s=s.toLowerCase(); 
			map.put(s, 1);
			
			String a="";
         	while(sc.hasNext()) {
         	    s = sc.next();
    			s=check(s);
    			s=s.toLowerCase();
			    for(String key : map.keySet()) { //���ڰ� ������ value���� �ϳ� �ø���.
			    	if(key.equals(s)) {
			    		a=s;
			    		map.put(s, map.get(key)+1);
			    	}
			    }
			    if(a.equals(s)) { // ������ put�� ���ϱ����� continue�� ����Ѵ�.
			    	continue;
			    }
			    map.put(s, 1);;
			}
         	
         	FileWriter fout = new FileWriter(fileout);
         	
             for(String key : map.keySet()) { //���ǿ� �°� ���
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
