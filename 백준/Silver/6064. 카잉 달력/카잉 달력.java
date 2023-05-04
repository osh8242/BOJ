import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        outer:for(int test_case = 1 ; test_case <= T ; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int year;
            int step;
            int yearCompared;
            int stepCompared;
            if(m > n) {
                step = n; year = y; stepCompared = m; yearCompared = x;

            } else {
                step = m; year = x; stepCompared = n; yearCompared = y;
            }
            int maxYear = getCommonMultiple(m,n);
            for( ; year <= maxYear ; year += step){
                if((year%stepCompared) == yearCompared%stepCompared) {
                    sb.append(year+"\n");
                    continue outer;
                }
            }
            sb.append(-1+"\n");
        }
        System.out.println(sb.toString());
    }

    public static int getCommonMultiple(int m, int n){
        int maxCommonFactor = 1;
        if(Math.max(m,n)%Math.min(m,n) == 0) return Math.max(m,n);
        for(int i = 2 ; i <= Math.sqrt(Math.min(m,n))  ; i++){
            if(m%i==0 && n%i==0){
                maxCommonFactor = i;
            }
        }
        return m*n/maxCommonFactor;
    }
}