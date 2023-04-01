import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (isPrime(num)) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}
		for (int divisor = 2; divisor <= Math.sqrt(num); divisor++) {
			if (num % divisor == 0) {
				return false;
			}
		}
		return true;
	}

}