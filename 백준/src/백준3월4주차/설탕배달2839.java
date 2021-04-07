package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class 설탕배달2839 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "16";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());

        int[]min_bags = new int[N+5];
        min_bags[3] = 1;
        min_bags[5] = 1;
        for(int i = 6; i <= N; i++){
            if(min_bags[i-3] == 0 && min_bags[i-5] == 0)
                continue;

            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;

            if(min_bags[i-3] != 0)
                a = min_bags[i-3];
            if(min_bags[i-5] != 0)
                b = min_bags[i-5];
            min_bags[i] = Math.min(a,b) + 1;
        }
        System.out.println(min_bags[N]==0 ? -1: min_bags[N]);
    }
}
