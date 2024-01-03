import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while (true) {
            line = br.readLine();
            if (line.charAt(0) == '#') break;
            char[] charArr = line.toCharArray();
            int index = 1;
            int answer = 0;
            for (char ch : charArr) {
                if (ch != ' ') answer += index * (ch - 64);
                index++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}