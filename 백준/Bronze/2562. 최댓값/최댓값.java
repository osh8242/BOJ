import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int index = 1;
		int max = Integer.parseInt(br.readLine());

		for (int i = 2; i <= 9; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (max < temp) {
				max = temp;
				index = i;
			}
		}
		System.out.println(max);
		System.out.println(index);

	}

}