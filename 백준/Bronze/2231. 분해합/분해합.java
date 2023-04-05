import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int length = n.length();
		int num = Integer.parseInt(n);

		for (int i = Math.max(num-length*9,1) ; i <= num ; i++) {
			String temp = Integer.toString(i);
			int sum = i;
			for (int j = 0 ; j < temp.length() ; j++) {
				sum += Character.getNumericValue(temp.charAt(j));
			}
			if (sum == num) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
		return;		
	}	
}