import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[] bulbs;
    static boolean[] visited;
    static int totalInner;
    static int minChanges = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        bulbs = new String[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            bulbs[i] = br.readLine();
        }
        
        totalInner = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bulbs[i].length() - 1; j++) {
                if (bulbs[i].charAt(j) != bulbs[i].charAt(j + 1)) {
                    totalInner++;
                }
            }
        }
        
        dfs(0, 0, -1);
        
        sb.append(totalInner + minChanges);
        System.out.print(sb.toString());
    }
    
    static void dfs(int depth, int boundaryChanges, int prevIdx) {
        if (depth == n) {
            minChanges = Math.min(minChanges, boundaryChanges);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            int changes = boundaryChanges;
            
            if (prevIdx != -1) {
                char prevLast = bulbs[prevIdx].charAt(bulbs[prevIdx].length() - 1);
                char currFirst = bulbs[i].charAt(0);
                if (prevLast != currFirst) {
                    changes++;
                }
            }
            
            dfs(depth + 1, changes, i);
            visited[i] = false;
        }
    }
}
