package 백준4월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이친수2193 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(input.readLine());
        long[][] arr = new long[N][2];

        arr[0][0] = 1;
        for(int i = 1; i < N; i++){
            arr[i][0] = arr[i-1][1];
            arr[i][1] = arr[i-1][0] + arr[i-1][1];
        }
        System.out.println(arr[N-1][0] + arr[N-1][1]);
    }
}

