import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int m, n, index, total, answer;
    static boolean[] isYellow;
    static boolean direction;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            index = -1;
            total = 0;
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            isYellow = new boolean[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) {
                    isYellow[i] = true;
                    total++;
                } else if (x == 2) {
                    direction = true;
                    index = i;
                } else if (x == 3) {
                    direction = false;
                    index = i;
                }
            }

            goStep(index, direction);
            int residue = n / m;
            answer += residue * total;
            n %= m;
            if (residue % 2 == 0) direction = !direction;
            index = direction ? 0 : m - 1;
            goStep(index, direction);
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void goStep(int index, boolean direction) {
        int diff = direction ? 1 : -1;
        for (int i = index + diff; n > 0 && i >= 0 && i < m; i += diff) {
            if (isYellow[i]) answer++;
            n--;
        }
    }

}
