import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알파벳 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        for(int i = 0; i < R; i++){
            char[] temp = input.readLine().toCharArray();
            map[i] = temp;
        }
        alphabet = new boolean['Z' - 'A' + 1];
        isVisited = new boolean[R][C];
        max_value = 1;
        isVisited[0][0] = true;
        dfs(0, 0, 0);
        System.out.println(max_value);
    }
    static char[][] map;
    static int R, C;
    static int max_value;
    static boolean[] alphabet;
    static boolean[][] isVisited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static void dfs(int r, int c, int count){
        if(alphabet[map[r][c] - 'A']){
           if(max_value < count)
               max_value = count;
           return;
        }

        alphabet[map[r][c] - 'A'] = true;
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isIn(nr, nc) && !isVisited[nr][nc]){
                isVisited[nr][nc] = true;
                dfs(nr, nc, count+1);
                isVisited[nr][nc] = false;
            }
        }
        alphabet[map[r][c] - 'A'] = false;
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }

//    static int bfs(){
//        Queue<Point> queue = new LinkedList<>();
//        boolean[][] isVisited = new boolean[R][C];
//        boolean[] alpha = new boolean['Z'-'A' + 1];
//        alpha[map[0][0] - 'A'] = true;
//        queue.add(new Point(0, 0, 1, alpha));
//
//        int ans = 0;
//        while(!queue.isEmpty()){
//            Point point = queue.poll();
//            for(int d = 0; d < 4; d++){
//                int nr = point.row + dr[d];
//                int nc = point.col + dc[d];
//                if(isIn(nr, nc)){
//                    if(!point.alphabet[map[nr][nc] - 'A']){
//                        boolean[] temp = new boolean['Z' - 'A' + 1];
//                        System.arraycopy(point.alphabet, 0, temp, 0, 'Z'-'A'+1);
//                        temp[map[nr][nc] - 'A'] = true;
//                        queue.add(new Point(nr, nc, point.count+1, temp));
//                    }
//                }
//            }
//            if(queue.isEmpty()){
//                ans = point.count;
//            }
//        }
//        return ans;
//    }
//    static class Point {
//        int row, col;
//        int count;
//        boolean[] alphabet;
//
//        public Point(int row, int col, int count, boolean[] alphabet){
//            this.row = row;
//            this.col = col;
//            this.count = count;
//            this.alphabet = alphabet;
//        }
//    }
}
