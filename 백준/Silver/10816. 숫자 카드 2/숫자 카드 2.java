import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		HashMap<Integer, Integer> hm = new HashMap<>();		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < n ; i++) {						
			int temp = Integer.parseInt(st.nextToken());
			if(!hm.containsKey(temp)) {
				hm.put(temp, 1);
			} else {
				hm.put(temp, hm.get(temp)+1);
			}
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < m ; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(hm.containsKey(temp)) {
				sb.append(hm.get(temp)+" ");
			} else {
				sb.append(0 + " ");
			}			
		}
		System.out.println(sb.toString());
	}
}