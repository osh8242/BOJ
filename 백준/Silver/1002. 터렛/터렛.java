import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

			if (d > r1 + r2) {
				System.out.println("0");
			} else if (d == r1 + r2) {
				System.out.println("1");
			} else if (d < r1 + r2 && d + Math.min(r1, r2) > Math.max(r1, r2)) {
				System.out.println("2");
			} else if (d == 0 && r1 == r2) {
				System.out.println("-1");
			} else if (d + Math.min(r1, r2) == Math.max(r1, r2)) {
				System.out.println("1");
			} else if (d + Math.min(r1, r2) < Math.max(r1, r2)) {
				System.out.println("0");
			} else {
				System.out.println("0");
			}

		}

	}

}
