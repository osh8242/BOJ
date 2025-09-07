import java.io.*;
import java.util.*;

public class Main {
    static class I implements Comparable<I>{
        long s,e;
        int w;
        I(long s,long e,int w){this.s=s;this.e=e;this.w=w;}
        public int compareTo(I o){ if(this.e<o.e) return -1; if(this.e>o.e) return 1; return 0; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        I[] a = new I[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            a[i] = new I(s,e,w);
        }
        Arrays.sort(a);
        long[] ends = new long[N];
        for(int i=0;i<N;i++) ends[i]=a[i].e;
        long[] dp = new long[N+1];
        for(int i=1;i<=N;i++){
            long s = a[i-1].s;
            int lo = 0, hi = N-1, pos = -1;
            while(lo<=hi){
                int mid = (lo+hi)>>>1;
                if(ends[mid] <= s){ pos = mid; lo = mid+1; } else hi = mid-1;
            }
            long take = a[i-1].w + (pos==-1?0:dp[pos+1]);
            long notake = dp[i-1];
            dp[i] = take>notake?take:notake;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[N]).append('\n');
        System.out.print(sb.toString());
    }
}
