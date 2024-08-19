import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K, R, U, X;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        char[] command = br.readLine().toCharArray();
        for (char c : command) {
            switch (c) {
                case 'R' -> R++;
                case 'U' -> U++;
                case 'X' -> X++;
            }
        }

        K = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int m = Math.min(Math.min(x, y), X);
            if (x - m <= R && y - m <= U) answer++;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

}
