import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
            String[] parts = br.readLine().split(" ");
            long n = Long.parseLong(parts[0]);
            long m = Long.parseLong(parts[1]);
            long count = m - n + 1;
            long sum = count * (n + m) / 2;
            
            sb.append("Scenario #").append(tc).append(":\n");
            sb.append(sum).append("\n");
            if (tc != T) sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
