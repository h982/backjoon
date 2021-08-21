import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빙산 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][];
        ices = new LinkedList<>();
        for(int i = 0; i < N; i++){
            int[] temp = new int[M];
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < M; j++){
                temp[j] = Integer.parseInt(st.nextToken());
                if(temp[j] != 0){
                    ices.add(new int[]{i, j});
                }
            }
            map[i] = temp;
        }
        int ans = Integer.MAX_VALUE;
        int year = 1;
        while (!ices.isEmpty()){
            int size = ices.size();
            newMap = new int[N][M];
            for(int i = 0; i < size; i++){
                melt(ices.poll());
            }
            map = newMap;
            if(ices.isEmpty())
                break;
            if(!count()){
                ans = year;
                break;
            }
            year++;
        }
        System.out.println(ans==Integer.MAX_VALUE?0:ans);
    }
    static int N, M;
    static int[][] map;
    static int[][] newMap;
    static Queue<int[]> ices;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static void melt(int[] ice){
        int count = 0;
        for(int d = 0; d < 4; d++){
            int nr = ice[0] + dr[d];
            int nc = ice[1] + dc[d];
            if(isIn(nr, nc) && map[nr][nc] == 0){
                count++;
            }
        }
        if(map[ice[0]][ice[1]] - count > 0){
            newMap[ice[0]][ice[1]] = map[ice[0]][ice[1]] - count;
            ices.add(ice);
            return;
        }
        newMap[ice[0]][ice[1]] = 0;
    }
    static boolean count(){
        int size = ices.size();
        boolean[][] visited = new boolean[N][M];
        int[] first = ices.peek();
        bfs(first[0], first[1], visited);
        for(int i = 0; i < size; i++){
            int[] temp = ices.poll();
            if(!visited[temp[0]][temp[1]])
                return false;
            ices.add(temp);
        }
        return true;
    }
    static void bfs(int r, int c, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        visited[r][c] = true;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int d = 0; d < 4; d++){
                int nr = temp[0] + dr[d];
                int nc = temp[1] + dc[d];
                if(isIn(nr, nc) && map[nr][nc] > 0 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
