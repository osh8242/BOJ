import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] nums1 = new long[n+1];
        long[] nums0 = new long[n+1];
        nums1[1] = 1;
        nums0[1] = 0;
        for(int i = 2 ; i <= n ; i++){
            nums0[i] = nums0[i-1] + nums1[i-1];
            nums1[i] = nums0[i-1];
        }
        System.out.println(nums1[n]+nums0[n]);

    }//main(){}

}//class Main{}
