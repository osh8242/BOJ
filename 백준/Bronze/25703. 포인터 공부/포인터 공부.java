import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       sb.append("int a;\n");
       int N = Integer.parseInt(br.readLine());
       String stars = new String(new char[N]).replace('\0', '*');
       for (int n = 1; n <= N; n++) {
           sb.append("int ");
           sb.append(stars, 0, n);
           sb.append("ptr");
           if (n != 1) sb.append(n);
           sb.append(" = &");
           if (n == 1) {
               sb.append("a");
           } else {
               sb.append("ptr");
               if (n - 1 != 1) sb.append(n - 1);
           }
           sb.append(";\n");
       }
       System.out.print(sb);
   }
}
