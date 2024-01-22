package _2024.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1991 {
    static List<Node> node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Character, Node> nodes = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char parentValue = st.nextToken().charAt(0);
            char leftChildValue = st.nextToken().charAt(0);
            char rightChildValue = st.nextToken().charAt(0);

            Node parentNode = nodes.getOrDefault(parentValue, new Node(parentValue));
            Node leftChildNode = leftChildValue == '.' ? null : new Node(leftChildValue);
            Node rightChildNode = rightChildValue == '.' ? null : new Node(rightChildValue);

            parentNode.left = leftChildNode;
            parentNode.right = rightChildNode;

            nodes.put(parentValue, parentNode);
            if(leftChildNode != null){
                nodes.put(leftChildValue, leftChildNode);
            }
            if(rightChildNode != null){
                nodes.put(rightChildValue, rightChildNode);
            }
        }
        Node root = nodes.get('A');

        preorder(root);
        System.out.println();

        inorder(root);
        System.out.println();
        postorder(root);



    }

    private static void preorder(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.value);
        preorder(root.left);
        preorder(root.right);

    }
    private static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.value);
        inorder(root.right);

    }
    private static void postorder(Node root) {
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value);


    }




    static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value){
            this.value = value;
            this.left = null;
            this.right = null;

        }

    }
}
