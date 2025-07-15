import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Integer> lucky = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
         generate(0, 6, 0);
        Collections.sort(lucky);
        int ans = 4;
        for (int x : lucky) {
            if (x <= N) ans = x;
            else break;
        }
        System.out.println(ans);
    }

    static void generate(int len, int maxLen, int val) {
        if (len == maxLen) return;
        int next4 = val * 10 + 4;
        int next7 = val * 10 + 7;
        lucky.add(next4);
        lucky.add(next7);
        generate(len + 1, maxLen, next4);
        generate(len + 1, maxLen, next7);
    }
}
