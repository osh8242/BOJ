class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries) {
            swap(arr, query[0], query[1]);
        }
        return arr;
    }
    
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    } 
}