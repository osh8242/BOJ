import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
        int a = nums[1] - nums[0];
        int b = nums[2] - nums[1];

        if (a == b) bw.write(String.valueOf(nums[2] + b));
        else if (2 * a == b) bw.write(String.valueOf(nums[1] + a));
        else bw.write(String.valueOf(nums[0] + b));
        bw.flush();
    }
}
