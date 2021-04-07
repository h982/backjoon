package 백준3월3주차;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파이프옮기기17070 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "0 0 0 0 0 0\n" +
            "0 1 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());

        map = new int[N][];
        StringTokenizer str;
        for(int i = 0; i < N; i++){
            int[] temp = new int[N];
            str = new StringTokenizer(input.readLine());
            for(int j = 0; j < N; j++){
                temp[j] = Integer.parseInt(str.nextToken());
            }
            map[i] = temp;
        }
        count = 0;
        bfs();
        System.out.println(count);
    }
    static int N;
    // 가로 세로 대각선
    static int[][] map;
    static int count;
    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,1,0});
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int row2 = temp[0];
            int col2 = temp[1];
            int now_state = temp[2];
            if(row2 == N-1 && col2 == N-1){
                count++;
                continue;
            }
            if(now_state != 1 && col2 + 1 < N && map[row2][col2+1] != 1){
                queue.add(new int[]{row2, col2+1, 0});
            }
            if(now_state != 0 && row2 + 1 < N && map[row2+1][col2] != 1){
                queue.add(new int[]{row2+1, col2, 1});
            }
            if(row2 + 1 < N && col2 + 1 < N && map[row2][col2+1] != 1&& map[row2+1][col2] != 1&& map[row2+1][col2+1] != 1){
                queue.add(new int[]{row2+1, col2+1, 2});
            }
        }
    }


    static int ans;
    static void dfs(int r, int c, int dir) {
        if(r == N-1 && c == N-1	) {
            ans++;
            return;
        }

        //오른쪽으로 갈 수 있으면 오른쪽으로 간다.
        if( dir != 1 && c + 1 < N && map[r][c+1] == 0 )
            dfs(r, c+1, 0);
        //아래로 갈 수 있으면 아래로 간다.
        if( dir != 0 && r + 1 < N && map[r+1][c] == 0 )
            dfs(r+1, c, 1);
        //대각으로 갈 수 있으면 대각으로 간다.
        if( r + 1 < N && c + 1 < N && map[r+1][c] + map[r][c+1] + map[r+1][c+1] == 0)
            dfs(r+1, c+1, 2);
    }
}
