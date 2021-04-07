package 백준2월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 미로찾기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "4 6\n" +
            "110110\n" +
            "110110\n" +
            "111111\n" +
            "111101\n"+
            "2 25\n" +
            "1011101110111011101110111\n" +
            "1110111011101110111011101\n" +
            "7 7\n" +
            "1011111\n" +
            "1110001\n" +
            "1000001\n" +
            "1000001\n" +
            "1000001\n" +
            "1000001\n" +
            "1111111";

    static char[][] rooms;
    static int N, M;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer str = new StringTokenizer(input.readLine());
            N = Integer.parseInt(str.nextToken());
            M = Integer.parseInt(str.nextToken());
            rooms = new char[N][];
            for(int i = 0; i < N; i++){
                rooms[i] = input.readLine().toCharArray();
            }


        }
        System.out.println(output);
    }
//    static int min_search;
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//    static boolean[][] visited;
//    private static void mapSearch(int row, int col, int count){
//
//        visited[row][col] = true;
//        for(int i = 0; i < 4; i++){
//            int d_row = row + dr[i];
//            int d_col = col + dc[i];
//            if(d_row >= 0 && d_row < N && d_col >= 0 && d_col < M){
//                if(rooms[d_row][d_col] == '1' && !visited[d_row][d_col]){
//                    mapSearch(d_row, d_col, count+1);
//                }
//            }
//        }
//        visited[row][col] = false;
//
//        if(row == N-1 && col == M-1){
//            if(min_search > count)
//                min_search = count;
//            return;
//        }
//    }

}
