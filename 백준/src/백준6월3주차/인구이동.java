import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for(int i = 0; i < N; i++){
            int[] temp = new int[N];
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < N; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            A[i] = temp;
        }
        System.out.println(move());
    }
    static int N, L, R;
    static int[][] A;
    static boolean[][] isVisited;
    static int move(){
        int ans = -1;
        boolean flag = true;
        while(flag){
            flag = false;
            isVisited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!isVisited[i][j]){
                        isVisited[i][j] = true;
                        if(bfs(i, j)){
                            flag = true;
                        }
                    }
                }
            }
            ans++;
        }
        return ans;
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        queue.add(new int[]{r,c});
        list.add(new int[]{r,c});
        int sum = A[r][c];
        int count = 1;
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            for(int d = 0; d < 4; d++){
                int nr = loc[0] + dr[d];
                int nc = loc[1] + dc[d];
                if(isIn(nr, nc) && !isVisited[nr][nc]){
                    int diff = Math.abs(A[nr][nc] - A[loc[0]][loc[1]]);
                    if(diff >= L && diff <= R){
                        isVisited[nr][nc] = true;
                        queue.add(new int[]{nr,nc});
                        list.add(new int[]{nr,nc});
                        sum += A[nr][nc];
                        count++;
                    }
                }
            }
        }
        if(count == 1){
            return false;
        }
        int population = sum / count;
        for(int[] loc : list){
            A[loc[0]][loc[1]] = population;
        }
        return true;
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
