import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static class Node{
        private int index;
        private int cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static int n,m;
    static int[][] paths;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        paths = new int[n+1][n+1];
        while(m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(paths[start][end] == 0 || paths[start][end] > cost){
                paths[start][end] = cost;
            }
        }
        sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i==j) continue;
                if(isConnected(i,j)){
                    fw(i,j);
                }
            }
        }
        print();

    }

    static boolean isConnected(int start, int end){
        return paths[start][end]>0 ? true : false;
    }

    static void print(){
        for (int i = 1 ; i <=n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                sb.append(paths[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void fw(int i, int j){
        for(int k = 1 ; k <= n ; k++){
            if(i==k) continue;
            if(isConnected(j,k)){
                int newCost = paths[i][j]+paths[j][k];
                if(paths[i][k] == 0 || paths[i][k] > newCost){
                    paths[i][k] = newCost;
                    fw(i,k);
                }
            }
        }
    }
}
