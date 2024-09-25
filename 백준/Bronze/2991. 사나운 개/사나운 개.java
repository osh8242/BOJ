import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(countAttacks(A, B, C, D, P)).append("\n");
        sb.append(countAttacks(A, B, C, D, M)).append("\n");
        sb.append(countAttacks(A, B, C, D, N)).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    public static int countAttacks(int A, int B, int C, int D, int time) {
        int attackCount = 0;
        if (isAttacking(A, B, time)) attackCount++;
        if (isAttacking(C, D, time)) attackCount++;
        return attackCount;
    }

    public static boolean isAttacking(int attackTime, int restTime, int time) {
        int cycle = attackTime + restTime;
        int modTime = time % cycle;
        return modTime > 0 && modTime <= attackTime;
    }
}
