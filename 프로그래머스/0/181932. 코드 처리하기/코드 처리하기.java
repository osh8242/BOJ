class Solution {
    public String solution(String code) {        
        int mode = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < code.length(); i++) {
            char ch = code.charAt(i);
            switch(mode) {
                case 0:
                    if (ch == '1') mode = 1;
                    else if (isEven(i)) sb.append(ch);
                    break;
                case 1:
                    if (ch == '1') mode = 0;
                    else if (!isEven(i)) sb.append(ch);
                    break;
                default:
                    break;
            }
                
        }
        if(sb.length() == 0) return "EMPTY";
        return sb.toString();
    }
    
    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}