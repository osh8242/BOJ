import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int minIdx = findMinIndexOfTwo(arr);
        int maxIdx = findMaxIndexOfTwo(arr);        
        if(minIdx == -1 && maxIdx == -1) return new int[] {-1};
        if(minIdx == maxIdx) return new int[] {2};
        return Arrays.copyOfRange(arr, minIdx, maxIdx + 1);
    }
    
    private int findMinIndexOfTwo(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++) if(arr[i] == 2) return i;
        return -1;
    }
    
    private int findMaxIndexOfTwo(int[] arr) {
        for(int i = arr.length - 1 ; i > 0 ; i--) if(arr[i] == 2) return i;
        return -1;
    }
}