import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static char[] documents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (words[i].equals(words[j]) || words[j].equals("")) {
					words[j] = "";
					continue;
				}
				if (!words[i].equals(compareString(words[i], words[j]))) {
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (words[i].equals("")) {
				continue;
			}
			sb.append(words[i] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static String compareString(String stri, String strj) {
		if (stri.length() != strj.length()) {
			return stri.length() > strj.length() ? strj : stri;
		}
		for (int i = 0; i < stri.length(); i++) {
			if (stri.charAt(i) != strj.charAt(i)) {
				return stri.charAt(i) > strj.charAt(i) ? strj : stri;
			}
		}
		return stri;
	}

}
