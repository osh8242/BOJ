class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;
        for(int i = 0 ; i < query.length ; i++) {
            if (i % 2 == 0) {
                answer = new int[query[i] + 1];
                System.arraycopy(arr, 0, answer, 0, query[i] + 1);
            } else {
                answer = new int[arr.length - query[i]];
                System.arraycopy(arr, query[i], answer, 0, arr.length - query[i]);
            }
            arr = answer;
        }
        
        return answer;
    }
}