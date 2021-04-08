package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 연구소14502 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "8 8\n" +
            "2 0 0 0 0 0 0 2\n" +
            "2 0 0 0 0 0 0 2\n" +
            "2 0 0 0 0 0 0 2\n" +
            "2 0 0 0 0 0 0 2\n" +
            "2 0 0 0 0 0 0 2\n" +
            "0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[M];
            for(int j = 0; j < M; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            map[i] = temp;
        }
        selected = new int[3][2];
        safe = Integer.MIN_VALUE;
        comb(0, -1, 0);
        System.out.println(safe);
    }
    static int N, M;
    static int[][] map;
    static int[][] selected;
    static int safe;
    static void comb(int row, int col, int cnt){
        if(cnt == 3){
            int safeCount = cntVirus();
            if(safe < safeCount)
                safe = safeCount;
            return;
        }
        while (row < N) {
            if (++col == M) {
                row++;
                col = 0;
            }
            if (isIn(row, col) && map[row][col] == 0) {
                selected[cnt] = new int[]{row, col};
                map[row][col] = 1;
                comb(row, col, cnt+1);
                map[row][col] = 0;
            }
        }
    }
    static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
    static int cntVirus(){
        int[][] temp = new int[N][];
        for(int i = 0; i < N; i++)
            temp[i] = Arrays.copyOf(map[i],M);

        List<int[]> virusLoc = new ArrayList<>();
        int row = 0;
        int col = -1;
        while (row < N){
            if(++col >= M){
                row++;
                col = 0;
            }
            if(isIn(row, col) && map[row][col] == 2){
                virusLoc.add(new int[]{row, col});
            }
        }

        for (int i = 0; i < virusLoc.size(); i++){
            int[] v = virusLoc.get(i);
            fillVirus(temp, v[0], v[1]);
        }


        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++)
                if(temp[i][j] == 0)
                    count++;
        }

        return count;
    }
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static void fillVirus(int[][] virus, int row, int col){

        for(int d = 0; d < 4; d++){
            int nr = row + dr[d];
            int nc = col + dc[d];
            if(isIn(nr, nc) && virus[nr][nc] == 0){
                virus[nr][nc] = 2;
                fillVirus(virus, nr, nc);
            }
        }
    }
}
