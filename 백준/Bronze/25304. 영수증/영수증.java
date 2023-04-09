import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int PRICE = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		for (int i = 1 ; i <= N ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			sum += (long)p*(long)n;
		}
		System.out.println(PRICE==sum?"Yes":"No");

	} // Main(){}	


} //Class{}