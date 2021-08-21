import java.util.Scanner;

public class 합분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[][] dp = new long[K + 1][N + 1];

        // K = 1;
        for(int i = 0; i <= N; i++){
            dp[1][i] = 1;
        }

        for(int k = 1; k <= K; k++){
            for(int n = 0; n <= N; n++){
                for(int L = N; L >= 0; L--){
                    dp[k][n] += dp[k-1][N-L];
                    dp[k][n] %= 1000000000;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
