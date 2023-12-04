import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while(!(line = br.readLine()).equals("#")) {
			StringTokenizer st = new StringTokenizer(line);
			char ch = st.nextToken().charAt(0);
			sb.append(ch).append(" ");
			int count = 0;
			while(st.hasMoreTokens()) {
				String temp = st.nextToken().toLowerCase();
				for(int i = 0 ; i < temp.length() ; i++) {
					if(ch == temp.charAt(i)) count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}