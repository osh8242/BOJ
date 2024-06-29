import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0")) {
            input = br.readLine();
            String[] times = input.split(" ");
            int index = 0;
            int distance = Integer.MAX_VALUE;
            for (int i = 0; i < times.length; i++) {
                int time = Integer.parseInt(times[i]);
                if (Math.abs(2023 - time) < distance) {
                    index = i;
                    distance = Math.abs(2023 - time);
                }

            }
            bw.write(String.valueOf(index + 1));
            bw.newLine();
        }
        bw.flush();
    }
}
