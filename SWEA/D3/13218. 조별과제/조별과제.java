import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            if(n<3) {
                sb.append("#"+test_case+" "+0+"\n");
            } else {
                sb.append("#"+test_case+" "+(n/3)+"\n");
            }

        }
        System.out.println(sb);
    }
}