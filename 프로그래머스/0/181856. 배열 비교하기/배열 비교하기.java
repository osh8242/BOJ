import java.util.Arrays;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n1 < n2) return -1;
        if(n1 > n2) return 1;
        int sum1 = Arrays.stream(arr1)
            .sum();
        int sum2 = Arrays.stream(arr2)
            .sum();
        return sum1 == sum2 ? 0 : sum1 < sum2 ? -1 : 1;
    }
}