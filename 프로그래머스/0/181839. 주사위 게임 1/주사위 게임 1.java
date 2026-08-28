class Solution {
    public int solution(int a, int b) {
        return a % 2 != b % 2 ? 2 * (a + b)
             : a % 2 == 1 ? a * a + b * b
             : Math.abs(a - b);
    }
}