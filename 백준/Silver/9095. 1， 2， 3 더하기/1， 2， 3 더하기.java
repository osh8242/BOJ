import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
            for(int test = 1 ; test <= t ; test++){
            int num = Integer.parseInt(br.readLine());
            int[] nums = new int[num+1];
            switch (num){
                case 1:
                    sb.append("1\n"); break;
                case 2:
                    sb.append("2\n"); break;
                case 3:
                    sb.append("4\n"); break;
                default:
                    nums[1] = 1;
                    nums[2] = 2;
                    nums[3] = 4;
                    for(int i = 4 ; i <= num ; i++){
                        nums[i] = nums[i-3] + nums[i-2] + nums[i-1];
                    }
                    sb.append(nums[num]+"\n");

            }
        }
        System.out.println(sb.toString());
    }
}