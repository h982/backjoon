import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공통부분문자열 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String A = input.readLine();
        String B = input.readLine();

        int max = 0;
        int[][] dp = new int[A.length()+1][B.length()+1];
        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j] > max)
                        max = dp[i][j];
                    continue;
                }
            }
        }
        System.out.println(max);
    }
}
