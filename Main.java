import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            sb.append(
                            isPossible(Integer.parseInt(br.readLine())) ?
                                    "YES" : "NO")
                    .append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static boolean isPossible(int k) {
        if (X % k == 0 && (Y - 2) % k == 0) return true;
        if ((X - 1) % k == 0 && (Y - 1) % k == 0) return true;
        return (X - 2) % k == 0 && Y % k == 0;
    }
}
