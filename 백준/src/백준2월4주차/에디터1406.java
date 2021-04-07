package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class 에디터1406 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "abcd\n" +
            "3\n" +
            "P x\n" +
            "L\n" +
            "P y";

//    public static void main(String[] args) throws IOException {
//        input = new BufferedReader(new StringReader(src));
//
//        List<Character> list = new ArrayList<>();
//        String first = input.readLine();
//        for(int i = 0; i < first.length(); i++){
//            list.add(first.charAt(i));
//        }
//        int N = Integer.parseInt(input.readLine());
//        String str;
//        int cursor = list.size();
//        for(int i = 0; i < N; i++){
//            str = input.readLine();
//            switch (str.charAt(0)){
//                case 'L':
//                    cursor--;
//                    if(cursor < 0)
//                        cursor++;
//                    break;
//                case 'D':
//                    cursor++;
//                    if(cursor > list.size())
//                        cursor--;
//                    break;
//                case 'B':
//                    if(cursor != 0)
//                        list.remove(--cursor);
//                    break;
//                case 'P':
//                    list.add(cursor++, str.charAt(2));
//                    break;
//            }
//        }
//        for(char var : list)
//            output.append(var);
//        System.out.println(output);
//    }
//    public static void main(String[] args) throws IOException{
//        input = new BufferedReader(new StringReader(src));
//
//        output.append(input.readLine());
//        int N = Integer.parseInt(input.readLine());
//        String str;
//        int cursor = output.length();
//        for(int i = 0; i < N; i++){
//            str = input.readLine();
//            switch (str.charAt(0)){
//                case 'L':
//                    cursor--;
//                    if(cursor < 0)
//                        cursor++;
//                    break;
//                case 'D':
//                    cursor++;
//                    if(cursor > output.length())
//                        cursor--;
//                    break;
//                case 'B':
//                    if(cursor != 0)
//                        output.replace(--cursor, cursor+1, "");
//                    break;
//                case 'P':
//                    output.insert(cursor++,str.charAt(2));
//                    break;
//            }
//        }
//        System.out.println(output);
//    }
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        Stack<Character> stack_L = new Stack<>();
        Stack<Character> stack_R = new Stack<>();

        String str = input.readLine();
        for(int i = 0; i < str.length(); i++){
            stack_L.add(str.charAt(i));
        }
        int N = Integer.parseInt(input.readLine());
        for(int i = 0; i < N; i++) {
            str = input.readLine();
            switch (str.charAt(0)) {
                case 'L':
                    if(!stack_L.isEmpty())
                        stack_R.add(stack_L.pop());
                    break;
                case 'D':
                    if(!stack_R.isEmpty())
                        stack_L.add(stack_R.pop());
                    break;
                case 'B':
                    if(!stack_L.isEmpty())
                        stack_L.pop();
                    break;
                case 'P':
                    stack_L.add(str.charAt(2));
                    break;
            }
        }
        for(char a : stack_L)
            output.append(a);
        while(!stack_R.isEmpty())
            output.append(stack_R.pop());

        System.out.println(output);
    }
}
