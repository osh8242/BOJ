import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        String answer = "";
        if (input.length == 1) {
            answer = "NO";
        }
        if (input.length != 1) {
            int[] nums = new int[input.length];
            int zeroCount = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '0') zeroCount++;
                nums[i] = Character.getNumericValue(input[i]);
            }

            if (zeroCount != 0) {
                answer = zeroCount == 1 ? "NO" : "YES";
            }
            if (zeroCount == 0) {
                int left = nums[0];
                int right = 1;
                for (int i = 1; i < nums.length; i++) {
                    right *= nums[i];
                }

                if (left == right) {
                    answer = "YES";
                } else {
                    for (int i = 1; i < nums.length; i++) {
                        left *= nums[i];
                        right /= nums[i];
                        if (left == right) break;
                    }
                    answer = left == right ? "YES" : "NO";
                }
            }
        }
        System.out.println(answer);
    }
}