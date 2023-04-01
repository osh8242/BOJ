import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (m >= 45) {
			m -= 45;
		} else {
			m += 15;
			h -= 1;
		}
		if (h < 0) {
			h += 24;
		}
		System.out.printf("%d %d", h, m);

	}
}