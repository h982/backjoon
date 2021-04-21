package 백준4월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Maaaaaaaaaze16985 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "1 1 1 1 1\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "1 1 1 1 1\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "1 1 1 1 1\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "1 1 1 1 1\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "1 1 1 1 1\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        layer = new int[5][][];
        StringTokenizer st;
        for(int i = 0; i < 5; i++){
            int[][] temp = new int[5][];
            for(int j = 0; j < 5; j++){
                int[] lay = new int[5];
                st = new StringTokenizer(input.readLine());
                for(int k = 0; k < 5; k++){
                    lay[k] = Integer.parseInt(st.nextToken());
                }
                temp[j] = lay;
            }
            layer[i] = temp;
        }
        isUsed = new boolean[5];
        min_dist = Integer.MAX_VALUE;
        map = new ArrayList<>();
        permu(0);

        System.out.println((min_dist == Integer.MAX_VALUE? -1:min_dist));
    }
    static int[][][] layer;
    static List<int[][]> map;
    static boolean[] isUsed;
    static int min_dist;
    static boolean permu(int cnt){     // 쌓는 순서
        if(cnt == 5){
            if(dfs(0))
                return true;
        }
        for(int i = 0; i < 5; i++){
            if(!isUsed[i]){
                if(map.size() != 0 && map.size() > cnt)
                    map.remove(cnt);
                map.add(cnt, layer[i]);
                isUsed[i] = true;
                if(permu(cnt+1))
                    return true;
                isUsed[i] = false;
            }
        }
        return false;
    }
    static boolean dfs(int idx){
        if(idx == 5) {
            if(map.get(0)[0][0] == 1)
                bfs();
            if(min_dist == 12)
                return true;
            return false;
        }
        if(dfs(idx+1))
            return true;
        for(int i = 0; i < 4; i++){
            rotate(idx);
            if(dfs(idx+1))
                return true;
        }
        return false;
    }

    static void rotate(int idx){
        int[][] lay = map.get(idx);
        int[][] newLay = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                newLay[i][j] = lay[4-j][i];
            }
        }
        map.remove(idx);
        map.add(idx, newLay);
    }
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static void bfs(){      // 미로 찾기
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[5][5][5];
        queue.add(new int[]{0,0,0});
        visited[0][0][0] = true;
        boolean isOk = false;
        int dist = 1;
        out:while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] loc = queue.poll();
                for(int d = 0; d < 6; d++){
                    int nr = loc[0] + dr[d];
                    int nc = loc[1] + dc[d];
                    int nh = loc[2] + dh[d];
                    if (isIn(nr, nc, nh) && !visited[nr][nc][nh] && map.get(nr)[nc][nh] == 1){
                        if(nr == 4 && nc == 4 && nh == 4){
                            isOk = true;
                            break out;
                        }
                        visited[nr][nc][nh] = true;
                        queue.add(new int[]{nr, nc, nh});
                    }
                }
            }
            dist++;
        }
        if(isOk){
            min_dist = Math.min(min_dist, dist);
        }
    }
    static boolean isIn(int r, int c, int h){
        return r >= 0 && r < 5 && c >= 0 && c < 5 && h >= 0 && h < 5;
    }
}
