import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char ch : charArr) {
            if(ch >= 'a') sb.append((char) (ch - 32));
            else sb.append((char) (ch + 32));
        }
        System.out.print(sb.toString());
    }
}