import java.util.*;

public class Solution {
    public int[] solution(int []arr) {               
        List<Integer> nums = new ArrayList<>();
        int prevNum = -1;
        for(int num : arr){
            if(num != prevNum) nums.add(num);
            prevNum = num;
        }
        int[] answer = new int[nums.size()];
        for(int i = 0 ; i < nums.size() ; i++){
            answer[i] = nums.get(i);
        }
        return answer;
    }
}