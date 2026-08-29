class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] current = arr.clone();
        while(true) {
            int[] next = current.clone();
            for(int i = 0 ; i < arr.length ; i++) {
                next[i] = getNextValue(current[i]);
            }
            if(equals(current, next)) return answer;
            current = next;
            answer++;
        }
    }
    
    private int getNextValue(int v) {
        return v >= 50 && v % 2 == 0 ? v / 2 : v < 50 && v % 2 == 1 ? 2 * v + 1 : v;
    }
    
    private boolean equals(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        if(n != m) return false;
        for(int i = 0 ; i < n ; i++) {
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}