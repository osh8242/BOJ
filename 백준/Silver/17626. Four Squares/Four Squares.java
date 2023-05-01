import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int sqrt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sqrt = (int)Math.sqrt(n);
        int count = 0;
        outer:for(int i = 0 ; i <= sqrt ; i++){
            for(int j = 0 ; j <= sqrt ; j++){
                for(int k = 0; k <= sqrt; k++){
                    for(int l = 1 ; l <= sqrt; l++){
                        if(i*i + j*j + k*k + l*l == n){
                            int[] nums = new int[]{i,j,k,l};
                            for(int index = 0 ; index < 4 ; index++){
                                if(nums[index] != 0) count++;
                            }
                            break outer;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
