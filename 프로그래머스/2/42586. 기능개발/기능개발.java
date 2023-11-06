import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        int length = progresses.length;
        int[] completeDate = new int[length];
        for(int i = 0 ; i < length ; i++){
            int remainingProgress = 100 - progresses[i];
            completeDate[i] = remainingProgress % speeds[i] == 0 ? 
            remainingProgress / speeds[i] : 
            remainingProgress / speeds[i] + 1;
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
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}