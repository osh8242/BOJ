import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      int[] nums = new int[T];
      StringTokenizer st = new StringTokenizer(br.readLine());
      long answer = 0;
      for (int i = 0; i < T; i++) {
         nums[i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < T; i++) {
         for (int j = i + 1; j < T; j++) {
            answer += Math.abs(nums[i] - nums[j]);
         }
      }
      System.out.println(answer * 2);
   }
}