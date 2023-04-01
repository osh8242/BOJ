import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.println("1");
		} else {
			long count = 1;
			int shell = 1;
			while (count < n) {
				count += shell * 6;
				if (count >= n) {
					System.out.println(shell + 1);
				}
				shell++;
			}
		}

	}
}
