import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numsAsString = br.readLine().split(",");
        System.out.println(Arrays.stream(numsAsString).mapToInt(Integer::parseInt).sum());
    }
}