import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 마리오 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static String src = "14\n"
            +"1 50 1 -1 1 3 -5 1 -15 0 100 1 1 2";
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new int[N+1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 1 ; i <= N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = map[1];
        for(int i = 2; i <= N; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]) + map[i];
        }
        System.out.println(Math.max(dp[N], dp[N-1]));
    }
    static int N;
    static int[] map;
}
