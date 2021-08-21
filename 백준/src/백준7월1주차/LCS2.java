import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String a = input.readLine();
        String b = input.readLine();

        int[][] dp = new int[a.length()+1][b.length()+1];
        String[][]dps = new String[a.length()+1][b.length()+1];
        for(int i = 0; i <= a.length(); i++){
            dps[i][0] = "";
        }
        for(int i = 0; i <= b.length(); i++){
            dps[0][i] = "";
        }

        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                int prev = 0;
                String temp = "";
                if(up >= left){
                    prev = up;
                    temp = dps[i-1][j];
                }else{
                    prev = left;
                    temp = dps[i][j-1];
                }

                if(a.charAt(i-1) == b.charAt(j-1)){
                    prev++;
                    temp += a.charAt(i-1);
                }
                dp[i][j] = prev;
                dps[i][j] = temp;
            }
        }
        for(int i = 0; i <= a.length(); i++){
            for(int j = 0; j <=b.length(); j++){
                System.out.printf(dps[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[a.length()][b.length()]);
        System.out.println(dps[a.length()][b.length()]);
    }
}
