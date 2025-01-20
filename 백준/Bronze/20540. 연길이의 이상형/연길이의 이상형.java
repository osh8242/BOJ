import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] mbti = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(mbti[0] == 'E' ? 'I' : 'E');
        sb.append(mbti[1] == 'S' ? 'N' : 'S');
        sb.append(mbti[2] == 'T' ? 'F' : 'T');
        sb.append(mbti[3] == 'J' ? 'P' : 'J');
        System.out.println(sb);
    }
}
