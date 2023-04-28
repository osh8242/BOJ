import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] isVisit;
    public static int n;
    public static boolean[][] isConnect;
    public static Queue<int[]> que;
    public static int distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isConnect = new boolean[n+1][n+1];
        for(int line = 1 ; line <= m ; line++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isConnect[a][b] = true;
            isConnect[b][a] = true;
        }
        que = new LinkedList<>();
        int man = -1;
        int kebin = n*n;
        for(int v = 1 ; v <= n ; v++){
            int temp_kebin = 0;
            que.clear();
            for( int goal = 1 ; goal <= n ; goal++){
                if(v==goal) continue;
                distance = n;
                isVisit = new boolean[n+1];
                que.add(new int[]{v,0});
                while(que.size()>0){
                    int[] temp = que.poll();
                    bfs(temp[0],goal,temp[1]);
                }
                temp_kebin += distance;
            }
            if(kebin > temp_kebin) {
                kebin = temp_kebin;
                man = v;
            }
        }
        System.out.println(man);
    }

    public static int bfs(int v, int goal, int distance){
        if(v==goal && isVisit[v] == false) {
            Main.distance = distance;
        }
        if(distance >= Main.distance) return 0;
        if(isVisit[v] == false) isVisit[v] = true;
        distance++;
        for(int i = 1 ; i <= n ; i++){
            if(isConnect[v][i] == true && !isVisit[i]){
                que.add(new int[]{i, distance});
            }
        }
        return -1;
    }
}