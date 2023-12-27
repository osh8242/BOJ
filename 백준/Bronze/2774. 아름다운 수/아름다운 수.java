import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			String line = br.readLine();
			Set<Character> set = new HashSet<Character>();
			for(int i = 0 ; i < line.length() ; i++) {
				set.add(line.charAt(i));
			}
			sb.append(set.size()).append("\n");
		}
		System.out.println(sb);

	}

}
