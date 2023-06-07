import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1];
        for(int i = 1 ; i <= n ; i++){
            dfs(i,1);
        }
        System.out.println(sb);
    }

    static void dfs(int num, int length){
        arr[length] = num;
        if(length==m){
            for(int i = 1 ; i <= m ; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
        } else {
            for(int i = num ; i <= n ; i++){
                dfs(i, length+1);
            }
        }
    }


}
