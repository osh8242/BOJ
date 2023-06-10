import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    static TreeSet<Integer> ts = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();
    static int[] arr, input;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n+1];
        arr = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            ts.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 1 ; !ts.isEmpty() ; i++){
            input[i] = ts.pollFirst();
        }
        for(int i = 1 ; i < input.length && input[i] != 0 ; i++){
            dfs(input[i], 1);
        }
        System.out.println(sb);


    }

    static void dfs(int num, int length){
        arr[length] = num;
        if(length == m){
            for(int i = 1 ; i <= m ; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
        } else{
            for(int i = 1 ; i <= n ; i++){
                if(input[i] < num) continue;
                dfs(input[i], length+1);
            }
        }
    }

}
