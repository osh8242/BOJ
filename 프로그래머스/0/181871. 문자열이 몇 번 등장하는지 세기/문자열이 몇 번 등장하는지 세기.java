class Solution {
    public int solution(String myString, String pat) {
        int count = 0;
        for (int idx = myString.indexOf(pat); idx != -1; idx = myString.indexOf(pat, idx + 1)) {
            count++;
        }
        return count;
    }
}