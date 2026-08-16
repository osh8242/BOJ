import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(value).append(" is ").append(
            value % 2 == 0 ? "even" : "odd"
        );
        System.out.print(sb.toString());
    }
}