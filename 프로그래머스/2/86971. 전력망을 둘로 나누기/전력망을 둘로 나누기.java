import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    
    private Map<Integer, HashSet<Integer>> graph = new HashMap<>();
    static int countLeft = 0;
    static int countRight = 0;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
                
        for(int i = 1 ; i <= n ; i++) {
            graph.put(i, new HashSet<>());
        }
        
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires) {
            Count left = new Count();
            process(left, wire[0], wire[1], new boolean[n+1]);
            
            Count right = new Count();
            process(right, wire[1], wire[0], new boolean[n+1]);
            
            answer = Math.min(answer, Math.abs(left.count - right.count));
        }
        
        return answer;
    }
    
    void process(Count count, int start, int forbidden, boolean[] isVisit) {
        graph.get(start).remove(forbidden);        
        isVisit[start] = true;
        dfs(count, start, isVisit);
        graph.get(start).add(forbidden);
    }
    
    void dfs(Count count, int i, boolean[] isVisit) {
        for(int next : graph.get(i)) {            
            if(!isVisit[next]) {
                count.count++;
                isVisit[next] = true;                
                dfs(count, next, isVisit);
            }
        }
    }
    
}

class Count {
    public int count = 1;
}