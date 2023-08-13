import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while ((str = br.readLine()) != null) {
            int[] count = new int[4];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 97) count[0]++;
                else if (ch >= 65) count[1]++;
                else if (ch >= 48) count[2]++;
                else count[3]++;
            }
            for (int i = 0; i < count.length; i++) {
                sb.append(count[i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

}
