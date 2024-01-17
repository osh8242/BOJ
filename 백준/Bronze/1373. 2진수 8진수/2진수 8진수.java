import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] binaryArr = br.readLine().toCharArray();
        int length = binaryArr.length;
        for (int i = length >= 3 ? length -3 : 0 ; i >= 0; ) {
            int tempSum = 0;
            char[] temp = Arrays.copyOfRange(binaryArr, i, i + (i != 0 || length % 3 == 0 ? 3 : length % 3));

            int index = 1;
            for (int j = temp.length - 1; j >= 0; j--) {
                tempSum += index * (temp[j] - 48);
                index *= 2;
            }
            sb.insert(0, tempSum);
            if (i == 0) break;
            i -= Math.min(i, 3);
        }
        System.out.println(sb);
    }

}