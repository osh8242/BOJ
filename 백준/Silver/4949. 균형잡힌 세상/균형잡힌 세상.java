import java.io.*;
import java.util.Stack;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		while (true) {
			String str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			for (int i = 0 ; i < str.length() ; i++) {
				switch(str.charAt(i)) {
					case'(':{
						st.add('('); break;
					}
					case')':{						
						if(st.size()>0 && st.get(st.size()-1)=='(') {
							st.pop();
						} else {st.add(')');}
						break;
					}
					case'[':{
						st.add('['); break;
					}
					case']':{						
						if(st.size()>0 && st.get(st.size()-1)=='[') {
							st.pop();
						} else {st.add(']');}
						break;
					}
				}
			}
			if(st.size()==0) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
			st.clear();
		}
		System.out.println(sb.toString());
	}
}