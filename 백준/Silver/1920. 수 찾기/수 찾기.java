import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static char[] documents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] a = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());

		long[] nums = new long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(a);
		int[] count = new int[m];
		for (int i = 0; i < m; i++) {
			if (isExist(a, nums[i])) {
				count[i] = 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(count[i] + "\n");
		}
		System.out.println(sb.toString());

	}

	public static boolean isExist(long[] a, long num) {
		int min = -1;
		int max = a.length;
		int p = (max + min) / 2;
		while (max - min > 1) {
			if (a[p] > num) {
				max = p;
				p = (max + min) / 2;
				continue;
			} else if (a[p] < num) {
				min = p;
				p = (max + min) / 2;
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

}
