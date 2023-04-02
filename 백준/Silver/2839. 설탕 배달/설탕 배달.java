import java.io.*;

public class Main {

	public static char[] documents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < 5; i++) {
			if ((n - 3 * i) % 5 == 0 && (n - 3 * i) >= 0) {
				System.out.println((n - 3 * i) / 5 + i);
				return;
			}
		}
		System.out.println("-1");
	}

}