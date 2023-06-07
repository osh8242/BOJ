import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int[] arr, input;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1];
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        input = new int[n+1];
        isVisit = new boolean[n+1];
        for(int i = 0 ; i < n ; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 1 ; i <= n ; i++){
            input[i] = pq.poll();
        }
        for(int i = 1 ; i <= n ; i++){
            isVisit[i] = true;
            dfs(input[i],1);
            isVisit[i] = false;
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
            for(int i = 1 ; i <= n ; i++){
                if(!isVisit[i]){
                    isVisit[i] = true;
                    dfs(input[i], length+1);
                    isVisit[i] = false;
                }
            }
        }
    }


}
