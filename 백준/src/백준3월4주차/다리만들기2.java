package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class 다리만들기2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "7 8\n" +
            "1 0 0 1 1 1 0 0\n" +
            "0 0 1 0 0 0 1 1\n" +
            "0 0 1 0 0 0 1 1\n" +
            "0 0 1 1 1 0 0 0\n" +
            "0 0 0 0 0 0 0 0\n" +
            "0 1 1 1 0 0 0 0\n" +
            "1 1 1 1 1 1 0 0";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][];
        for(int i = 0; i < N; i++){
            int[] temp = new int[M];
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < M; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            map[i] = temp;
        }
        int ans = findDist();
        System.out.println(ans);
    }
    static int N, M, idx;
    static int[][] map;
    static int[][] edges;
    static List<Edge> islands;
    static int findDist(){
        // idx 2부터
        idx = 2;
        int row = 0;
        int col = -1;
        while (row < N){
            if(++col == M){
                row++;
                col = 0;
            }
            if(isIn(row, col) && map[row][col] == 1){
                changeIdx(row, col, idx++);
            }
        }
        edges = new int[idx][];
        row = 0;
        col = -1;
        while (row < N){
            if(++col == M){
                row++;
                col = 0;
            }
            if(isIn(row, col) && map[row][col] != 0){
                updateEdge(row, col, map[row][col]);
            }
        }

        int[] minDist = new int[idx];
        boolean[] visited = new boolean[idx];
        int sum = 0;
        boolean fail = false;
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[2] = 0;
        for(int i = 2; i < idx; i++){
            int min = Integer.MAX_VALUE;
            int minVertex = 0;
            for(int j = 2; j < idx; j++){
                if(!visited[j] && minDist[j] < min){
                    min = minDist[j];
                    minVertex = j;
                }
            }
            if(min == Integer.MAX_VALUE){
                fail = true;
                break;
            }
            visited[minVertex] = true;
            sum += min;
            for(int j = 2; j < idx; j++){
                if(!visited[j] && edges[minVertex][j] < minDist[j])
                    minDist[j] = edges[minVertex][j];
            }
        }

        return fail?-1:sum;
    }
    static void updateEdge(int row, int col, int i){
        int[] min_dist = new int[idx];
        Arrays.fill(min_dist, Integer.MAX_VALUE);
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            visited[temp[0]][temp[1]] = true;
            for(int d = 0; d < 4; d++){
                int nr = temp[0] + dr[d];
                int nc = temp[1] + dc[d];
                if(isIn(nr,nc) && !visited[nr][nc]){
                    if(map[nr][nc] == i) {
                        queue.add(new int[]{nr, nc});
                        continue;
                    }
                    int[] check = checkEdge(nr, nc, d);
                    if(check[0] <= 1 || check[1] == i)
                        continue;

                    min_dist[check[1]] = Math.min(min_dist[check[1]], check[0]);
                }
            }
        }
        edges[i] = min_dist;
    }
    static int[] checkEdge(int row, int col, int d){
        int nr = row + dr[d];
        int nc = col + dc[d];
        int cnt = 1;
        while(isIn(nr, nc)){
            if(map[nr][nc] != 0){
                return new int[]{cnt, map[nr][nc]};
            }
            nr += dr[d];
            nc += dc[d];
            cnt++;
        }
        return new int[]{-1,-1};
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static void changeIdx(int row, int col, int idx){
        map[row][col] = idx;
        for(int d = 0; d < 4; d++){
            int nr = row + dr[d];
            int nc = col + dc[d];
            if(isIn(nr,nc) && map[nr][nc] == 1)
                changeIdx(nr, nc, idx);
        }
    }

    static boolean isIn(int row, int col){
        return row >= 0 &&  row < N && col >= 0 && col < M;
    }

    static class Edge implements Comparable<Edge>{
        int from, to;
        int edge;

        public Edge(int from, int to, int edge){
            this.from = from;
            this.to = to;
            this.edge = edge;
        }

        @Override
        public int compareTo(Edge o) {
            return this.edge - o.edge;
        }
    }
}
