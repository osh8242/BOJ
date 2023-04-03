import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		long answer = 0;
		for (int i = 0; i < n; i++) {
			answer += (ch[i] - 96) * (long) (Math.pow(31, i));
			if (answer > 1234567891) {
				answer %= 1234567891;
			}
		}
		System.out.println(answer);
	}

}
