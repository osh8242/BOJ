import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		for (int i = 0; i < board.length; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int min = 64;
		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				int count = Math.min(checkCount(i, j, 'B'), checkCount(i, j, 'W'));
				if (min > count) {
					min = count;
				}
			}
		}
		System.out.println(min);

	}

	public static int checkCount(int i, int j, char ch) {
		int count = 0;
		for (int y = i; y < i + 8; y++) {
			for (int x = j; x < j + 8; x++) {
				if (board[y][x] != ch) {
					count++;
				}
				ch = (ch == 'B') ? 'W' : 'B';
			}
			ch = (ch == 'B') ? 'W' : 'B';
		}

		return count;
	}
}
