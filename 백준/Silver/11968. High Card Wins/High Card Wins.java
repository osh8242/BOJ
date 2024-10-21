import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] isElsie = new boolean[2 * N + 1];
        int elsie = 0;
        int count = 0;
        while (N-- > 0) {
            isElsie[Integer.parseInt(br.readLine())] = true;
        }
        for (int i = 1; i < isElsie.length; i++) {
            if (isElsie[i]) elsie++;
            else if(elsie > 0) {
                elsie--;
                count++;
            }
        }
        System.out.println(count);
    }


}