class Solution {
    public int solution(String word) {

        int[] pow = {781, 156, 31, 6, 1};
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        
        int result = 0;
        
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (word.charAt(i) == vowels[j]) {
                    result += j * pow[i] + 1;
                    break;
                }
            }
        }
        
        return result;
    }
}
