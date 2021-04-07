package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 평범한배낭128665 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 7\n" +
            "6 13\n" +
            "4 8\n" +
            "3 6\n" +
            "5 12";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N+1];
        int[] V = new int[N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(input.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        int[][] bags = new int[N+1][K+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(j - W[i] >= 0){
                    bags[i][j] = Math.max(bags[i-1][j], bags[i-1][j-W[i]] + V[i]);
                }else{
                    bags[i][j] = bags[i-1][j];
                }
            }
        }
        System.out.println(bags[N][K]);
    }
}
