package 백준9월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[M][];
            fires = new LinkedList<>();
            boolean flag = false;
            int r=0, c=0;
            for(int i = 0; i < M; i++){
                map[i] = input.readLine().toCharArray();
                for(int j = 0; j < N; j++){
                    if(map[i][j] == '*'){
                        fires.add(new int[]{i, j});
                        continue;
                    }
                    if(flag)
                        continue;
                    if(map[i][j] == '@'){
                        flag = true;
                        r = i;
                        c = j;
                        map[i][j] = '.';
                    }
                }
            }
            int ans = bfs(r, c);
            output.append(ans==-1?"IMPOSSIBLE":ans).append("\n");
        }
        System.out.println(output);
    }
    static int N, M;
    static char[][] map;
    static Queue<int[]>fires;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[M][N];
        queue.add(new int[]{r,c});
        isVisited[r][c] = true;
        int count = 0;
        while(!queue.isEmpty()){
            fire();
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] loc = queue.poll();
                for(int d = 0; d < 4; d++){
                    int nr = loc[0] + dr[d];
                    int nc = loc[1] + dc[d];
                    if(!isIn(nr, nc))
                        return count;
                    if(!isVisited[nr][nc] && map[nr][nc] == '.'){
                        isVisited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return -1;
    }
    static void fire(){
        int size = fires.size();
        for(int i = 0; i < size; i++){
            int[] loc = fires.poll();
            for(int d = 0; d < 4; d++){
                int nr = loc[0] + dr[d];
                int nc = loc[1] + dc[d];
                if(isIn(nr, nc) && map[nr][nc] == '.'){
                    map[nr][nc] = '*';
                    fires.add(new int[]{nr, nc});
                }
            }
        }
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}
