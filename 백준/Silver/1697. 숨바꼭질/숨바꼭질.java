import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int k;
    public static Queue<int[]> list;
    public static boolean[] isVisited;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(n==k || n>k) { System.out.println(n-k); return; }
        list  = new LinkedList<>();
        isVisited = new boolean[200000];
        count = k-n;
        list.add(new int[]{n,0});
        while (list.size() != 0) {
            int[] temp = list.poll();
            bfs(temp[0], temp[1]);
        }
        System.out.println(count);

    }

    public static void bfs(int position, int count){
        if(position == k && Main.count > count) { Main.count = count; return;}
        if(isVisited[position] == true) return;
        else{
            isVisited[position] = true;
            count++;
            if(position < k){
                list.add(new int[]{2*position, count});
                list.add(new int[]{position+1, count});
                if(position>0) list.add(new int[]{position-1, count});
            } else list.add(new int[]{position-1, count});
        }

    }

}