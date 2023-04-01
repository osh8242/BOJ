import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int residue = 0;
		for (int i = 0; i < 5; i++) {
			int temp = Integer.parseInt(st.nextToken());
			residue += temp * temp % 10;
		}
		System.out.println(residue % 10);

	}

}