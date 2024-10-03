import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0 ; i < commands.length ; i++) {
            int startIdx = commands[i][0];
            int endIdx = commands[i][1];
            int idx = commands[i][2];
            
            int[] temp = new int[endIdx - startIdx +1];
            int tempIdx = 0;
            for(int j = startIdx - 1 ; j < endIdx ; j++) {
                temp[tempIdx++] = array[j];
            }
            
            Arrays.sort(temp);
            answer[i] = temp[idx - 1];            
        }
        return answer;
    }
}