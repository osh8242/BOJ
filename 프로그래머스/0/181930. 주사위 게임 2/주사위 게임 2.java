import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c) {
        return a==b && b==c ? (a+b+c)*(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c) :
        a != b && b != c && c != a ? (a+b+c) :         (a+b+c)*(a*a+b*b+c*c);
    }
}