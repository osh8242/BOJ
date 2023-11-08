import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        int length = progresses.length;
        int[] completeDate = new int[length];
        for(int i = 0 ; i < length ; i++){
            int remaining = 100 - progresses[i];
            completeDate[i] = remaining % speeds[i] == 0 ? 
            remaining / speeds[i] : 
            remaining / speeds[i] + 1;
        }
                       
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int count = 1;
        int deployDate = completeDate[index];
        while(++index < length){
            if(deployDate >= completeDate[index]){
                count++;                
            } else {
                list.add(count);
                deployDate = completeDate[index];
                count = 1;
            }
        }
        list.add(count);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}