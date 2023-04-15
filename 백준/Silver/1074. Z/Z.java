import java.io.*;
import java.util.*;

public class Main {
	
	public static int count;
	public static int posR;
	public static int posC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		posR = Integer.parseInt(st.nextToken())+1;
		posC = Integer.parseInt(st.nextToken())+1;
		count = 0;
		getCount(n, posR, posC);
		System.out.println(count);
	}
	
	public static void getCount(int n, int r, int c) {
		if(n>=1) {
			if(r <= Math.pow(2, n-1) && c > Math.pow(2, n-1)) {
				count += Math.pow(4, n-1);
				posC -= Math.pow(2, n-1);
			} else if(r > Math.pow(2, n-1) && c <= Math.pow(2, n-1)) {
				count += 2*Math.pow(4, n-1);
				posR -= Math.pow(2, n-1);
			} else if(r > Math.pow(2, n-1) && c > Math.pow(2, n-1)) {
				count += 3*Math.pow(4, n-1);
				posR -= Math.pow(2, n-1);
				posC -= Math.pow(2, n-1);
			}
			getCount(n-1, posR, posC);
		}
	}

}
