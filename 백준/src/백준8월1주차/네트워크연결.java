import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 네트워크연결 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        edges = new List[N+1];
        for(int i = 1; i <= N; i++){
            edges[i] = new ArrayList<int[]>();
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == b)
                continue;
            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        boolean[] computers = new boolean[N+1];
        int[] dist = new int[N+1];
        int min_dist = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[]{1, 0});
        for(int i = 0; i < N; i++){
            int[] temp;
            while(true){
                temp = pq.poll();
                if(computers[temp[0]]){
                    continue;
                }
                break;
            }
//            System.out.println("점: " + temp[0] + " " + temp[1]);
            min_dist += temp[1];
            computers[temp[0]] = true;
            for(int[] next : edges[temp[0]]){
                if(computers[next[0]])
                    continue;
                int newDist = next[1];
                if(newDist < dist[next[0]]){
                    pq.add(new int[]{next[0], newDist});
                }
            }
        }
        System.out.println(min_dist);
    }
    static int N, M;
    static List<int[]>[] edges;
}
