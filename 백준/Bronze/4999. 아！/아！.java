import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fisrt = br.readLine();
        String second = br.readLine();

        String answer = fisrt.length() >= second.length() ? "go" : "no";
        System.out.println(answer);
    }

}
