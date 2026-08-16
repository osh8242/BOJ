class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] charArr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s; i++) sb.append(charArr[i]);
        sb.append(overwrite_string);
        for(int i = overwrite_string.length() + s; i < my_string.length(); i++)
            sb.append(charArr[i]);
        return sb.toString();
    }
}