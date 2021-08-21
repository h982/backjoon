import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(input.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        for(int i = 0; i < R; i++){
            map[i] = input.readLine().toCharArray();
        }

        flood = new LinkedList<>();
        boolean isFound = false;
        int[] start = new int[2];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!isFound && map[i][j] == 'S'){
                    map[i][j] = '.';
                    start[0] = i;
                    start[1] = j;
                }
                if(map[i][j] == '*'){
                    flood.add(new int[]{i, j});
                }
            }
        }
        int ans = bfs(start[0], start[1]);
        System.out.println(ans==-1?"KAKTUS":ans);
    }
    static int R, C;
    static char[][] map;
    static Queue<int[]> flood;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        boolean[][] isVisited = new boolean[R][C];
        isVisited[r][c] = true;
        int count = 1;
        while (!queue.isEmpty()){
            doFlood();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] temp = queue.poll();
                for(int d = 0; d < 4; d++){
                    int nr = temp[0] + dr[d];
                    int nc = temp[1] + dc[d];
                    if(isIn(nr, nc) && !isVisited[nr][nc]){
                        isVisited[nr][nc] = true;
                        if(map[nr][nc] == 'D'){
                            return count;
                        } else if(map[nr][nc] == '.'){
                            queue.add(new int[]{nr,nc});
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }
    static void doFlood(){
        int size = flood.size();
        for(int i = 0; i < size; i++){
            int[] temp = flood.poll();
            fill(temp[0], temp[1]);
        }
    }
    static void fill(int r, int c){
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isIn(nr,nc) && map[nr][nc] == '.'){
                map[nr][nc] = '*';
                flood.add(new int[]{nr, nc});
            }
        }
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
