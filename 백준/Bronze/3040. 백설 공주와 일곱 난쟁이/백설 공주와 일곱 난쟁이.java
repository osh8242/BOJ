import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[9];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        int residue = sum - 100;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == residue) {
                    nums[i] = 0;
                    nums[j] = 0;
                    break;
                }
            }
            if (nums[i] == 0) break;
        }
        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] != 0) sb.append(nums[i]+"\n");
        }
        System.out.println(sb);
    }

}
