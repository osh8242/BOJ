import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] nums;
    static StringBuilder sb;

    private void solution() throws IOException {
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 0) {
                union(a, b);
            }
            if (command == 1) {
                if (getParent(a) == getParent(b)) sb.append("YES");
                else sb.append("NO");
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }

    void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a != b) nums[b] = a;
    }

    int getParent(int current) {
        return nums[current] == current ? current : (nums[current] = getParent(nums[current]));
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = i;
        sb = new StringBuilder();

        new Main().solution();
    }

}
