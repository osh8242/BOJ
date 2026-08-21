import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        for(int i = 0 ; i < n ; i++) {
            int[] query = queries[i];
            int s = query[0];
            int e = query[1];
            int k = query[2];
            int minValue = getMinValue(arr, s, e, k);
            answer[i] = minValue;
        }
        return answer;
    }
    
    private int getMinValue(int[] arr, int s, int e, int k) {
        int min = Integer.MAX_VALUE;
        for(int i = s ; i <= e ; i++) {
            int v = arr[i];
            if(v < min && v > k) min = v;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}