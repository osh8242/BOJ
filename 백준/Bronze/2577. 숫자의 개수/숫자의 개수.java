import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		String test = Integer.toString(a * b * c);
		int[] count = new int[10];
		for (int i = 0; i < test.length(); i++) {
			count[Character.getNumericValue(test.charAt(i))]++;
		}
		for (int num : count) {
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());

	}
}