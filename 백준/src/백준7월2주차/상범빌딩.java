import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L == 0){
                break;
            }

            map = new char[L][R][];
            boolean found_S = false;
            boolean found_E = false;
            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    char[] temp = input.readLine().toCharArray();
                    map[i][j] = temp;
                    if(!found_E || !found_S) {
                        for (int k = 0; k < C; k++) {
                            if (temp[k] == 'S') {
                                start = new int[]{i, j, k};
                                found_S = true;
                            }
                            if (temp[k] == 'E') {
                                end = new int[]{i, j, k};
                                found_E = true;
                            }
                        }
                    }
                }
                input.readLine();
            }
            bfs();
        }
        System.out.println(output);
    }
    static char[][][] map;
    static int L, R, C;
    static int[] start;
    static int[] end;
    static void bfs(){
        int ans = -1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[L][R][C];
        queue.add(start);
        isVisited[start[0]][start[1]][start[2]] = true;
        int time = 0;
        out:while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] now = queue.poll();
                if(map[now[0]][now[1]][now[2]] == 'E'){
                    ans = time;
                    break out;
                }
                for(int d = 0; d < 6; d++){
                    int nl = now[0] + dl[d];
                    int nr = now[1] + dr[d];
                    int nc = now[2] + dc[d];
                    if(isIn(nl, nr, nc) && !isVisited[nl][nr][nc] && map[nl][nr][nc] != '#'){
                        queue.add(new int[]{nl, nr, nc});
                        isVisited[nl][nr][nc] = true;
                    }
                }
            }
            time++;
        }
        output.append(ans==-1?"Trapped!":"Escaped in "  + time + " minute(s).");
        output.append("\n");
    }
    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};
    static boolean isIn(int l, int r, int c){
        return l >= 0 && l < L && r >= 0 && r < R && c >= 0 && c < C;
    }
}
