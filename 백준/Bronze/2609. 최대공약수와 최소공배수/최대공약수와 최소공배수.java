import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = getMaxCommitment(a, b);
		System.out.println(c);
		System.out.println(a * b / c);

	}

	public static int getMaxCommitment(int a, int b) {
		int answer = 1;
		for (int i = 2; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				answer = i;
			}
		}
		return answer;
	}

}