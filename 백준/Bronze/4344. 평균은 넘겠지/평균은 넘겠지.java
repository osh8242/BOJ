import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1 ; test_case <= T ; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];
            int sum = 0;
            for(int i = 0 ; i < n ; i++){
                nums[i] = Integer.parseInt(st.nextToken());
                sum += nums[i];
            }
            int count = 0;
            for(int i = 0 ; i < n ; i++){
                if(nums[i]*n > sum) count++;
            }
            System.out.printf("%.3f%%\n",((double)count/n*100));

        }
    }
}
