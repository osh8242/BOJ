import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] numStrings = new String[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++) {
            numStrings[i] = Integer.toString(numbers[i]);
        }
                
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return (y + x).compareTo(x + y);
            }
        });
        
        if (numStrings[0].equals("0")) {
            return "0";
        }
        
        StringBuilder answer = new StringBuilder();
        for (String num : numStrings) {
            answer.append(num);
        }
        
        return answer.toString();
    }
}
