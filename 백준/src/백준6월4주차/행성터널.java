import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 행성터널 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        int[][] stars = new int[N][];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[3];
            for(int j = 0; j < 3; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            stars[i] = temp;
        }

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = Math.min(Math.min(Math.abs(stars[i][0] - stars[j][0]),Math.abs(stars[i][1] - stars[j][1])), Math.abs(stars[i][2] - stars[j][2]));
            }
        }
        boolean[] visited = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{0, 0});
        long sum = 0;
        for(int i = 0; i < N; i++){
            int[] temp = new int[2];
            while(!pq.isEmpty()){
                temp = pq.poll();
                if(!visited[temp[0]]){
                    break;
                }
            }
            visited[temp[0]] = true;
            sum += temp[1];
            for(int j = 0; j < N; j++){
                if(!visited[j])
                    pq.add(new int[]{j, map[temp[0]][j]});
            }
        }
        System.out.println(sum);
    }
    static int N;
    static int[][] map;
}
