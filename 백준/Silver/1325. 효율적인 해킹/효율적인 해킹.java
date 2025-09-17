import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            String[] relation = br.readLine().split(" ");
            int a = Integer.parseInt(relation[0]);
            int b = Integer.parseInt(relation[1]);
            graph[b].add(a);
        }
        
        int maxCount = 0;
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int count = bfs(i);
            
            if (count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(i);
            } else if (count == maxCount) {
                result.add(i);
            }
        }
        
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append(" ");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        int count = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        
        return count;
    }
}
