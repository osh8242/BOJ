import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		char[] aa = new char[a.length()];
		char[] bb = new char[a.length()];
		for (int i = 0; i < a.length(); i++) {
			aa[a.length() - i - 1] = a.charAt(i);
			bb[b.length() - i - 1] = b.charAt(i);
		}
		a = new String(aa);
		b = new String(bb);

		if (Integer.valueOf(a) > Integer.valueOf(b)) {
			System.out.println(Integer.valueOf(a));
		} else {
			System.out.println(Integer.valueOf(b));
		}
	}
}