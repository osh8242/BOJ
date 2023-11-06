import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        int length = progresses.length;
        int[] completeDate = new int[length];
        for(int i = 0 ; i < length ; i++){
            int minDate = (100 - progresses[i]) / speeds[i];
            completeDate[i] = minDate*speeds[i] + progresses[i] == 100 ? 
            minDate : 
            minDate + 1;
        }
        int prev = completeDate[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(prev);
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < length ; i++){
            if(prev >= completeDate[i]) stack.push(completeDate[i]);
            else {
                list.add(stack.size());
                stack.clear();
                stack.push(completeDate[i]);
                prev = completeDate[i];
            }
        }
        if(!stack.isEmpty()) list.add(stack.size());        

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}