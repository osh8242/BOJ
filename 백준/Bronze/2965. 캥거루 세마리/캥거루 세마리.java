import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) nums[i] = Integer.parseInt(input[i]);
        Arrays.sort(nums);
        System.out.println(Math.max(nums[1] - nums[0], nums[2] - nums[1]) - 1);
    }

}