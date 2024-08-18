import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, K;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            readRowZeroCount(br.readLine());
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    static void readRowZeroCount(String line) throws IOException {
        boolean isZero = false;
        int zeroCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '0') {
                if (!isZero) isZero = true;
                zeroCount++;
            } else if (isZero) {
                isZero = false;
                addCount(zeroCount);
                zeroCount = 0;
            }
        }
        if (isZero) addCount(zeroCount);
    }

    static void addCount(int zeroCount) {
        if (zeroCount >= K) answer += zeroCount - K + 1;
    }

}
