import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 0) {
            sb.append("I LOVE CBNU");
        } else {
            for (int i = 0; i < N; i++) sb.append("*");
            sb.append("\n");
            for (int i = 0; i < N / 2; i++) sb.append(" ");
            sb.append("*\n");
            for (int i = 1; i <= N / 2; i++) {
                for (int j = 0; j < N / 2 - i; j++) sb.append(" ");
                sb.append("*");
                for (int j = 0; j < 2 * i - 1; j++) sb.append(" ");
                sb.append("*\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
