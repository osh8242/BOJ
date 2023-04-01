import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			int score = 0;
			String[] rights = br.readLine().split("X");
			for (int i = 0; i < rights.length; i++) {
				score += rights[i].length() * (rights[i].length() + 1) / 2;
			}
			System.out.println(score);
		}

	}

}