import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 0; i < 3; i++) if (br.readLine().contains("7")) count++;

            bw.write(count == 3 ? "777" : "0");
            bw.flush();
        }
    }

}
