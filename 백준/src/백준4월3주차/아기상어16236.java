package 백준4월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아기상어16236 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        map = new int[N][];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[N];
            for(int j = 0; j < N; j++)
                temp[j] = Integer.parseInt(st.nextToken());
            map[i] = temp;
        }
        System.out.println(bfs());
    }
    static int N;
    static int[][] map;
    static int[] dr = {-1, 0, 0, 1}; // 상 좌 하 우
    static int[] dc = {0, -1, 1, 0};

    static int bfs(){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        out:for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 9){
                    queue.add(new int[]{i, j});
                    map[i][j] = 0;
                    visited[i][j] = true;
                    break out;
                }
            }
        }
        int size = 2;
        int eat = 0;
        int movemet = 0;
        boolean found = false;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return  o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        while(!queue.isEmpty()){
            int q_size = queue.size();
            movemet++;
            out:for(int i = 0; i < q_size; i++){
                int[] loc = queue.poll();
                for(int d = 0; d < 4; d++){
                    int nr = loc[0] + dr[d];
                    int nc = loc[1] + dc[d];
                    if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] <= size){
                        if(map[nr][nc] >= 1 && map[nr][nc] < size){
                            pq.add(new int[]{nr,nc});
                            found = true;

                        }else{
                            queue.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            if(found){
                if(size == ++eat){
                    size++;
                    eat = 0;
                }
                int[] select = pq.poll();
                int nr = select[0];
                int nc = select[1];
                queue.clear();
                pq.clear();
                visited = new boolean[N][N];
                map[nr][nc] = 0;
                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;
                result += movemet;
                movemet = 0;
                found = false;
            }
        }

        return result;
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
