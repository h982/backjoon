package 백준4월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자1194 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][];
        for(int i = 0; i < N; i++){
            map[i] = input.readLine().toCharArray();
        }
        int r = 0;
        int c = 0;
        out:for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == '0'){
                    r = i;
                    c = j;
                    break out;
                }
            }
        }
        visited = new boolean[N][M][(1<<6)];
        min_dist = Integer.MAX_VALUE;
        bfs(r, c);

        System.out.println(min_dist==Integer.MAX_VALUE? -1: min_dist);
    }
    static int N, M;
    static int min_dist;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c,0});
        int dist = 0;
        while (!queue.isEmpty()){
            dist++;
            int q_size = queue.size();
            for(int i = 0; i < q_size; i++){
                int[] now = queue.poll();
                for(int d = 0; d < 4; d++){
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];
                    if(isIn(nr, nc) && !visited[nr][nc][now[2]]){
                        char next = map[nr][nc];
                        if(next == '.'){
                            visited[nr][nc][now[2]] = true;
                            queue.add(new int[]{nr, nc, now[2]});
                            continue;
                        }else if(next == '#'){
                            continue;
                        }else if(next=='0'){
                            visited[nr][nc][now[2]] = true;
                            queue.add(new int[]{nr, nc, now[2]});
                            continue;
                        }else if(next == '1'){
                            min_dist = dist;
                            return;
                        }else if(next >= 'a' && next <='f'){
                            visited[nr][nc][now[2]] = true;
                            queue.add(new int[]{nr, nc, now[2]|(1<<(next-'a'))});
                            continue;
                        }else if(next >= 'A' && next <= 'F'){
                            if((now[2]>>(next-'A')&1) == 1){
                                visited[nr][nc][now[2]] = true;
                                queue.add(new int[]{nr, nc, now[2]});
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
