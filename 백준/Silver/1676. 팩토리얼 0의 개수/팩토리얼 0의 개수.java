import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int count2 = 0;
		int count5 = 0;
		for (int i = 2 ; i <= num ; i++) {
			count2 += getCount2(i);
			count5 += getCount5(i);
		}
		System.out.println(Math.min(count2, count5));
		
	}
	
	public static int getCount2 (int num) {
		int answer = 0;
		while (num%2 ==0) {
			answer++;
			num /= 2;
		}
		return answer;
	}
	
	public static int getCount5 (int num) {
		int answer = 0;
		while (num%5 ==0) {
			answer++;
			num /= 5;
		}
		return answer;
	}

}
