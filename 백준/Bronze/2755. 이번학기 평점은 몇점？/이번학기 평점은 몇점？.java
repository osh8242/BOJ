import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalUnit = 0;
        double totalPoint = 0;
        while (N-- > 0) {
            String[] line = br.readLine().split(" ");
            int unit = Integer.parseInt(line[1]);
            totalUnit += unit;
            char[] gradeArr = line[2].toCharArray();
            char grade = gradeArr[0];
            char param = gradeArr.length > 1 ? gradeArr[1] : 0;
            totalPoint += unit * getPoint(grade, param);
        }
        System.out.printf("%.2f", totalPoint / totalUnit);
    }

    static double getPoint(char ch, char param) {
        double result = 0;

        switch (ch) {
            case 'A':
                result = 4;
                break;
            case 'B':
                result = 3;
                break;
            case 'C':
                result = 2;
                break;
            case 'D':
                result = 1;
                break;
        }

        switch (param) {
            case '+':
                result += 0.3;
                break;
            case '-':
                result -= 0.3;
                break;
        }

        return result;
    }

}