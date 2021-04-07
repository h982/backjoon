package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 어린왕자1004 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer str;
    static String src = "2\n" +
            "-5 1 12 1\n" +
            "7\n" +
            "1 1 8\n" +
            "-3 -1 1\n" +
            "2 2 2\n" +
            "5 5 1\n" +
            "-4 5 1\n" +
            "12 1 1\n" +
            "12 1 2\n" +
            "-5 1 5 1\n" +
            "1\n" +
            "0 0 2";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int x1,y1,x2,y2;
            str = new StringTokenizer(input.readLine());
            x1 = Integer.parseInt(str.nextToken());
            y1 = Integer.parseInt(str.nextToken());
            x2 = Integer.parseInt(str.nextToken());
            y2 = Integer.parseInt(str.nextToken());

            int N = Integer.parseInt(input.readLine());
            int[][] stars = new int[N][];
            for(int i = 0; i < N; i++){
                str = new StringTokenizer(input.readLine());
                int[] temp = new int[3];
                for(int j = 0; j < 3; j++)
                    temp[j] = Integer.parseInt(str.nextToken());
                stars[i] = temp;
            }
            boolean[] isIn_s = new boolean[N];
            boolean[] isIn_e = new boolean[N];
            for(int i = 0; i < N; i++){
                int[] temp = stars[i];
                int dist_x = Math.abs(temp[0] - x1);
                int dist_y = Math.abs(temp[1] - y1);
                if(dist_x * dist_x + dist_y * dist_y < temp[2] * temp[2]){
                    isIn_s[i] = true;
                }
                dist_x = Math.abs(temp[0] - x2);
                dist_y = Math.abs(temp[1] - y2);
                if(dist_x * dist_x + dist_y * dist_y < temp[2] * temp[2]){
                    isIn_e[i] = true;
                }
            }
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(isIn_e[i] && isIn_s[i]){
                    continue;
                }else if(!isIn_e[i] && !isIn_s[i]){
                    continue;
                }else{
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
