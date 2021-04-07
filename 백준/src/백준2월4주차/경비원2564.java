package 백준2월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 경비원2564 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "10 5\n" +
            "3\n" +
            "1 4\n" +
            "3 2\n" +
            "2 8\n" +
            "2 3";

    public static void main(String[] args)throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        width = Integer.parseInt(str.nextToken());
        height = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(input.readLine());

        int[][]loc = new int[N][];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(input.readLine());
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(str.nextToken());
            temp[1] = Integer.parseInt(str.nextToken());

            loc[i] = temp;
        }
        int[] dongGn = new int[2];
        str = new StringTokenizer(input.readLine());
        dongGn[0] = Integer.parseInt(str.nextToken());
        dongGn[1] = Integer.parseInt(str.nextToken());

        int dong_dist = calculate(dongGn[0], dongGn[1]);

        int ans = 0;
        int total_dist = width + width + height + height;
        int[] dist = new int[N];
        for(int i = 0; i < N; i++){
            dist[i] = Math.abs(calculate(loc[i][0], loc[i][1]) - dong_dist);
            ans += Math.min(dist[i], total_dist - dist[i]);
        }

        System.out.println(ans);

    }
    static int width, height;
    // 시계방향으로 계산 통일
    static int calculate(int loc, int dist){
        switch (loc){
            case 1:
                return dist;

            case 2:
                return width + height + width - dist;

            case 3:
                return width + height + width + height - dist;

            case 4:
                return width + dist;
        }
        return 0;
    }
}
