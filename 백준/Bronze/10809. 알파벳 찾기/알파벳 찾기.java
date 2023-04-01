import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alphabet = new int[26];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] -= 1;
		}
		String word = br.readLine();
		for (int i = 0; i < word.length(); i++) {
			if (alphabet[word.charAt(i) - 'a'] == -1) {
				alphabet[word.charAt(i) - 'a'] = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int index : alphabet) {
			sb.append(index).append(" ");
		}
		System.out.println(sb.toString());

	}
}