import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] isVisit = new boolean[101];
    public static int[] jumpTo = new int[101];
    public static Queue<int[]> que = new LinkedList<>();
    public static int count = 2147483647;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n+m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            jumpTo[start] = end;
        }
        que.add(new int[]{1,0});
        isVisit[1] = true;
        while(que.size()>0){
            int[] temp = que.poll();
            bfs(temp[0], temp[1]);
        }
        System.out.println(count);
    }

    public static void bfs(int pos, int depth){
        if(jumpTo[pos] > 0) pos = jumpTo[pos];

        if(pos >= 94){
            if(depth <= 99) depth++;
            count = count>depth?depth:count;
            return;
        }

        if(depth >= count) return;

        depth++;
        for(int i = 1 ; i <= 6 ; i++){
            if(!isVisit[pos+i]){
                isVisit[pos+i] = true;
                que.add(new int[]{pos+i,depth});
            }
        }

    }

}
