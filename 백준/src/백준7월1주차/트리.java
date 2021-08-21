import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        nodeList = new Node[N];
        for(int i = 0; i < N; i++)
            nodeList[i] = new Node(i);

        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp != -1) {
                nodeList[temp].children.add(nodeList[i]);
                nodeList[i].parent = nodeList[temp];
            }
        }
        int remove = Integer.parseInt(input.readLine());
        removeChild(remove);

        int result = 0;
        for(Node node : nodeList){
            if(node.isExist && node.children.isEmpty()){
                result++;
            }
        }
        System.out.println(result);
    }
    static Node[] nodeList;
    static void removeChild(int num){
        Node now = nodeList[num];

        now.isExist = false;
        for(Node child : now.children){
            removeChild(child.num);
        }
    }
    static class Node{
        int num;
        Node parent;
        boolean isExist;
        List<Node> children;

        public Node(int num){
            this.num = num;
            isExist = true;
            children = new ArrayList<>();
        }
    }
}
