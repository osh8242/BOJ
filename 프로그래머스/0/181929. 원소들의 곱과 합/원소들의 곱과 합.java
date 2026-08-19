import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list)
            .sum();
        int multiple = Arrays.stream(num_list)
            .reduce(1, (a,b) -> a*b);
        return sum * sum > multiple ? 1 : 0;
    }
}