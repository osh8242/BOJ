import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static long[] lans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		lans = new long[k];
		for (int i = 0; i < k; i++) {
			lans[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(lans);
		long min = 1;
		long max = lans[k - 1]+1;
		long unit = (max + min) / 2;

		while (max - min > 1) {
			if (getLans(unit) < n) {
				max = unit;
				unit = (max + min) / 2;
			} else {
				min = unit;
				unit = (max + min) / 2;
			}
		}

		System.out.println(min);

	}

	public static long getLans(long unit) {
		long gen = 0;
		for (long lan : lans) {
			gen += lan / unit;
		}
		return gen;
	}
}
