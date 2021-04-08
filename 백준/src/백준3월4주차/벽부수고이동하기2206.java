package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2206 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6 4\n" +
            "0100\n" +
            "1110\n" +
            "1000\n" +
            "0000\n" +
            "0111\n" +
            "0000";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][];
        for(int i = 0; i < N; i++){
           map[i] = input.readLine().toCharArray();
        }
        min_dist = 0;
        visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        bfs();
        System.out.println(min_dist==0?-1:min_dist);
//        dfs(0, 0, 1,true);
//        System.out.println(min_dist==Integer.MAX_VALUE?-1:min_dist);
    }
    static int N, M, min_dist;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        // 거리, Row, Col, block
        queue.add(new int[]{0, 0, 0});
        int dist = 0;
        while (!queue.isEmpty()){
            dist++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] state = queue.poll();
                if(state[0] == N-1 && state[1] == M-1){
                    min_dist = dist;
                    return;
                }
                for(int d = 0; d < 4; d++){
                    int nr = state[0] + dr[d];
                    int nc = state[1] + dc[d];

                    if(isIn(nr,nc)){
                        if(state[2] == 0 && !visited[nr][nc][0]){
                            if(map[nr][nc] == '0') {
                                queue.add(new int[]{nr, nc, 0});
                                visited[nr][nc][0] = true;
                            }
                            else {
                                queue.add(new int[]{nr, nc, 1});
                                visited[nr][nc][1] = true;
                            }
                        }else if(state[2] == 1 && !visited[nr][nc][1]){
                            if(map[nr][nc] == '0') {
                                queue.add(new int[]{nr, nc, 1});
                                visited[nr][nc][1] = true;
                            }
                        }
                    }
                }
            }
        }
    }
    static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
