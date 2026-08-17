class Solution {
    public int[][] solution(int[][] arr) {
        int rows = arr.length; int cols = arr[0].length;
        int n = Math.max(rows, cols);
        int[][] answer = new int[n][n];
        for(int i = 0 ; i < rows ; i++) {
            System.arraycopy(arr[i], 0, answer[i], 0, cols);
        }              
        return answer;
    }
}