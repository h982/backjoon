import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][];
        for(int i = 0; i < M; i++){
            int[] temp = new int[N];
            String str = input.readLine();
            for(int j = 0; j < N; j++){
                temp[j] = str.charAt(j) - '0';
            }
            map[i] = temp;
        }
        min_break = 0;
        bfs();
        System.out.println(min_break);
    }
    static int N, M;
    static int[][] map;
    static int min_break;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static void bfs(){
        PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.blocks - o2.blocks;
            }
        });
        pq.add(new Data(0, 0, 0));
        boolean[][] isVisited = new boolean[M][N];
        isVisited[0][0] = true;
        while(!pq.isEmpty()){
            Data temp = pq.poll();
            if(temp.r == M-1 && temp.c == N-1){
                min_break = temp.blocks;
                return;
            }
            for(int d = 0; d < 4; d++){
                int nr = temp.r + dr[d];
                int nc = temp.c + dc[d];
                if(isIn(nr, nc) && !isVisited[nr][nc]){
                    if(map[nr][nc] == 1){
                        pq.add(new Data(nr, nc, temp.blocks + 1));
                        isVisited[nr][nc] = true;
                        continue;
                    }
                    pq.add(new Data(nr, nc, temp.blocks));
                    isVisited[nr][nc] = true;
                }
            }
        }
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < M && c >= 0 && c < N;
    }
    static class Data{
        int r;
        int c;
        int blocks;

        public Data(int r, int c, int blocks){
            this.r = r;
            this.c = c;
            this.blocks = blocks;
        }
    }
}
