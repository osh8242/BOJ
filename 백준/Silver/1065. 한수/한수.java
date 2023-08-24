import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isHansu(i)) count++;
        }
        System.out.println(count);

    }

    static boolean isHansu(int num) {
        if(num == 1000) return false;
        if (num / 100 == 0) return true;
        int a = num % 10;
        int b = num / 10 % 10;
        int c = num / 100 % 10;
        if (c - b == b - a) return true;
        return false;
    }


}
