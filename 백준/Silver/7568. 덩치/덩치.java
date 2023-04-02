import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] profile = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			profile[i][0] = Integer.parseInt(st.nextToken());
			profile[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] rank = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (profile[i][0] < profile[j][0] && profile[i][1] < profile[j][1]) {
					rank[i]++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			sb.append(rank[i]+1 + " ");
		}
		System.out.println(sb.append(rank[n - 1]+1).toString());

	}

}
