import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[3];
        for(int i = 0 ; i < 3 ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < 2 ; i++){
            for(int j = i+1 ; j < 3 ; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(nums[0]+ " " + nums[1] + " " + nums[2]);

    }

}