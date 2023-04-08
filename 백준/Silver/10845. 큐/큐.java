import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		int last = 0;
		for(int i = 0 ; i < n ; i++) {
			String temp = br.readLine();
			switch(temp.charAt(0)) {
				case'p':{
					switch(temp.charAt(1)) {
						case'u':{
							int pushedNum = Integer.parseInt(temp.substring(temp.indexOf(" ")+1));
							q.offer(pushedNum);
							last = pushedNum;
							break;
						}
						case'o':{
							if(!q.isEmpty()) {						
								sb.append(q.poll()+"\n");
							} else {
								sb.append(-1+"\n");
							}							
						}
					}
					break;
				}
				case's':{
					sb.append(q.size()+"\n");
					break;
				}
				case'e':{
					if(q.isEmpty()) {
						sb.append(1+"\n");
					} else {
						sb.append(0+"\n");
					}
					break;
				}
				case'f':{
					if(!q.isEmpty()) {
						sb.append(q.element()+"\n");
					} else {
						sb.append(-1+"\n");
					}
					break;
				}
				case'b':{
					if(!q.isEmpty()) {						
						sb.append(last+"\n");
					} else {
						sb.append(-1+"\n");
					}
					break;
				}			
			}			
		}
		System.out.print(sb.toString());
	}

}
