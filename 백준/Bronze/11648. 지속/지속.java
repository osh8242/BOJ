import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            String num = br.readLine();
            int count = getStageCount(num);

            bw.write(Integer.toString(count));
            bw.flush();
        }
    }

    static int getStageCount(String num) {
        int count = 0;
        int value = Integer.parseInt(num);
        while (value >= 10) {
            value = proceedStage(Integer.toString(value));
            count++;
        }
        return count;
    }

    static int proceedStage(String num) {
        int answer = Character.getNumericValue(num.charAt(0));
        for(int i = 1; i < num.length(); i++) {
            answer *= Character.getNumericValue(num.charAt(i));
        }
        return answer;
    }

}
