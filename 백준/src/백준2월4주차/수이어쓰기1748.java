package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class 수이어쓰기1748 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "120";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());

        int log_N = (int)Math.log10(N);
        int sum = 0;
        sum += (log_N + 1) * (N - Math.pow(10, log_N) + 1);
        while(log_N > 0){
            sum += log_N  * (Math.pow(10, log_N) - Math.pow(10, log_N-1));
            log_N--;
        }

        System.out.println(sum);
    }
}
