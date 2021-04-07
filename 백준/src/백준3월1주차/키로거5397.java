package 백준3월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class 키로거5397 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "<<BP<A>>Cd-\n" +
            "ThIsIsS3Cr3t";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            String line = input.readLine();
            Stack<Character> stack_L = new Stack<>();
            Stack<Character> stack_R = new Stack<>();
            for(int i = 0; i < line.length(); i++){
                switch (line.charAt(i)){
                    case '<':
                        if(!stack_L.isEmpty())
                            stack_R.add(stack_L.pop());
                        break;
                    case '>':
                        if(!stack_R.isEmpty())
                            stack_L.add(stack_R.pop());
                        break;
                    case '-':
                        if(!stack_L.isEmpty())
                            stack_L.pop();
                        break;
                    default:
                        stack_L.add(line.charAt(i));
                }
            }
            for(char a : stack_L)
                output.append(a);
            while(!stack_R.isEmpty())
                output.append(stack_R.pop());
            output.append("\n");
        }
        System.out.println(output);
    }
}
