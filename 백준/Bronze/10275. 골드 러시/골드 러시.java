import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            int requiredPieces = 0;
            for (int i = 0; i <= n; i++) {
                boolean bitA = ((a >> i) & 1) == 1;
                boolean bitB = ((b >> i) & 1) == 1;
                if (bitA && bitB) {
                    requiredPieces += 2;
                } else if (bitA || bitB) {
                    requiredPieces += 1;
                }
            }
            int days = requiredPieces - 1;
            sb.append(days).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
