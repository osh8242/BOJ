import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;

        while (!(input = br.readLine()).equals("#")) {
            char[] chars = input.toCharArray();
            int count = 0;
            
            for (char c : chars) if (c == '1') count++;
            
            chars[chars.length - 1] = (chars[chars.length - 1] == 'e') 
                                       ? (count % 2 == 0 ? '0' : '1') 
                                       : (count % 2 == 0 ? '1' : '0');
            sb.append(chars).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}
