import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		for (int i = 1 ; i <= n ; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp!=0) {
				st.push(temp);
			} else {
				st.pop();
			}
		}
		long sum = 0;
		for (int i : st) {
			sum += i;
		}
		System.out.println(sum);		
	}
}