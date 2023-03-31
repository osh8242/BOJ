import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] list = new int[30];
		for (int i = 0; i < 28; i++) {
			int num = Integer.parseInt(br.readLine());
			list[num - 1] = 1;
		}
		int count = 0;
		for (int i = 0; i < 30; i++) {
			if (list[i] != 1) {
				System.out.println(i + 1);
				count++;
				if (count == 2) {
					break;
				}
			}
		}

	}

}