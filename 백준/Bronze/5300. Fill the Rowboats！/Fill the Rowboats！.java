import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(" ");
            if (i % 6 == 0) sb.append("Go! ");
        }
        if (N % 6 != 0) sb.append("Go! ");
        System.out.println(sb);
    }
}