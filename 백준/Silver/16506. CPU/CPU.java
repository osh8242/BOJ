import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static String toBin(int x, int w) {
        StringBuilder b = new StringBuilder();
        for (int i = w - 1; i >= 0; i--) {
            b.append(((x >> i) & 1) == 1 ? '1' : '0');
        }
        return b.toString();
    }
    public static void main(String[] args) throws IOException {
        Map<String,Integer> op = new HashMap<>();
        op.put("ADD",   0b00000);
        op.put("ADDC",  0b00001);
        op.put("SUB",   0b00010);
        op.put("SUBC",  0b00011);
        op.put("MOV",   0b00100);
        op.put("MOVC",  0b00101);
        op.put("AND",   0b00110);
        op.put("ANDC",  0b00111);
        op.put("OR",    0b01000);
        op.put("ORC",   0b01001);
        op.put("NOT",   0b01010);
        op.put("MULT",  0b01100);
        op.put("MULTC", 0b01101);
        op.put("LSFTL", 0b01110);
        op.put("LSFTLC",0b01111);
        op.put("LSFTR", 0b10000);
        op.put("LSFTRC",0b10001);
        op.put("ASFTR", 0b10010);
        op.put("ASFTRC",0b10011);
        op.put("RL",    0b10100);
        op.put("RLC",   0b10101);
        op.put("RR",    0b10110);
        op.put("RRC",   0b10111);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken();
            int rd = Integer.parseInt(st.nextToken());
            int ra = Integer.parseInt(st.nextToken());
            String last = st.nextToken();
            int code = op.get(opcode);

            out.append(toBin(code,5))
               .append('0')
               .append(toBin(rd,3))
               .append(toBin(ra,3));
            if ((code & 1) == 1) {
                int imm = Integer.parseInt(last);
                out.append(toBin(imm,4));
            } else {
                int rb = Integer.parseInt(last);
                out.append(toBin(rb,3))
                   .append('0');
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}
