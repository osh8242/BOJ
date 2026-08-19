class Solution {
    public String[] solution(String[] picture, int k) {
        int n = picture.length;
        String[] answer = new String[k * n];        
        for(int i = 0 ; i < n ; i ++) {
            String str = picture[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < str.length() ; j++) {
                for(int r = 1 ; r <= k ; r++) sb.append(str.charAt(j));
            }
            for(int r = 0 ; r < k ; r++) {
                answer[k * i + r] = sb.toString();
            }
        }
        return answer;
    }
}