import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        if (month < 2) {
            System.out.println("Before");
        } else if (month >= 3) {
            System.out.println("After");
        } else {
            System.out.println(day < 18 ? "Before" : day > 18 ? "After" : "Special");
        }
    }
}