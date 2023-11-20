import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] TIME = {24, 60, 60};
    static int[] now, start;

    public static void main(String[] args) throws IOException {
        now = new int[3];
        start = new int[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        for (int i = 0; i < 3; i++) now[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), ":");
        for (int i = 0; i < 3; i++) start[i] = Integer.parseInt(st.nextToken());
        System.out.println(getLeftTime());
    }

    static String getLeftTime() {
        int[] time = new int[3];
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            time[i] = start[i] - now[i];
            if (time[i] < 0) {
                if (i > 0) start[i - 1]--;
                time[i] += TIME[i];
            }
        }
        for (int i = 0; i < 3; i++) {
            sb.append(time[i] < 10 ? "0" + time[i] : time[i]);
            if (i < 2) sb.append(":");
        }
        return sb.toString();
    }
}
