import java.util.HashMap;

class Solution {
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> phoneBookMap = new HashMap<>();
        for (String phoneNumber : phone_book) {
            phoneBookMap.put(phoneNumber, 0);
        }
        
        for (String phoneNumber : phone_book) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (phoneBookMap.containsKey(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}