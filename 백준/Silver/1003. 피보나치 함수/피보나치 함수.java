import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				System.out.println("1 0");
				continue;
			}
			if (n == 1) {
				System.out.println("0 1");
				continue;
			}
			if (n == 2) {
				System.out.println("1 1");
				continue;
			}
			int[] series = { 0, 1, 1 };
			for (int j = 3; j <= n; j++) {
				int temp = series[1] + series[2];
				series[0] = series[1];
				series[1] = series[2];
				series[2] = temp;
			}
			System.out.println(series[1] + " " + series[2]);

		}

	}

}