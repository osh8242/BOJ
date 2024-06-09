import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine()) / 3;
            bw.write(String.valueOf((n - 1) * (n - 2) / 2));
            bw.flush();
        }
    }

}
