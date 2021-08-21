import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이분그래프 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(input.readLine());
        StringTokenizer st;
        out:for(int tc = 0; tc < K; tc++){
            st = new StringTokenizer(input.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new List[V+1];
            for(int i = 1; i <= V; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            colors = new int[V+1];
            for(int i = 1; i <= V; i++){
                if(colors[i] == 0){
                    if(dfs(i, 1)){
                        output.append("NO\n");
                        continue out;
                    }
                }
            }
            output.append("YES\n");
        }
        System.out.println(output);
    }
    static int K;
    static int V, E;
    static List<Integer>[] graph;
    static int[] colors;
    static boolean dfs(int now, int color){
        for(int next : graph[now]){
            if(colors[next] == 0){
                colors[next] = color;
                if(dfs(next , (color % 2) + 1))
                    return true;
                continue;
            }
            if(colors[next] != color){
                return true;
            }
        }
        return false;
    }
}
