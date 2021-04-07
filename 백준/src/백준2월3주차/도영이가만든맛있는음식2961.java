package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식2961 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "1 7\n" +
            "2 6\n" +
            "3 8\n" +
            "4 9";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());
        foods = new int[N][];
        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(input.readLine());
            int[] food = new int[2];
            food[0] = Integer.parseInt(str.nextToken());
            food[1] = Integer.parseInt(str.nextToken());
            foods[i] = food;
        }
        min_diff = Integer.MAX_VALUE;
        calculate(0, 1, 0);
        System.out.println(min_diff);
    }
    static int N;
    static int[][]foods;
    static int min_diff;
    static void calculate(int idx, int sum_S, int sum_B){
        if(idx >= 1){
            int diff = Math.abs(sum_S - sum_B);
            if(diff < min_diff)
                min_diff = diff;
            if(idx == N)
                return;
        }

        for(int i = idx; i < N; i++){
            calculate(i+1, sum_S * foods[i][0], sum_B + foods[i][1]);
        }
    }
}
