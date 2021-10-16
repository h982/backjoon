package 백준9월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 원판돌리기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][];
        for (int i = 0; i < N; i++) {
            int[] temp = new int[M];
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            board[i] = temp;
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(d == 1){
                k = M - k;
            }
            for (int j = 0; j < N; j++) {
                if ((j + 1) % x != 0)
                    continue;
                rotate(j, k);
            }
//            System.out.println("rotate");
//            print();
//            System.out.println();
            remove();
//            System.out.println("remove");
//            print();
//            System.out.println();
        }
        int sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++)
                sum += board[i][j];
        }
        System.out.println(sum);
    }
    static void print(){
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(board[i]));
    }
    static int N, M, T;
    static int[][] board;

    static void rotate(int idx, int val) {
        int[] temp = new int[M];
        for (int i = 0; i < M; i++) {
            int next = (i + val) % M;
            temp[next] = board[idx][i];
        }
        board[idx] = temp;
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static boolean bfs(int r, int c, int val) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        isVisited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = (c + dc[d] + M)%M;

            if (isIn(nr, nc) && board[nr][nc] == val) {
                isVisited[nr][nc] = true;
                board[nr][nc] = 0;
                queue.add(new int[]{nr, nc});
            }
        }
        if (queue.isEmpty())
            return false;

        board[r][c] = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = temp[0] + dr[d];
                int nc = (temp[1] + dc[d] + M)%M;
                if (isIn(nr, nc) && board[nr][nc] == val) {
                    isVisited[nr][nc] = true;
                    board[nr][nc] = 0;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return true;
    }

    static void remove() {
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0)
                    continue;
                if (bfs(i, j, board[i][j]))
                    flag = false;
            }
        }

        if (flag) {
            float sum = 0, cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(board[i][j] == 0)
                        continue;
                    sum += board[i][j];
                    cnt++;
                }
            }
            sum /= cnt;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == sum || board[i][j] == 0)
                        continue;

                    if (board[i][j] > sum)
                        board[i][j]--;
                    else
                        board[i][j]++;
                }
            }
        }
    }
}
