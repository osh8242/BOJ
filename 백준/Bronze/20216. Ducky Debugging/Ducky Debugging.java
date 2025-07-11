import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true); // autoFlush = true
        String line;
        while ((line = in.readLine()) != null) {
            if (line.equals("I quacked the code!")) {
                break;
            } else if (line.endsWith("?")) {
                out.println("Quack!");
            } else if (line.endsWith(".")) {
                out.println("*Nod*");
            }
        }
    }
}
