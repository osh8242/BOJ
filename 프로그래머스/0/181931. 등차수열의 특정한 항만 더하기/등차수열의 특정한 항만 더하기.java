import java.util.stream.IntStream;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length)
            .filter(n -> included[n])
            .map(n -> a + n * d)
            .sum();
    }
}