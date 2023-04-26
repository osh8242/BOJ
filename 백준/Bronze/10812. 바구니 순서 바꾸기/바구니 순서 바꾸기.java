import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n+1];
        Arrays.setAll(nums, num -> num);
        for(int test = 1 ; test <= m ; test++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            int[] back_nums = new int[end-mid+1];
            for(int i = 0 ; i < back_nums.length ; i++){
                back_nums[i] = nums[mid+i];
            }
            if(start != mid){
                for(int i = 0 ; i < mid-start ; i++){
                    nums[end-i] = nums[mid-1-i];
                }
            }
            for(int i = 0 ; i < back_nums.length ; i++){
                nums[start+i] = back_nums[i];
            }
        }
        for(int i = 1 ; i <= n ; i++){
            sb.append(nums[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
