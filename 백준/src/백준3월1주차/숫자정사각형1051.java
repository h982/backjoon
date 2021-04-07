package 백준3월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 숫자정사각형1051 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3 5\n" +
            "44444\n" +
            "44100\n" +
            "42444";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][];
        for(int i = 0; i < N; i++){
            String temp = input.readLine();
            int[] line = new int[M];
            for(int j = 0; j < M; j++){
                line[j] = temp.charAt(j) -'0';
            }
            map[i] = line;
        }
        max_size = 0;
        calSquare();
        System.out.println(max_size*max_size);
    }

    static int N, M;
    static int[][] map;
    static int max_size;
    static void calSquare(){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                makeSqure(i, j);
            }
        }
    }
    static void makeSqure(int row, int col){
        int num = map[row][col];
        int dist = findSameRow(row, col, num);
        int nr = row;
        int nc = col;
        int total_dist = dist;
        while(dist != -1){
            nr += dist;
            if(isIn(nr,nc)){
                if(map[nr][nc] != num){
                    return;
                }
                nc = nc + dist;
                if(map[nr][nc] != num){
                    return;
                }
                total_dist += dist;
                if(++total_dist > max_size)
                    max_size = total_dist;
                dist = findSameRow(row, col+total_dist, num);
            }
        }
    }
    static int findSameRow(int row, int col, int state){
        int nr = row;
        int nc = col + 1;
        int idx = 1;
        while(isIn(nr, nc)){
            if(map[nr][nc] == state){
                return idx;
            }
            nc++;
            idx++;
        }
        return -1;
    }
    static boolean isIn(int row, int col){
        return row >= 0 &&row < N && col < M && col >=0;
    }
}
