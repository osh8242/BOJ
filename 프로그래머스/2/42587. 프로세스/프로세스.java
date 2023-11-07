import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 프로세스를 담을 Queue
        Queue<Process> que = new LinkedList<>();
        for(int i = 0 ; i < priorities.length ; i++){
            que.add(new Process(i,priorities[i]));
        }
        
        // 우선순위큐를 이용하여 작업우선순위를 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < priorities.length ; i++){
            pq.add(priorities[i]);
        }
        
        // 작업순서
        int order = 0;
        // 프로세스의 index
        int index = -1;
        // location에 해당하는 index 프로세스가 나올 때까지 반복
        while(index != location){                     
            order++;
            // 남은 프로세스 중 가장 높은 우선순위값
            int targetPriority = pq.poll();    
            // 현재 큐의 맨 앞에 있는 프로세스
            Process process = que.poll();
            // 현재 프로세스의 우선순위
            int currentPriority = process.priority;
            // 꺼낸 프로세스의 우선순위가 가장 높은 우선순위가 아니라면 다시 뒤로 보냄
            while(targetPriority != currentPriority){
                que.add(process);
                process = que.poll();
                currentPriority = process.priority;
            }       
            // 현재 처리할 프로세스의 인덱스
            index = process.index;
        }
        // 작업순서 반환
        return order;
    }
    
    class Process {
        private int index;
        private int priority;
        public Process (int index, int priority){
            this.index = index;
            this.priority = priority;
        }            
    }
}