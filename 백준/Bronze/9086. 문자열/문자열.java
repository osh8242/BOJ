import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			String temp = br.readLine();
			bw.append(temp.charAt(0));
			bw.append(temp.charAt(temp.length() - 1));
			bw.flush();
			bw.newLine();
		}
		bw.close();
	}

}