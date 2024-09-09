import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static String A, B;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        int diff = B.length() - A.length();
        if (diff > 0) {
            sb.append(B, 0, diff);
            B = B.substring(diff);
        } else if (diff < 0) {
            sb.append(A, 0, -diff);
            A = A.substring(-diff);
        }

        for (int i = 0; i < A.length(); i++) {
            sb.append((A.charAt(i) - '0') + (B.charAt(i) - '0'));
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
