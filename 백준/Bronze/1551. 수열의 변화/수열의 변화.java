import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split(",");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(input[i]);

        while (K-- > 0) {
            int[] temp = new int[nums.length - 1];
            for (int i = 0; i < nums.length - 1; i++) {
                temp[i] = nums[i + 1] - nums[i];
            }
            nums = temp;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) sb.append(",");
            sb.append(nums[i]);
        }
        System.out.println(sb);

    }

}