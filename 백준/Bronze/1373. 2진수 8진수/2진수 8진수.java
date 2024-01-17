import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] binaryArr = br.readLine().toCharArray();
        int residue = binaryArr.length % 3;
        if (residue % 3 == 1) {
            sb.append(binaryArr[0]);
        }
        if (residue % 3 == 2) {
            sb.append(2 * (binaryArr[0] - '0') + (binaryArr[1] - '0'));
        }
        for (int i = residue; i < binaryArr.length; i += 3) {
            sb.append(binaryArr[i + 2] - '0' + 2 * (binaryArr[i + 1] - '0') + 4 * (binaryArr[i] - '0'));
        }
        System.out.println(sb);
    }

}