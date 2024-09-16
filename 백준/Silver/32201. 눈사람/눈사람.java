import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb;
    static int N;
    static int maxRankUp = 0;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder(2 * N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int rank = 1; rank <= N; rank++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, rank);
        }

        st = new StringTokenizer(br.readLine());
        for (int rank = 1; rank <= N; rank++) {
            int num = Integer.parseInt(st.nextToken());
            int change = map.get(num) - rank;
            if (change == maxRankUp) sb.append(num).append(" ");
            else if (change > maxRankUp) {
                maxRankUp = change;
                sb.setLength(0);
                sb.append(num).append(" ");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }

}

