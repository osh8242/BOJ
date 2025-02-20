import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        Queue<Integer> que = new PriorityQueue<>();
        for(int k : scoville) {
            que.offer(k);
        }
        
        int sum = que.peek();
        if(sum < K) {
            count = 1;
            sum = que.poll() + que.poll() * 2;
            que.offer(sum);
        }
        
        while (que.size() > 1 && que.peek() < K) {
            int a = que.poll();
            int b = que.poll();
            sum = a + b * 2;
            que.offer(sum);            
            count++;
        }
        
        return sum >= K ? count : -1;
    }
}