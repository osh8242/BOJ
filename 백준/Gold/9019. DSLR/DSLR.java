import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class DSLR{
        public int[] digits;
        public StringBuilder cmd;
        DSLR(int d1, int d2, int d3, int d4){
            digits = new int[]{d1,d2,d3,d4};
            cmd = new StringBuilder();
        }
        DSLR(int[] digits){
            this.digits = digits.clone();
            cmd = new StringBuilder();
        }

        public void doubler(){
            int num = getValue()*2%10000;
            digits = valueToDigits(num);
            cmd.append("D");
        }
        public void subtract(){
            if(getValue()==0){
                digits = new int[]{9,9,9,9};
                cmd.append("S");
                return;
            }
            digits = valueToDigits(getValue()-1);
            cmd.append("S");
        }
        public void left(){
            int temp = digits[0];
            for(int i = 0 ; i < 3 ; i++){
                digits[i] = digits[i+1];
            }
            digits[3] = temp;
            cmd.append("L");
        }
        public void right(){
            int temp = digits[3];
            for(int i = 3 ; i > 0 ; i--){
                digits[i] = digits[i-1];
            }
            digits[0] = temp;
            cmd.append("R");
        }
        public int getValue(){
            return ((digits[0]*10+digits[1])*10+digits[2])*10+digits[3];
        }

    }

    static boolean[] isVisit;
    static Queue<DSLR> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1 ; test <= n ; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            isVisit = new boolean[10000];
            que = new LinkedList<>();
            sb.append(bfs(start,end)+"\n");
        }
        System.out.println(sb);

    } // main(){}

    static String bfs(int start, int end){
        que.add(new DSLR(valueToDigits(start)));
        isVisit[start] = true;
        while(que.size()>0){
            DSLR pnode = que.poll();
            if(pnode.getValue() == end) return pnode.cmd.toString();

            DSLR cnode;

            cnode = new DSLR(pnode.digits);
            cnode.cmd.append(pnode.cmd);
            cnode.doubler();
            addValidNode(cnode);

            cnode = new DSLR(pnode.digits);
            cnode.cmd.append(pnode.cmd);
            cnode.subtract();
            addValidNode(cnode);

            cnode = new DSLR(pnode.digits);
            cnode.cmd.append(pnode.cmd);
            cnode.left();
            addValidNode(cnode);

            cnode = new DSLR(pnode.digits);
            cnode.cmd.append(pnode.cmd);
            cnode.right();
            addValidNode(cnode);
        }

        return null;
    }

    static void addValidNode(DSLR node){
        if(!isVisit[node.getValue()]){
            isVisit[node.getValue()] = true;
            que.add(node);
        }
    }

    static int[] valueToDigits(int value){
        int d4 = value%10;
        int d3 = value/10%10;
        int d2 = value/100%10;
        int d1 = value/1000%10;
        return new int[]{d1,d2,d3,d4};
    }

} // class Main{}
