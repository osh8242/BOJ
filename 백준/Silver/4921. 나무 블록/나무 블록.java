import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static final boolean[][] isValidNextBlock;

    static {
        isValidNextBlock = new boolean[9][9];
        isValidNextBlock[1][4] = true;
        isValidNextBlock[1][5] = true;
        isValidNextBlock[3][4] = true;
        isValidNextBlock[3][5] = true;
        isValidNextBlock[4][2] = true;
        isValidNextBlock[4][3] = true;
        isValidNextBlock[5][8] = true;
        isValidNextBlock[6][2] = true;
        isValidNextBlock[6][3] = true;
        isValidNextBlock[7][8] = true;
        isValidNextBlock[8][6] = true;
        isValidNextBlock[8][7] = true;
    }

    public static void main(String[] args) throws IOException {
        String line;
        int index = 1;
        while (!(line = br.readLine()).equals("0")) {

            if(!line.startsWith("1") || !line.endsWith("2")) {
                append(index++, false);
                continue;
            }

            boolean isValid = true;
            for (int i = 1; i < line.length(); i++) {
                int prev = Character.getNumericValue(line.charAt(i - 1));
                int current = Character.getNumericValue(line.charAt(i));
                if(!isValidNextBlock[prev][current]) {
                    append(index++, false);
                    isValid = false;
                    break;
                }
            }

            if(isValid) append(index++, true);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void append(int index, boolean isValid) {
        sb.append(index).append(". ").append(isValid ? "VALID" : "NOT").append("\n");
    }

}
