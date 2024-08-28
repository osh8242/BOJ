import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int S = Integer.parseInt(br.readLine());
        sb.append(S).append(":").append("\n");
        for (int i = 2; i <= S / 2 + 1; i++) {
            if (S % (2 * i - 1) == 0 || (S - i) % (2 * i - 1) == 0) {
                append(sb, i, i-1);
            }
            if (S % i == 0) {
                append(sb, i, i);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void append(StringBuilder sb, int i, int j) {
        sb.append(i).append(",").append(j).append("\n");
    }
}
