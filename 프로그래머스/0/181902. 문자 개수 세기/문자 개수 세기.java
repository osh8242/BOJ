class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        my_string.chars()
            .forEach(v -> {
                            if (v >= 97)  answer[v - 71]++;
                            else answer[v - 65]++;
                        }
                    );
        return answer;
    }
}