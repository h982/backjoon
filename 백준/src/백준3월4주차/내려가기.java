package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 내려가기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "1 2 3\n" +
            "4 5 6\n" +
            "4 9 0";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        int[][] table = new int[N][];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++)
                temp[j] = Integer.parseInt(st.nextToken());
            table[i]= temp;
        }

        int[] prev = new int[3];
        int[] now = new int[3];
        for(int i = 0; i < N; i++){
            now[0] = table[i][0] + Math.max(prev[0], prev[1]);
            now[1] = table[i][1] + Math.max(Math.max(prev[0], prev[1]), prev[2]);
            now[2] = table[i][2] + Math.max(prev[1], prev[2]);

            System.arraycopy(now,0, prev, 0, 3);
        }
        output.append(Math.max(Math.max(now[0],now[1]),now[2]) + " ");

        prev = new int[3];
        now = new int[3];
        for(int i = 0; i < N; i++){
            now[0] = table[i][0] + Math.min(prev[0], prev[1]);
            now[1] = table[i][1] + Math.min(Math.min(prev[0], prev[1]), prev[2]);
            now[2] = table[i][2] + Math.min(prev[1], prev[2]);

            System.arraycopy(now,0, prev, 0, 3);
        }
        output.append(Math.min(Math.min(now[0],now[1]),now[2]));
        System.out.println(output);
    }
}
