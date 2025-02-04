import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int half = N / 2;
        for (int i = 0; i < half; i++) {
            sb.append('a');
        }
        sb.append(sb);
        if (N % 2 != 0) sb.append('a');
        System.out.println(sb);
    }
}
