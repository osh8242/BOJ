class Solution {
    public int solution(int a, int b) {
        int value1 = Integer.parseInt("" + a + b);
        int value2 = 2 * a * b;
        return Math.max(value1, value2);
    }
}