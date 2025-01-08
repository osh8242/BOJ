import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (n-- > 0) {
            String votes = br.readLine();
            int count = 0;
            for (char c : votes.toCharArray()) {
                if (c == 'O') count++;
            }
            if (2 * count > m) answer++;
        }
        System.out.println(answer);
    }
    
}

