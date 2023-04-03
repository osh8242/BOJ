import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		long answer = 0;
		for (int i = 0; i < n; i++) {
			answer += (ch[i] - 96) * exp(i);
			if (answer > 1234567891) {
				answer %= 1234567891;
			}
		}
		System.out.println(answer);
	}

	public static long exp(int i) {
		long answer = 1;
		for (int n = 0; n < i; n++) {
			answer *= 31;
			if (answer > 1234567891) {
				answer %= 1234567891;
			}
		}
		return answer;
	}

}
