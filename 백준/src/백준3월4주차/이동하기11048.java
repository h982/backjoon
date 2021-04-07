package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 이동하기11048 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 3\n" +
            "1 2 3\n" +
            "6 5 4\n" +
            "7 8 9\n" +
            "12 11 10";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max_candy = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                int max = Math.max(Math.max(max_candy[i-1][j-1], max_candy[i-1][j]), max_candy[i][j-1]);
                max_candy[i][j] = max + map[i][j];
            }
        }
        System.out.println(max_candy[N][M]);
    }
}
