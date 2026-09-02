class Solution {
    public int solution(String num_str) {       
        return num_str.chars()
            .map(v -> v - '0')
            .sum();
    }
}