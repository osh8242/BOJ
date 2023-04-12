import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] list = new int[] {1,1,2,2,2,8};
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for (int i = 0 ; i < 6 ; i++) {
			list[i] -= Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i <list.length ; i++) {
			sb.append(list[i]+" ");
		}
		System.out.println(sb.toString());

	} // Main(){}	


} //Class{}

