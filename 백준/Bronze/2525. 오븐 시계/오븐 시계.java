import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		
		h += time/60;
		m += time%60;
		
		if(m>=60) {
			h += m/60;
			m %= 60;
		}
		while(h>=24) {
			h -= 24;
		}
		System.out.println(h+" "+m);
	}

}
