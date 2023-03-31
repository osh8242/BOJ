import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ch = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] <= 90) {
				ch[i] += 32;
			} else {
				ch[i] -= 32;
			}
		}
		System.out.println(new String(ch));

	}

}