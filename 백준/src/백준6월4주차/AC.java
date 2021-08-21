import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
public class AC {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            char[] oper = input.readLine().toCharArray();
            int n = Integer.parseInt(input.readLine());
            queue = new LinkedList<>();
            String in = input.readLine();
            String[] splitedString = in.substring(1, in.length()-1).split(",");
            for(int i = 0; i < n; i++){
                queue.add(Integer.parseInt(splitedString[i]));
            }
            boolean front = true;
            boolean error = false;
            for(int i = 0; i < oper.length; i++){
                if(oper[i] == 'R'){
                    front = !front;
                    continue;
                }
                if(queue.isEmpty()){
                    error = true;
                    break;
                }
                if(front){
                    queue.pollFirst();
                }else{
                    queue.pollLast();
                }
            }
            if(error){
                output.append("error" + "\n");
                continue;
            }
            output.append("[");
            if(queue.size() == 0){
                output.append(" ");
            }
            if(front) {
                for(int num : queue){
                    output.append(num + ",");
                }
            }else{
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    output.append(queue.pollLast() + ",");
                }
            }
            output.setLength(output.length()-1);
            output.append("]" + "\n");
        }
        System.out.println(output);
    }
    static Deque<Integer> queue;
}
