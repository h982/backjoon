package 백준9월1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 젤다 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int count = 1;
        while(true) {
            N = Integer.parseInt(input.readLine());
            if(N == 0)
                break;

            map = new int[N][];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(input.readLine());
                int[] temp = new int[N];
                for (int j = 0; j < N; j++) {
                    temp[j] = Integer.parseInt(st.nextToken());
                }
                map[i] = temp;
            }
            output.append("Problem " + count++ + ": " + bfs() + "\n");
        }
        System.out.println(output);
    }
    static int N;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int bfs(){
        boolean[][] isVisited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        pq.add(new int[]{0,0,map[0][0]});
        isVisited[0][0] = true;

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
                    pq.add(new int[]{nr, nc, loc[2] + map[nr][nc]});
                }
            }
        }

        return -1;
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
