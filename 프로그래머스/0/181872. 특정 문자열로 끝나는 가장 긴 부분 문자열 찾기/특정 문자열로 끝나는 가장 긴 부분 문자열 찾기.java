class Solution {
    public String solution(String myString, String pat) {
        System.out.println(myString.indexOf(pat));
        System.out.println(pat.length());
        return myString.substring(0, myString.lastIndexOf(pat) + pat.length());
    }
}