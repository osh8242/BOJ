import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {        
        return IntStream.concat(
            IntStream.rangeClosed(intervals[0][0], intervals[0][1])
                    .map(idx -> arr[idx]),
            IntStream.rangeClosed(intervals[1][0], intervals[1][1])
                    .map(idx -> arr[idx])
        ).toArray();
    }
}