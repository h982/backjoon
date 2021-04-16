package 백준4월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나무재테크16235 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[N];
            for(int j = 0; j < N; j++)
                temp[j] = Integer.parseInt(st.nextToken());
            A[i] = temp;
        }
        B = new int[N][N];
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                B[i][j] = 5;
        }

        pq = new PriorityQueue<>(new QComparator());
        dead = new LinkedList<>();
        alive = new LinkedList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            pq.add(new int[]{x,y,age, 0});
        }
        for(int i = 0; i < K; i++){
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(pq.size());
    }

    static class QComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];
        }
    }
    static int N, M, K;
    static int[][] A;
    static int[][] B;
    static PriorityQueue<int[]> pq;
    static Queue<int[]>dead;
    static Queue<int[]>alive;
    static void spring(){
        int size = pq.size();
        for(int i = 0; i < size; i++){
            int[] loc = pq.poll();
            if(B[loc[0]][loc[1]] >= loc[2]){
                B[loc[0]][loc[1]] -= loc[2];
                alive.add(new int[]{loc[0],loc[1],loc[2]+1});
            }else{
                dead.add(loc);
            }
        }
    }
    static void summer(){
        while(!dead.isEmpty()){
            int[] loc = dead.poll();
            B[loc[0]][loc[1]] += loc[2]/2;
        }
    }
    static int[] dr = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dc = {-1, 1, -1, 0, 1, -1, 0, 1};
    static void autumn(){
        while(!alive.isEmpty()){
            int[] loc = alive.poll();
            if(loc[2] % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nr = loc[0] + dr[d];
                    int nc = loc[1] + dc[d];
                    if (isIn(nr, nc)) {
                        pq.add(new int[]{nr, nc, 1});
                    }
                }
            }
            pq.add(loc);
        }
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    static void winter(){
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                B[i][j] += A[i][j];
        }
    }
}
