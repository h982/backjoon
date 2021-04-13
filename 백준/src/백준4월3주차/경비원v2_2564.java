package 백준4월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 경비원v2_2564 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "10 5\n" +
            "3\n" +
            "1 4\n" +
            "3 2\n" +
            "2 8\n" +
            "2 3";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer st = new StringTokenizer(input.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(input.readLine());
        int[][] map = new int[N][];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            map[i] = temp;
        }
        st = new StringTokenizer(input.readLine());
        int[] dongGn = new int[2];
        dongGn[0] = Integer.parseInt(st.nextToken());
        dongGn[1] = Integer.parseInt(st.nextToken());

        int min_dist = 0;
        int total_dist = 2*width + 2*height;
        int dognGn_dist = cal(dongGn[0], dongGn[1]);
        for(int i = 0; i < N; i++){
            int dist = cal(map[i][0], map[i][1]);
            int diff = Math.abs(dognGn_dist - dist);
            min_dist += Math.min(diff, total_dist-diff);
        }
        System.out.println(min_dist);
    }
    static int width, height;
    static int cal(int loc, int dist){
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
