import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= T ; test++){
            int n = Integer.parseInt(br.readLine());
            long[] nums = new long[n+1];
            if(n < 6){
                switch (n){
                    case 1 :
                    case 2 :
                    case 3 : sb.append(1+"\n"); break;
                    case 4 :
                    case 5 : sb.append((2+"\n"));
                }
                continue;
            }
            nums[1] = 1; nums[2] = 1; nums[3] = 1; nums[4] = 2; nums[5] = 2;
            for(int i = 6 ; i <= n ; i++){
                nums[i] = nums[i-1] + nums[i-5];
            }
            sb.append(nums[n]+"\n");

        }
        System.out.println(sb.toString());

    }

}
