package 백준4월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class 쉬운계단수10844 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "2";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        int[][] arr = new int[N][10];
        for(int i = 1; i < 10; i++)
            arr[0][i] = 1;
        for(int i = 1; i < N; i++){
            arr[i][0] = arr[i-1][1];
            arr[i][9] = arr[i-1][8];
            for(int j = 1; j < 9; j++){
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1];
                arr[i][j] %= 1000000000;
            }
        }
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += arr[N-1][i];
            sum %= 1000000000;
        }
        System.out.println(sum);
    }
}
