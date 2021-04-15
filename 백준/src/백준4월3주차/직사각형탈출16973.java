package 백준4월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출16973 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[M];
            for(int j = 0; j < M; j++)
                temp[j] = Integer.parseInt(st.nextToken());
            map[i] = temp;
        }
        st = new StringTokenizer(input.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        fr = Integer.parseInt(st.nextToken());
        fc = Integer.parseInt(st.nextToken());

        sr--;
        sc--;
        fr--;
        fc--;
        System.out.println(bfs());

    }
    static int N, M, H, W;
    static int[][] map;
    static int sr, sc, fr, fc;
    static int[] dr = {-1, 1, 0, 0};    // 상하좌우
    static int[] dc = {0, 0, -1, 1};    // 상하좌우
    static int bfs(){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        while (!queue.isEmpty()){
            result++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] loc = queue.poll();
                for(int d = 0; d < 4; d++){
                    int nr = loc[0] + dr[d];
                    int nc = loc[1] + dc[d];
                    if(isIn(nr,nc) && !visited[nr][nc] && isOk(nr, nc, d)){
                        if(nr == fr && nc == fc)
                            return result;
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return -1;
    }
    static boolean isOk(int r, int c, int dir){
        // dir = 0, 1, 2, 3 -> 상하좌우
        int start_row = r;
        int end_row = r + H - 1;
        int start_col = c;
        int end_col = c + W - 1;

        switch (dir){
            case 0:
                end_row = start_row;
                break;
            case 1:
                start_row = end_row;
                break;
            case 2:
                end_col = start_col;
                break;
            case 3:
                start_col = end_col;
                break;
        }
        for(int i = start_row; i <= end_row; i++){
            for(int j = start_col; j <= end_col; j++){
                if(!isIn(i, j)) {
                    return false;
                }
                if(map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}
