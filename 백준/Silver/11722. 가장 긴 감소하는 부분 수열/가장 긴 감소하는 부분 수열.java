import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        dp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp.add(nums[N - 1]);
        for (int i = N - 1; i >= 0; i--) {
            if (nums[i] > dp.get(dp.size() - 1)) dp.add(nums[i]);
            else binarySearch(nums[i]);
        }
        System.out.println(dp.size());
    }

    static void binarySearch(int value) {
        int left = 0;
        int right = dp.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = dp.get(mid);
            if (value > midValue) left = mid + 1;
            else right = mid;
        }
        dp.set(left, value);
    }

}