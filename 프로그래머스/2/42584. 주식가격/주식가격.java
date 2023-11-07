import java.util.PriorityQueue;

class Solution {
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 주식가격을 높은 순서로 담을 우선순위큐
        PriorityQueue<Share> pq = new PriorityQueue<>();
        
        for(int time = 0 ; time < prices.length ; time++){
            // 현재 가격
            int currentPrice = prices[time];
            
            // 현재 주식을 우선순위큐에 담음
            Share share = new Share(time, prices[time]);
            pq.add(share);
            
            // 현재 시점에 값이 떨어진 주식을 찾기
            int pastPrice = Integer.MAX_VALUE;
            while(pastPrice > currentPrice){
                // 과거 가장 높은 가격을 살펴보기
                Share highShare = pq.peek();
                pastPrice = highShare.price;
                
                // 과거 최고가보다 현재가가 낮으면
                if(highShare.price > share.price){
                    // 현재 시점과 최고가 시점을 뺀 값을 정답에 기록하고 큐에서 제거
                    answer[highShare.time] = time - highShare.time;
                    pq.poll();
                }
            }
        }
        // 큐에 주식이 남아있다면, 해당 주식시점부터 마지막 시각까지의 시간을 정답에 기록
        while(!pq.isEmpty()){
            Share share = pq.poll();
            answer[share.time] = prices.length - 1 - share.time;
        }
        return answer;
    }
    
    // 주식 Class (시점, 가격)
    class Share implements Comparable<Share> {
        private int time;
        private int price;        
        public Share (int time, int price){
            this.time = time;
            this.price = price;
        }
        @Override
        public int compareTo(Share target){
            return target.price - this.price;
        }
    }
}