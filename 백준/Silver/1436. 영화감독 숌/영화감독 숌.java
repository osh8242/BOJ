import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int answer = 666;
		while (count < n) {
			char[] temp = Integer.toString(answer).toCharArray();
			for (int i = 0; i < temp.length - 2; i++) {
				if (temp[i] == '6' && temp[i + 1] == '6' && temp[i + 2] == '6') {
					count++;
					break;
				}
			}
			answer++;
		}
		System.out.println(answer - 1);

	}

}