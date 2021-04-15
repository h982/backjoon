package 백준4월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토7576 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][];
        int r = 0;
        int c = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[M];
            for(int j = 0; j < M; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            map[i] = temp;
        }
        System.out.println(bfs());
    }
    static int N,M;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int bfs(){
        int result = -1;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1)
                    queue.add(new int[]{i,j});
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            result++;
            for(int i = 0; i < size; i++) {
                int[] loc = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = loc[0] + dr[d];
                    int nc = loc[1] + dc[d];
                    if (isIn(nr, nc) && map[nr][nc] == 0) {
                        map[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0)
                    return -1;
            }
        }
        return result;
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
