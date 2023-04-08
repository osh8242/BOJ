import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1 ; i <= t ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int floor = n%h==0?h:n%h;
			int room = n%h==0?n/h:n/h+1;
			if(room < 10) {
				sb.append(floor+"0"+room+"\n");
			} else {
				sb.append(floor+""+room+"\n");
			}			
		}
		System.out.println(sb.toString());		
	}
}