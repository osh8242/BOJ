import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String name : participant) {
            int count = 1;
            if(map.containsKey(name)) count = map.get(name)+1;
            map.put(name, count);
        }
        for(String name : completion){
            if(map.containsKey(name)) {
                int count = map.get(name);
                if(count == 1) map.remove(name);
                else map.put(name, count-1);
            }
        }
        for(String name : map.keySet()) answer = name;
        return answer;
    }
}