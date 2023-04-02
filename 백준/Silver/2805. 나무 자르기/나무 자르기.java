import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static long[] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		trees = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(trees);
		long min = - 1;
		long max = trees[n - 1] + 1;
		long h = (max + min) / 2;
		while (max - min > 1) {
			if (getTree(h) > m) {
				min = h;
				h = (max + min) / 2;
			} else if (getTree(h) < m) {
				max = h;
				h = (max + min) / 2;
			} else {
				break;
			}
		}
		System.out.println(h);

	}

	public static long getTree(long h) {
		long count = 0;
		for (long tree : trees) {
			if (tree <= h) {
				continue;
			}
			count += tree - h;
		}
		return count;
	}

}
