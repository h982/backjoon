package 백준4월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형1932 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5\n" +
            "7\n" +
            "3 8\n" +
            "8 1 0\n" +
            "2 7 4 4\n" +
            "4 5 2 6 5";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer st;
        int N = Integer.parseInt(input.readLine());

        int[][] triangle = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < i+1; j++)
                triangle[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] route = new int[N][N];
        route[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i+1; j++){
                 int left = 0;
                 int right = route[i-1][j];
                 if(j-1 >= 0)
                     left = route[i-1][j-1];
                 route[i][j] = Math.max(left, right) + triangle[i][j];
            }
        }
        Arrays.sort(route[N-1]);
        System.out.println(route[N-1][N-1]);
    }

}
