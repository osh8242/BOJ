class Solution {
    static int count = 0;
    static int target = 0;
    static int[] numbers = null;

    public int solution(int[] numbers, int target) {
        Solution.target = target;
        Solution.numbers = numbers;
        dfs(0, 0);
        return count;
    }

    void dfs(int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) count++;
            return;
        }

        dfs(idx + 1, sum + numbers[idx]);
        dfs(idx + 1, sum - numbers[idx]);
    }
}