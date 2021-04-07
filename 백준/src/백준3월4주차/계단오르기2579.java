package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class 계단오르기2579 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "10\n" +
            "20\n" +
            "15\n" +
            "25\n" +
            "10\n" +
            "20";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        int[] arr = new int[N+1];
        int[][] max_arr = new int[N+1][2];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }

        max_arr[1][0] = arr[1];
        for(int i = 2; i <= N; i++){
            max_arr[i][0] = arr[i] + Math.max(max_arr[i-2][0], max_arr[i-2][1]);
            max_arr[i][1] = max_arr[i-1][0] + arr[i];
        }
        System.out.println(Math.max(max_arr[N][0], max_arr[N][1]));
    }
}
