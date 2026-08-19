import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] num_list) {
        return concat(num_list, 1) + concat(num_list, 0);
    }

    private int concat(int[] num_list, int mod) {
        return Integer.parseInt(Arrays.stream(num_list)
                .filter(n -> n % 2 == mod)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }
}