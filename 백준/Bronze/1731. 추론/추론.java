import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        boolean isGeometric = false;
        if (nums[2] - nums[1] != nums[3] - nums[2]) isGeometric = true;
        int q = 0;
        if (isGeometric) q = nums[2] / nums[1];
        else q = nums[2] - nums[1];
        System.out.println(isGeometric ? nums[N] * q : nums[N] + q);
    }
}
