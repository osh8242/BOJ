import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[] nums = br.readLine().toCharArray();
        int sum = 0;
        for (char num : nums) sum += num;
        sum -= '0' * nums.length;

        if (sum % 3 != 0) bw.write("-1");
        else {
            Arrays.sort(nums);
            if (nums[0] != '0') bw.write(Integer.toString(-1));
            else bw.write(sb.append(nums).reverse().toString());
        }
        bw.flush();
    }

}
