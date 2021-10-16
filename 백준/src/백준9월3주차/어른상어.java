package 백준9월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어른상어 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 위치 + 방향
        sharks = new int[4][];
        map = new int[N][];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp > 0){
                    int[] shark = {i, j, 0};
                    sharks[temp] = shark;
                    break;
                }
            }
        }
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < M; i++){
            int temp = Integer.parseInt(st.nextToken());
            sharks[i][2] = temp;
        }
        priority = new int[M][4][];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < 4; j++){
                st = new StringTokenizer(input.readLine());
                int[] temp = new int[4];
                for(int k = 0; k < 4; k++){
                    temp[k] = Integer.parseInt(st.nextToken());
                }
                priority[i][j] = temp;
            }
        }
        isAvailable = new boolean[M];
        smells = new Smell[N][N];
    }
    static int N, M, K;
    static int[][] map;
    static int[][] sharks;
    static boolean[] isAvailable;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    static int[][][]priority;
    static Smell[][] smells;
    static void simulation(){

    }
    class Smell{
        int time;
        int idx;
        public Smell(int idx, int time){
            this.idx = idx;
            this.time = time;
        }
    }
}
