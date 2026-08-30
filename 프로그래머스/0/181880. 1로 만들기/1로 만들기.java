import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        return IntStream.range(0, num_list.length)
            .map(i -> transform(0, num_list[i]))
            .sum();
    }
    
    private int transform(int count, int v) {
        if (v == 1) return count;
        if (v % 2 == 0) return transform(count + 1, v / 2);
        else return transform(count + 1, (v - 1) / 2);
    }
}