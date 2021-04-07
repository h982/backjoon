package 백준2월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 성적통계 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src ="1 10";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        int M = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        boolean[]numbers = new boolean[N+1];

        for(int i = 2; i < N; i++){
            if(!numbers[i]){
                for(int j = i+i; j <= N; j += i){
                    numbers[j] = true;
                }
            }
        }
        for(int i = M; i <= N; i++)
            if(!numbers[i])
                System.out.println(i);

    }
}
