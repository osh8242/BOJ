import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> lengthCountMap = new HashMap<>();
        for (String str : strArr) {
            int length = str.length();
            lengthCountMap.put(length, lengthCountMap.getOrDefault(length, 0) + 1);
        }

        int max = -1;
        for (int v : lengthCountMap.values()) {
            max = Math.max(v, max);
        }
        return max;
    }
}