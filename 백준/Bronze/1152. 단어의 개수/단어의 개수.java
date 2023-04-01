import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if (str.equals(" ")) {
			System.out.println("0");
		} else {
			System.out.println(str.trim().split(" ").length);
		}
	}

}