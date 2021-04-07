package 백준3월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "0 0 0 0 0 0 0 0 0 0\n" +
            "0 1 1 0 0 0 0 0 0 0\n" +
            "0 1 1 1 0 0 0 0 0 0\n" +
            "0 0 1 1 1 1 1 0 0 0\n" +
            "0 0 0 1 1 1 1 0 0 0\n" +
            "0 0 0 0 1 1 1 0 0 0\n" +
            "0 0 1 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str;
        map = new int[SIZE][];
        for(int i = 0; i < SIZE; i++){
            str = new StringTokenizer(input.readLine());
            int[] temp = new int[SIZE];
            for(int j = 0; j < SIZE; j++){
                temp[j] = Integer.parseInt(str.nextToken());
            }
            map[i] = temp;
        }
        paper = new int[6];
        for(int i = 1; i <= 5; i++)
            paper[i] = 5;

        ans = Integer.MAX_VALUE;
        dfs(0);
        ans = ans==Integer.MAX_VALUE? -1 : ans;
        System.out.println(ans);
    }
    static final int SIZE = 10;
    static int ans;
    static int[][] map;
    static int[] paper;
    static void dfs(int cnt){
        int row = -1;
        int col = -1;
        out:for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(map[i][j] == 1){
                    row = i;
                    col = j;
                    break out;
                }
            }
        }
        if(row == -1 && col == -1){
            ans = Math.min(cnt, ans);
            return;
        }
        int max = 5;
        while (max > 0){
            boolean isOk = true;
            out:for(int i = row; i < row+max; i++){
                for(int j = col; j < col+max; j++){
                    if(!isIn(i,j) || map[i][j] == 0){
                        isOk = false;
                        break out;
                    }
                }
            }
            if(isOk){
                break;
            }
            max--;
        }

        while (max > 0){
            if(paper[max] == 0){
                max--;
                continue;
            }

            paper[max]--;
            for(int i = row; i < row + max; i++){
                for(int j = col; j < col + max; j++){
                    map[i][j] = 0;
                }
            }
            dfs(cnt+1);
            for(int i = row; i < row + max; i++){
                for(int j = col; j < col + max; j++){
                    map[i][j] = 1;
                }
            }
            paper[max]++;
            max--;
        }
    }
    static boolean isIn(int row, int col){
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }
}
