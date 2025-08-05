import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] A = new int[n];
            S = new long[n + 1];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                S[i+1] = S[i] + A[i];
            }
            boolean found = false;
            outer:
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i + len <= n; i++) {
                    long sum = S[i+len] - S[i];
                    if (isPrime(sum)) {
                        System.out.print("Shortest primed subsequence is length " + len + ":");
                        for (int k = i; k < i+len; k++) System.out.print(" " + A[k]);
                        System.out.println();
                        found = true;
                        break outer;
                    }
                }
            }
            if (!found) {
                System.out.println("This sequence is anti-primed.");
            }
        }
    }
    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long p: new long[]{2,3,5,7,11,13,17,19,23,29,31,37}) {
            if (n%p==0) return n==p;
        }
        long d = n-1, s = 0;
        while ((d&1)==0) {d>>=1; s++;}
        for (long a: new long[]{2,325,9375,28178,450775,9780504,1795265022}) {
            if (a%n==0) continue;
            long x = modPow(a, d, n);
            if (x==1 || x==n-1) continue;
            boolean comp = true;
            for (int r=1; r<s; r++) {
                x = mul(x,x,n);
                if (x==n-1) { comp=false; break; }
            }
            if (comp) return false;
        }
        return true;
    }
    static long mul(long a,long b,long mod){ return (a*b)%mod; }
    static long modPow(long a,long e,long mod){
        long r=1;
        while(e>0){
            if((e&1)==1) r=mul(r,a,mod);
            a=mul(a,a,mod);
            e>>=1;
        }
        return r;
    }
}
