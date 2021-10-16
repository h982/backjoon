package 백준10월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][];
        for(int i = 1; i <= N; i++){
            int[] temp = new int[M+1];
            st = new StringTokenizer(input.readLine());
            for(int j = 1; j <= M; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            matrix[i] = temp;
        }

        rotInfo = new int[K][];
        for(int i = 0; i < K; i++){
            int[] temp = new int[3];
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < 3; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            rotInfo[i] = temp;
        }

        selected = new boolean[K];
        ans = Integer.MAX_VALUE;
        dfs(0);

        System.out.println(ans);
    }
    static int N, M, K;
    static int[][] matrix;
    static int[][] rotInfo;
    static int ans;
    static boolean[] selected;
    static void dfs(int idx){
        if(idx == K){
            int cal = calc();
            System.out.println(cal);
            if(cal < ans)
                ans = cal;
            return;
        }

        for(int i = 0; i < K; i++){
            if(selected[i])
                continue;
            selected[i] = true;
            rotate(rotInfo[i]);
            print();
            System.out.println();
            dfs(idx+1);
            derotate(rotInfo[i]);
            print();
            System.out.println();
            selected[i] = false;
        }
    }

    static void rotate(int[] rot){
        int r1 = rot[0] - rot[2];
        int r2 = rot[0] + rot[2];
        int c1 = rot[1] - rot[2];
        int c2 = rot[1] + rot[2];

        int last = matrix[r1][c1];
        for(int i = r1; i < r2; i++){
            matrix[i][c1] = matrix[i+1][c1];
        }
        for(int i = c1; i < c2; i++){
            matrix[r2][i] = matrix[r2][i+1];
        }
        for(int i = r2; i > r1; i--){
            matrix[i][c2] = matrix[i-1][c2];
        }
        for(int i = c2; i > c1; i--){
            matrix[r1][i] = matrix[r1][i-1];
        }
        matrix[r1][c1+1] = last;

        if(r1+1 != r2-1 && c1+1 != c2-1){
            rotate(new int[]{rot[0], rot[1], rot[2]-1});
        }

    }

    static void derotate(int[] rot){
        int r1 = rot[0] - rot[2];
        int r2 = rot[0] + rot[2];
        int c1 = rot[1] - rot[2];
        int c2 = rot[1] + rot[2];

        int last = matrix[r1][c2];
        for(int i = r1; i < r2; i++){
            matrix[i][c2] = matrix[i+1][c2];
        }
        for(int i = c2; i > c1; i--){
            matrix[r2][i] = matrix[r2][i-1];
        }
        for(int i = r2; i > r1; i--){
            matrix[i][c1] = matrix[i-1][c1];
        }
        for(int i = c1; i < c2; i++){
            matrix[r1][i] = matrix[r1][i+1];
        }
        matrix[r1][c2-1] = last;

        if(r1+1 != r2-1 && c1+1 != c2-1){
            derotate(new int[]{rot[0], rot[1], rot[2]-1});
        }
    }
    static int calc(){
        int val = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 1; j <= M; j++){
                sum += matrix[i][j];
            }
            if(sum < val)
                val = sum;
        }
        return val;
    }

    static void print(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
