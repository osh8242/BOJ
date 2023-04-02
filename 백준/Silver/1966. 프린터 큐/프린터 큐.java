import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static char[] documents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			documents = br.readLine().replaceAll(" ", "").toCharArray();

			char importance = documents[index];
			if (importance == '9' || n == 1) {
				System.out.println(countImp(importance, 0, index));
				continue;
			}
			int pick = 0;
			int count = 0;

			for (char inspect = '9'; inspect > importance; inspect--) {
				int start = pick;
				for (int i = start; i < n; i++) {
					if (documents[i] == inspect) {
						pick = i;
						count++;
					}
				}
				for (int i = 0; i < start; i++) {
					if (documents[i] == inspect) {
						pick = i;
						count++;
					}
				}
			}

			if (pick <= index) {
				count += countImp(importance, pick, index);
			} else {
				count += countImp(importance, pick, n - 1);
				count += countImp(importance, 0, index);
			}
			System.out.println(count);

		}

	}

	public static int countImp(char importance, int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			if (documents[i] == importance) {
				count++;
			}
		}
		return count;
	}

}
