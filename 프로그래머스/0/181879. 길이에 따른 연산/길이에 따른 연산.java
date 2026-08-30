class Solution {
    public int solution(int[] num_list) {
        int n = num_list.length;
        if(n >= 11) return sum(num_list);
        else return multiply(num_list);
    }
    
    private int sum(int[] arr) {
        int sum = 0;
        for(int v : arr) sum += v;
        return sum;
    }
    
    private int multiply(int[] arr) {
        int result = 1;
        for(int v : arr) result *= v;
        return result;
    }
}