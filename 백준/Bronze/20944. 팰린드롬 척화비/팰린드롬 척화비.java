import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] result = new char[N];
        Arrays.fill(result, 'a');
        byte[] outputBytes = String.valueOf(result).getBytes(StandardCharsets.UTF_8);
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        bos.write(outputBytes);
        bos.flush();
    }
}
