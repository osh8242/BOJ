import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        // 우선순위 큐 생성
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int s : scoville) {
            que.offer(s);
        }

        // 섞는 작업 반복
        while (que.size() > 1 && que.peek() < K) {
            int first = que.poll();
            int second = que.poll();
            int mixed = first + second * 2;
            que.offer(mixed);
            count++;
        }

        // 모든 음식의 스코빌 지수가 K 이상인지 확인
        return que.peek() >= K ? count : -1;
    }
}
