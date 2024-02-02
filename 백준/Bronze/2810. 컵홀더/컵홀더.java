import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] seats = br.readLine().toCharArray();
        int S = 0;
        for (char seat : seats) if (seat == 'S') S++;
        System.out.println(Math.min(N, N + 1 - (N - S) / 2));
    }

}