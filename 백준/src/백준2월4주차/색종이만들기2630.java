package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 색종이만들기2630 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "8\n" +
            "1 1 0 0 0 0 1 1\n" +
            "1 1 0 0 0 0 1 1\n" +
            "0 0 0 0 1 1 0 0\n" +
            "0 0 0 0 1 1 0 0\n" +
            "1 0 0 0 1 1 1 1\n" +
            "0 1 0 0 1 1 1 1\n" +
            "0 0 1 1 1 1 1 1\n" +
            "0 0 1 1 1 1 1 1";
    static StringTokenizer str;
    public static void main(String[] args)throws IOException {
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());
        map = new int[N][];

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(input.readLine());
            int[] temp = new int[N];
            for(int j = 0; j < N; j++){
                temp[j] = Integer.parseInt(str.nextToken());
            }
            map[i] = temp;
        }
        count_w = 0;
        count_b = 0;

        cutPaper(0, 0, N);
        System.out.println(count_w);
        System.out.println(count_b);

    }
    static int N, count_w, count_b;
    static int[][] map;
    static void cutPaper(int row, int col, int size){
        if(size == 1){
            if(map[row][col] == 1)
                count_b++;
            else
                count_w++;

            return;
        }
        int state = map[row][col];
        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(map[i][j] != state){
                    cutPaper(row, col, size/2);
                    cutPaper(row+size/2 , col , size/2);
                    cutPaper(row , col+size/2 , size/2);
                    cutPaper(row+size/2 , col+size/2 , size/2);
                    return;
                }
            }
        }
        if(state == 1)
            count_b++;
        else
            count_w++;
    }
}
