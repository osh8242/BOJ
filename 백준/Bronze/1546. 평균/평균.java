import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sum = 0;
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int score = Integer.parseInt(st.nextToken());
			sum += score;
			if (max < score) {
				max = score;
			}
		}
		System.out.println((sum / max) * 100 / n);

	}

}