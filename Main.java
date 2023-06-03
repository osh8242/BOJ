import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

    static class Node{
        public int value;
        public int index;
        public Node pNode;
        public Node cNodeLeft;
        public Node cNodeRight;
        public Node(int value, int index){
            this.value = value;
            this.index = index;
            this.pNode = null;
            this.cNodeLeft = null;
            this.cNodeRight = null;
        }
        public void setpNode(Node pNode){
            this.pNode = pNode;
        }
        public void setcNodeLeft(Node cNode){
            this.cNodeLeft = cNode;
        }
        public void setcNodeRight(Node cNode){
            this.cNodeRight = cNode;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> nodes = new ArrayList<>();
        int root = Integer.parseInt(br.readLine());
        int currentIndex = 0;
        nodes.add(new Node(root, nodes.size()));
        String line;
        while((line = br.readLine()) != null){
            int value = Integer.parseInt(line);
            Node pNode = nodes.get(currentIndex);


        }
        System.out.println("end");

    }

}
