import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] nums = new long[n+1];
        long[] sums = new long[n+1];
        long[] residues = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            sums[i] = (sums[i-1]+Integer.parseInt(st.nextToken()))%m;
            residues[(int)sums[i]]++;
        }
        long count = 0;
        for(int i = 1 ; i < m ; i++){
            count += residues[i]*(residues[i]-1)/2;
        }
        count += residues[0]*(residues[0]+1)/2;
        System.out.println(count);

    } // void main()
} //Class Main