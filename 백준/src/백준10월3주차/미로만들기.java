package 백준10월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 미로만들기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        map = new char[N][];
        for(int i = 0; i < N; i++){
            map[i] = input.readLine().toCharArray();
        }
        System.out.println(bfs());
    }
    static int N;
    static char[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int bfs(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        boolean[][] isVisited = new boolean[N][N];
        isVisited[0][0] = true;
        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] loc = pq.poll();
            if(loc[0] == N-1 && loc[1] == N-1){
                return loc[2];
            }
            for(int d = 0; d < 4; d++){
                int nr = loc[0] + dr[d];
                int nc = loc[1] + dc[d];
                if(isIn(nr, nc) && !isVisited[nr][nc]){
                    isVisited[nr][nc] = true;
                    if(map[nr][nc] == '0') {
                        pq.add(new int[]{nr, nc, loc[2]+1});
                        continue;
                    }
                    pq.add(new int[]{nr, nc, loc[2]});
                }
            }
        }
        return -1;
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
