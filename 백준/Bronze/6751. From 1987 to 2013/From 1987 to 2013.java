import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        while (!isDistinct(++year)) {}
        System.out.println(year);
    }

    static boolean isDistinct(int year) {
        String temp = String.valueOf(year);
        Set<Character> set = new HashSet<>();
        for (char c : temp.toCharArray()) {
            if (!set.add(c)) return false;
        }
        return true;
    }

}
