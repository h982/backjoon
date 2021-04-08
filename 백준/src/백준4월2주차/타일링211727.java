package 백준4월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class 타일링211727 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "1000";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());

        int[] arr = new int[N+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= N; i++){
            arr[i] = (arr[i-1] + 2 * arr[i-2]) % 10007;
        }
        System.out.println(arr[N]);
    }
}
