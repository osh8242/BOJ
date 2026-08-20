import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int last = num_list[n - 1], secondLast = num_list[n - 2];
        int newValue = last > secondLast ? last - secondLast : last * 2;

        int[] answer = Arrays.copyOf(num_list, n + 1);
        answer[n] = newValue;
        return answer;
    }
}