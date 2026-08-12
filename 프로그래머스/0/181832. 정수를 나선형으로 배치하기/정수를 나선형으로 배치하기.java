class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int top = 0; int bottom = n-1; int left = 0; int right = n-1;
        int value = 1;
        while (top <= bottom && left <= right) {
            for(int col = left; col <= right; col++) {
                answer[top][col] = value++;
            }
            top++;
            for(int row = top; row <= bottom; row++) {
                answer[row][right] = value++;
            }
            right--;
            for(int col = right; col >= left; col--) {
                answer[bottom][col] = value++;
            }
            bottom--;
            for(int row = bottom; row >= top; row--) {
                answer[row][left] = value++;
            }
            left++;
        }
        return answer;
    }
}