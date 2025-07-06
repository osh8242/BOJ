import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];
        for (int i = 0; i < N; i++) {
            nums[i] = br.readLine();
        }
        int L = nums[0].length();
        for (int k = 1; k <= L; k++) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                String suf = nums[i].substring(L - k);
                set.add(suf);
            }
            if (set.size() == N) {
                System.out.print(k);
                return;
            }
        }
    }
}
