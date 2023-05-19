import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] map;
    static int[] pnods;
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pnods = new int[n+1];
        map = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        dfs(1);

        for(int i = 2 ; i <= n ; i++){
            sb.append(pnods[i]+"\n");
        }
        System.out.println(sb);

    }

    static void dfs(int num){
        ArrayList<Integer> cnods = map[num];
        for(int i = 0 ; i < cnods.size() ; i++){
            int cnode = cnods.get(i);
            if(pnods[num] != cnode || num == 1) {
                pnods[cnode] = num;
                dfs(cnode);
            }
        }
    }

}
