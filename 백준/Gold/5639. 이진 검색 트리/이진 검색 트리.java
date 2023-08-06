import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static class Node {
        int value;
        boolean isVisit;
        Node leftNode;
        Node rightNode;
        Node parentNode;

        public Node(int value) {
            this.value = value;
            this.isVisit = false;
            this.leftNode = null;
            this.rightNode = null;
            this.parentNode = null;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node rootNode = new Node(Integer.parseInt(br.readLine()));
        String str;
        while (true) {
            str = br.readLine();
            if (str == null || str.equals(""))
                break;
            Node node = new Node(Integer.parseInt(str));
            addNode(rootNode, node);
        }
        postorder(rootNode);
        System.out.println(sb);

    }

    static void addNode(Node refNode, Node node) {
        if (refNode.value > node.value) {
            if (refNode.leftNode == null) {
                node.parentNode = refNode;
                refNode.leftNode = node;
            } else {
                addNode(refNode.leftNode, node);
            }
        } else if (refNode.value < node.value) {
            if (refNode.rightNode == null) {
                node.parentNode = refNode;
                refNode.rightNode = node;
            } else {
                addNode(refNode.rightNode, node);
            }
        }
    }

    static void postorder(Node refNode){
        if(refNode.leftNode != null && !refNode.leftNode.isVisit) postorder(refNode.leftNode);
        else if (refNode.rightNode != null && !refNode.rightNode.isVisit) postorder(refNode.rightNode);
        else {
            refNode.isVisit = true;
            sb.append(refNode.value+"\n");
            if(refNode.parentNode == null) return;
            postorder(refNode.parentNode);
        }
    }
}
