package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class 그대로출력하기11718 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "Hello\n" +
            "Baekjoon\n" +
            "Online Judge";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        String temp;
        while((temp = input.readLine()) != null) {
            output.append(temp + "\n");
        }
        System.out.println(output);
    }
}
