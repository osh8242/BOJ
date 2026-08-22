import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        
        int[] temp = Arrays.stream(arr)
            .filter(v -> set.add(v))
            .toArray();
        int n = temp.length;
        int[] answer = new int[k];
        
        for(int i = 0 ; i < Math.min(n, k) ; i++) {
            answer[i] = temp[i];
        }
        
        if(n < k) {
            for(int i = n ; i < k ; i++) {
                answer[i] = -1;
            }
        }

        return answer;
    }
}