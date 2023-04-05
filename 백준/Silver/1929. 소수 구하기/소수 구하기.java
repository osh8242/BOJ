import java.io.*;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		for (int i = start ; i <= end ; i++) {
			if(isPrime(i)) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static boolean isPrime(int num) {
		if(num==1) {return false;}
		for(int i = 2 ; i<=Math.sqrt(num); i++) {
			if(num%i==0) {return false;}
		}
		return true;
	}

}