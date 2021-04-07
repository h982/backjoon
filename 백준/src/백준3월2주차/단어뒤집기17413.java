package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;


public class 단어뒤집기17413 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "one1 two2 three3 4fourr 5five 6six";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        Stack<Character> stack = new Stack<>();
        String line = input.readLine();
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '<'){
                while(!stack.isEmpty())
                    output.append(stack.pop());

                output.append(line.charAt(i));
                do{
                    i++;
                    output.append(line.charAt(i));
                }while (line.charAt(i) != '>');

                continue;
            }

            if(line.charAt(i) == ' '){
                while(!stack.isEmpty())
                    output.append(stack.pop());
                output.append(" ");
            }
            else{
                stack.add(line.charAt(i));
            }
        }
        while(!stack.isEmpty())
            output.append(stack.pop());

        System.out.println(output);
    }
}
