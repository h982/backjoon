package 백준4월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 감시15683 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][];
        cctv = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[M];
            for(int j = 0; j < M; j++){
                temp[j] = Integer.parseInt(st.nextToken());
                if(temp[j] >= 1 && temp[j] < 6)
                    cctv.add(new int[]{i, j});
            }
            map[i] = temp;
        }
        min_dist = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(min_dist);
    }

    static int N, M, min_dist;
    static int[][] map;
    static List<int[]> cctv;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static void dfs(int cnt){
        if(cnt == cctv.size()){
            int count = countSpace();
            if(count <= min_dist) {
                min_dist = count;
            }
            return;
        }
        int[] loc = cctv.get(cnt);
        switch (map[loc[0]][loc[1]]){
            case 1:
                for(int d = 0; d < 4; d++){
                    addCCTV(loc[0], loc[1], d);
                    dfs(cnt+1);
                    rmCCTV(loc[0], loc[1], d);
                }
                break;
            case 2:
                for(int d = 0; d < 2; d++){
                    addCCTV(loc[0], loc[1], d);
                    addCCTV(loc[0], loc[1], d+2);
                    dfs(cnt+1);
                    rmCCTV(loc[0], loc[1], d);
                    rmCCTV(loc[0], loc[1], d+2);
                }
                break;
            case 3:
                for(int d = 0; d < 4; d++){
                    addCCTV(loc[0], loc[1], d);
                    addCCTV(loc[0], loc[1], (d+1)%4);
                    dfs(cnt+1);
                    rmCCTV(loc[0], loc[1], d);
                    rmCCTV(loc[0], loc[1], (d+1)%4);
                }
                break;
            case 4:
                for(int d = 0; d < 4; d++){
                    addCCTV(loc[0], loc[1], (d+1)%4);
                    addCCTV(loc[0], loc[1], (d+2)%4);
                    addCCTV(loc[0], loc[1], (d+3)%4);
                    dfs(cnt+1);
                    rmCCTV(loc[0], loc[1], (d+1)%4);
                    rmCCTV(loc[0], loc[1], (d+2)%4);
                    rmCCTV(loc[0], loc[1], (d+3)%4);
                }
                break;
            case 5:
                for(int d = 0; d < 4; d++){
                    addCCTV(loc[0], loc[1], d);
                }
                dfs(cnt+1);
                for(int d = 0; d < 4; d++){
                    rmCCTV(loc[0], loc[1], d);
                }
                break;
        }

    }
    static void addCCTV(int r, int c, int d){
        int nr = r + dr[d];
        int nc = c + dc[d];
        int val = map[r][c];
        while(isIn(nr, nc)){
            if(map[nr][nc] == 6)
                break;
            if(map[nr][nc] <= 0)
                map[nr][nc] -= val;

            nr += dr[d];
            nc += dc[d];
        }
    }
    static void rmCCTV(int r, int c, int d){
        int nr = r + dr[d];
        int nc = c + dc[d];
        int val = map[r][c];
        while(isIn(nr, nc)){
            if(map[nr][nc] == 6)
                break;
            if(map[nr][nc] < 0)
                map[nr][nc] += val;

            nr += dr[d];
            nc += dc[d];
        }
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    static int countSpace(){
        int sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(map[i][j] == 0)
                    sum++;
            }
        }
        return sum;
    }
}
