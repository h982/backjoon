package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class 백준123더하기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "4\n" +
            "7\n" +
            "10";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(input.readLine());

            int[] arr = new int[N+1];
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            for(int i = 4; i <= N; i++){
                arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
            }
            System.out.println(arr[N]);
        }
    }
}
