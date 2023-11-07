import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {        
        int time = 0;   // 걸린시간        
        int index = 0;  // 다음에 올라갈 트럭 index
        int currentWeight = 0;    // 다리에 올라간 총 무게
        
        // 다리 위에 트럭을 표현하는 Deque
        Deque<Truck> deque = new LinkedList<>();

        while(index < truck_weights.length || !deque.isEmpty()) {
            time++;
            // 덱에 트럭이 있으면 맨 앞 트럭의 위치를 확인하여 제거하기
            if(!deque.isEmpty() && deque.peekFirst().position == bridge_length) {
                currentWeight -= deque.peekFirst().weight;
                deque.removeFirst();
            }
            // 덱의 트럭 위치 증가
            for(Truck truck : deque){
                truck.position++;                    
            }                  
            // 대기 중인 맨 앞 트럭이 다리에 올라올 수 있으면 추가하기
            if(index < truck_weights.length && currentWeight + truck_weights[index] <= weight){
                currentWeight += truck_weights[index];
                deque.addLast(new Truck(1, truck_weights[index++]));
            }
        }
        return time;
    }
    
    class Truck {
        private int position;
        private int weight;
        public Truck (int position, int weight){
            this.position = position;
            this.weight = weight;
        }
    }
}