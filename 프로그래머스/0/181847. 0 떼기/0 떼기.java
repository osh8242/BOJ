class Solution {
    public String solution(String n_str) {
        int idx = getIndex(n_str);
        if(idx == -1) return n_str;        
        return n_str.substring(idx);
    }
    
    private int getIndex(String str) {
        if(str.charAt(0) != '0') return -1;
        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) != '0') return i;
        }
        return -1;
    }
}