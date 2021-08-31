package 백준8월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소3 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[N];
            for (int j = 0; j < N; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
                if (temp[j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
            map[i] = temp;
        }
        selected = new int[M];
        min = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }

    static int N, M;
    static int[][] map;
    static List<int[]> virus;
    static int[] selected;

    static void dfs(int cnt, int idx) {
        if (cnt == M) {
            bfs();
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            selected[cnt] = i;
            dfs(cnt + 1, i + 1);
        }
    }

    static int min;
    static int[][] duplMap;

    static void bfs() {
        boolean[][] isVisited = new boolean[N][N];
        duplMap = new int[N][N];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        for (int i = 0; i < M; i++) {
            int[] select = virus.get(selected[i]);
            isVisited[select[0]][select[1]] = true;
            duplMap[select[0]][select[1]] = 0;
            queue.add(new int[]{select[0], select[1], 0});
        }
        int ans = 0;
        while (!queue.isEmpty() && !isClear(isVisited)) {
            int[] loc = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = loc[0] + dr[d];
                int nc = loc[1] + dc[d];
                if (isIn(nr, nc) && map[nr][nc] != 1 && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, loc[2]+1});
                    duplMap[nr][nc] = loc[2] + 1;
                    ans = loc[2] + 1;
                }
            }
        }


        if (!isClear(isVisited))
            return;
        if (ans < min) {
            min = ans;
//            System.out.println(Arrays.toString(selected));
//            for (int i = 0; i < N; i++)
//                System.out.println(Arrays.toString(duplMap[i]));
//            System.out.println(ans);
//            System.out.println();
        }

    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    static boolean isClear(boolean[][] isVisited){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j] || map[i][j] >= 1) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
