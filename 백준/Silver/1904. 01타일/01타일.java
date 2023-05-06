import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(1);
            return;
        }
        if(n==2){
            System.out.println(2);
            return;
        }
        int[] nums = new int[1000001];
        nums[1] = 1; nums[2] = 2;
        for(int i = 3 ; i <= n ; i++){
            nums[i] = (nums[i-1] + nums[i-2])%15746;            
        }
        System.out.println(nums[n]);
    } // void main()
} //Class Main