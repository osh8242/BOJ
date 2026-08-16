import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char ch: charArr) sb.append(ch).append('\n');
        System.out.print(sb.toString().trim());
    }
}