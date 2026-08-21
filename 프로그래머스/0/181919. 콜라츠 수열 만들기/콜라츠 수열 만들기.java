import java.util.ArrayList;

class Solution {
    
    private ArrayList<Integer> series = new ArrayList<>();
    
    public int[] solution(int n) {
        process(n);
        return series.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private void process(int n) {
        series.add(n);
        if(n == 1) return;        
        if(n % 2 == 0) process(n/2);
        else process(3*n+1);
    }
}