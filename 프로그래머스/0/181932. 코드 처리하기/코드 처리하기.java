class Solution {
    public String solution(String code) {        
        int mode = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch == '1') mode = mode == 0 ? 1 : 0;
            else if (i % 2 == mode) sb.append(ch);
        }
        if(sb.length() == 0) return "EMPTY";
        return sb.toString();
    }
    
    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}