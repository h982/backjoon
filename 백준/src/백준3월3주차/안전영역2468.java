package 백준3월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 안전영역2468 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5\n" +
            "6 8 2 6 2\n" +
            "3 2 3 4 6\n" +
            "6 7 3 3 2\n" +
            "7 2 5 3 6\n" +
            "8 9 5 2 7";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];

        StringTokenizer str;
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(input.readLine());
            int[] temp = new int[N];
            for(int j = 0; j < N; j++){
                temp[j] = Integer.parseInt(str.nextToken());
            }
            map[i] = temp;
        }
        max_count = 1;
        for(int i = 1; i <= 100; i++)
            flood(i);
        System.out.println(max_count);
    }
    static int N;
    static int[][] map;
    static int max_count;
    static boolean[][] visited;
    static void flood(int height){
        visited = new boolean[N][N];
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] > height){
                    count++;
                    visited[i][j] = true;
                    dfs(i, j, height);
                }
            }
        }
        if(count > max_count)
            max_count = count;
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static void dfs(int row, int col, int height){

        for(int d = 0; d < 4; d++){
            int nr = row + dr[d];
            int nc = col + dc[d];
            if(isIn(nr,nc) && map[nr][nc] > height && !visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr, nc, height);
            }
        }
    }
    static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
