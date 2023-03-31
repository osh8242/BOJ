import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 0) {
			System.out.println("1");
			return;
		}
		long f = 1;
		for (int i = 1; i <= n; i++) {
			f *= i;
		}
		System.out.println(f);

	}

}