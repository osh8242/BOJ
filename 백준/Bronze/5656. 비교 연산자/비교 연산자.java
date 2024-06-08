import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int index = 1;
        String line;
        while((line = br.readLine()) != null){
            String[] inputs = line.split(" ");
            int a = Integer.parseInt(inputs[0]);
            String op = inputs[1];
            int b = Integer.parseInt(inputs[2]);
            if(op.equals("E")) break;
            boolean isRight = discriminate(a, op, b);
            sb.append("Case ").append(index++).append(": ").append(isRight).append("\n");
        }
        System.out.print(sb.toString());
    }

    static boolean discriminate(int a, String op, int b){
        return switch (op) {
            case ">" -> a > b;
            case ">=" -> a >= b;
            case "<" -> a < b;
            case "<=" -> a <= b;
            case "==" -> a == b;
            case "!=" -> a != b;
            default -> false;
        };
    }
}
