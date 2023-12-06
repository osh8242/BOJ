import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int T = Integer.parseInt(br.readLine());
      while (T-- > 0) {
         int num = Integer.parseInt(br.readLine());
         int answer = 1;
         while (num != 1) {
            if (answer < num)
               answer = num;
            num = getNextNum(num);
         }
         sb.append(answer).append("\n");
      }
      System.out.println(sb);
   }

   static int getNextNum(int num) {
      return num % 2 == 0 ? num / 2 : num * 3 + 1;
   }
}