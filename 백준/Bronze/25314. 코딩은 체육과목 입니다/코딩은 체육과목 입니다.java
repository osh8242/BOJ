import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 1 ; i <= n/4 ; i++) {
			sb.append("long ");
		}
		sb.append("int").append('\n');
		System.out.println(sb);
	}

}
