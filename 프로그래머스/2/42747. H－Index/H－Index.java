import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int left = 0;
        int right = citations.length;
        
        while (left <= right) {
            int h = (left + right) / 2;
            int count = countCitationsAtLeastH(citations, h);
            
            if (count >= h) {
                left = h + 1;
            } else {
                right = h - 1;
            }
        }
        
        return right;
    }
    
    private int countCitationsAtLeastH(int[] citations, int h) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= h) {
                count++;
            }
        }
        return count;
    }
}
