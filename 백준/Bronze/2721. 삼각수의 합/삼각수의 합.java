import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer
                    = (((n * (n + 1)) / 2) * ((n * (n + 1)) / 2) // n^3
                    + n * (n + 1) / 2 * (2 * n + 1) // 3n^2
                    + n * (n + 1)) // 2n
                    / 2;
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}