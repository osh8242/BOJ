import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int a = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    if ((k - a) % d != 0) {
      System.out.println("X");
      return;
    }
    
    int n = (k - a) / d + 1;
    if (n < 1) {
      System.out.println("X");
    } else {
      System.out.println(n);
    }
  }
}
