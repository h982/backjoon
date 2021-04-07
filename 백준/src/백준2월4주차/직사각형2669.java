package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 직사각형2669 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "1 2 4 4\n" +
            "2 3 5 7\n" +
            "3 1 6 5\n" +
            "7 3 8 6";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = 4;
        int[][] map = new int[100][100];
        StringTokenizer str;
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(input.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());

            for(int j = x1; j < x2; j++){
                for(int k = y1; k < y2; k++)
                    map[j][k] = 1;
            }
        }
        int sum = 0;
        for(int[] row : map){
            for(int cell : row)
                sum += cell;
        }
        System.out.println(sum);
    }
}
