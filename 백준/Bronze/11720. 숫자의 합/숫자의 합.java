import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		String numStr = br.readLine();
		for (int i = 0; i < numStr.length(); i++) {
			sum += Character.getNumericValue(numStr.charAt(i));
		}
		System.out.println(sum);
	}

}
