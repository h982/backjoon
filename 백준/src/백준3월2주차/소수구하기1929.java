package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 소수구하기1929 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src ="3 16";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int M = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        boolean[] numbers = new boolean[N+1];
        for(int i = 2; i <= N; i++){
            if(!numbers[i]){
                int temp = i * 2;
                while(temp <= N){
                    numbers[temp] = true;
                    temp += i;
                }
                if(i >= M){
                    output.append(i + "\n");
                }
            }
        }
        System.out.println(output);
    }
}
