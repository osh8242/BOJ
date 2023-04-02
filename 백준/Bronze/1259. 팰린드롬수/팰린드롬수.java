import java.io.*;

public class Main {

	public static char[] documents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			boolean isPalin = true;
			String str = Integer.toString(n);
			for (int i = 0; i <= str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					System.out.println("no");
					isPalin = false;
					break;
				}
			}
			if (isPalin) {
				System.out.println("yes");
			}

		}
		;

	}

}