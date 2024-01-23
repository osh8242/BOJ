import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static char[][] code;

    static {
        code = new char[91][91];

        code['A']['A'] = 'A';
        code['A']['G'] = 'C';
        code['A']['C'] = 'A';
        code['A']['T'] = 'G';

        code['G']['A'] = 'C';
        code['G']['G'] = 'G';
        code['G']['C'] = 'T';
        code['G']['T'] = 'A';

        code['C']['A'] = 'A';
        code['C']['G'] = 'T';
        code['C']['C'] = 'C';
        code['C']['T'] = 'G';

        code['T']['A'] = 'G';
        code['T']['G'] = 'A';
        code['T']['C'] = 'G';
        code['T']['T'] = 'T';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char[] series = br.readLine().toCharArray();
        char lastCh = series[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            lastCh = code[series[i]][lastCh];
        }
        System.out.println(lastCh);
    }

}