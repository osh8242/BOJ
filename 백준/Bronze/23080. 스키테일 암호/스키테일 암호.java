import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int idx = 0;
        while (idx < line.length()) {
            sb.append(line.charAt(idx));
            idx += K;
        }
        System.out.println(sb);
    }
}
