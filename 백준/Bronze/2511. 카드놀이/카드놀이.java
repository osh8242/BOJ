import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[10];
		int[] b = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int sumA = 0;
		int sumB = 0;
		Boolean isLastWinA = null;

		for (int i = 0; i < 10; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			if (a[i] > b[i]) {
				sumA += 3;
				isLastWinA = true;
			} else if (a[i] < b[i]) {
				sumB += 3;
				isLastWinA = false;
			} else {
				sumA++;
				sumB++;
			}
		}
		System.out.println(sumA + " " + sumB + "\n"
				+ (sumA > sumB ? "A" : sumA < sumB ? "B" : isLastWinA == null ? "D" : isLastWinA ? "A" : "B"));
	}
}