import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] pocket = new int [n];
		for (int line = 1 ; line <= m ; line++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ballNum = Integer.parseInt(st.nextToken());
			for (int i = start-1 ; i <= end-1 ; i++) {
				pocket[i] = ballNum;
			}
		}
		for (int i = 0 ; i < n ;i++) {
			sb.append(pocket[i]+" ");
		}		
		System.out.println(sb.toString());
	}

}
