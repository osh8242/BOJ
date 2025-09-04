import java.io.*;
import java.util.*;

public class Main {
    static int dayIdx(String d){
        if(d.equals("M")) return 0;
        if(d.equals("T")) return 1;
        if(d.equals("W")) return 2;
        if(d.equals("TH")) return 3;
        return 4;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while(line != null && line.trim().length() == 0) line = br.readLine();
        int K = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();
        for(int ks=1; ks<=K; ks++){
            line = br.readLine();
            while(line != null && line.trim().length() == 0) line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            HashMap<String,int[]> map = new HashMap<>();
            for(int i=0;i<m;i++){
                line = br.readLine();
                while(line != null && line.trim().length() == 0) line = br.readLine();
                st = new StringTokenizer(line);
                String cname = st.nextToken();
                String day = st.nextToken();
                String time = st.nextToken();
                int di = dayIdx(day);
                String[] parts = time.split("-");
                String[] s0 = parts[0].split(":");
                String[] s1 = parts[1].split(":");
                int start = Integer.parseInt(s0[0])*60 + Integer.parseInt(s0[1]);
                int end = Integer.parseInt(s1[0])*60 + Integer.parseInt(s1[1]);
                map.put(cname, new int[]{di, start, end});
            }
            int cnt = 0;
            for(int i=0;i<n;i++){
                line = br.readLine();
                while(line != null && line.trim().length() == 0) line = br.readLine();
                String[] toks = line.trim().split("\\s+");
                boolean overlapped = false;
                int len = toks.length;
                for(int a=0; a<len && !overlapped; a++){
                    for(int b=a+1; b<len; b++){
                        int[] A = map.get(toks[a]);
                        int[] B = map.get(toks[b]);
                        if(A[0] != B[0]) continue;
                        if(A[1] < B[2] && B[1] < A[2]) { overlapped = true; break; }
                    }
                }
                if(overlapped) cnt++;
            }
            out.append("Data Set ").append(ks).append(":\n");
            out.append(cnt).append('\n');
        }
        System.out.print(out.toString());
    }
}
