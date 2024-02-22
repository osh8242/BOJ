import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int[] operator = new int[4];
    static int[] nums;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < operator.length ; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(nums[0],1);
        System.out.println(max + "\n" + min);
    }

    static void dfs(int sum, int index){
        if(index == N){
            if(sum > max) max = sum;
            if(sum < min) min = sum;
            return;
        }
        for(int i = 0 ; i < operator.length ; i++){
            if(operator[i] > 0){
                operator[i]--;
                switch (i){
                    case 0 : dfs(sum + nums[index], index+1); break;
                    case 1 : dfs(sum - nums[index], index+1); break;
                    case 2 : dfs(sum * nums[index], index+1); break;
                    case 3 : dfs(sum / nums[index], index+1); break;
                }
                operator[i]++;
            }
        }
    }
}
