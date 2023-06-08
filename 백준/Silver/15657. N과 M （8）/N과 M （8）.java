import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] input, arr;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        arr = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            dfs(input[i], 1);
        }
        System.out.println(sb);

    }//main(){}

    static void dfs(int num, int length){
        arr[length] = num;
        if(length==m){
            for(int i = 1 ; i <= m ; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
        } else {
            for(int i = 1 ; i <= n ; i++){
                if(input[i] >= num) dfs(input[i], length+1);
            }
        }
    }

}//class Main{}
