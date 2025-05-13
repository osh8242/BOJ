import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int sum = 0;
            for (char c : line.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    sum += c - 'A' + 1;
                }
            }
            if (sum == 100) {
                sb.append("PERFECT LIFE");
            } else {
                sb.append(sum);
            }
            if (i < N - 1) sb.append('\n');
        }
        
        System.out.print(sb);
    }
}
