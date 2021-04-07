package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class 백준2n타일링 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "10";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        if(N <= 2){
            System.out.println(N);
            return;
        }

        int a = 1;
        int b = 2;
        for(int i = 3; i <= N; i++){
            int temp = b;
            b = (a + b)%10007;
            a = temp;
        }
        System.out.println(b);
    }
}
