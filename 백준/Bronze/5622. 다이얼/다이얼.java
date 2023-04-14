import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		for (int i = 0 ; i <str.length() ; i++) {
			sum += getSecond(str.charAt(i));			
		}
		System.out.println(sum+str.length());
	}
	
	public static int getSecond(char ch) {
		if ( ch < 'P') {
			return (ch - 65)/3 +2;
		} else if (ch < 'T') {
			return 7;
		} else if ( ch < 'W') {
			return 8;
		} else return 9;
		
	}

}
