import java.io.*;
import java.util.*;

public class Main {
    static class P { int r,c,d; P(int r,int c,int d){this.r=r;this.c=c;this.d=d;} }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int tr = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        int[][] moves = {
            {-3,-2,-1,0,-2,-1},
            {-3,2,-1,0,-2,1},
            {-2,3,0,1,-1,2},
            {2,3,0,1,1,2},
            {3,2,1,0,2,1},
            {3,-2,1,0,2,-1},
            {2,-3,0,-1,1,-2},
            {-2,-3,0,-1,-1,-2}
        };
        boolean[][] vis = new boolean[10][9];
        ArrayDeque<P> q = new ArrayDeque<>();
        q.add(new P(sr,sc,0));
        vis[sr][sc]=true;
        int ans = -1;
        while(!q.isEmpty()){
            P p = q.poll();
            if(p.r==tr && p.c==tc){ ans = p.d; break; }
            for(int i=0;i<8;i++){
                int fr = p.r + moves[i][0];
                int fc = p.c + moves[i][1];
                int b1r = p.r + moves[i][2];
                int b1c = p.c + moves[i][3];
                int b2r = p.r + moves[i][4];
                int b2c = p.c + moves[i][5];
                if(b1r==tr && b1c==tc) continue;
                if(b2r==tr && b2c==tc) continue;
                if(fr<0||fr>=10||fc<0||fc>=9) continue;
                if(!vis[fr][fc]){
                    vis[fr][fc]=true;
                    q.add(new P(fr,fc,p.d+1));
                }
            }
        }
        System.out.println(ans);
    }
}
