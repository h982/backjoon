package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class DFS와BFS1260 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output= new StringBuilder();
    static String src = "5 5 3\n" +
            "5 4\n" +
            "5 2\n" +
            "1 2\n" +
            "3 4\n" +
            "3 1";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int V = Integer.parseInt(str.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 0; i<=N; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i <= N; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        visited[V] = true;
        output.append(V + " ");
        dfs(V);
        output.append("\n");

        visited = new boolean[N+1];
        visited[V] = true;
        output.append(V + " ");
        bfs(V);

        System.out.println(output);
    }
    static int N, M, V;
    static boolean[] visited;
    static List<Integer>[] graph;

    static void dfs(int idx){
        for(int i = 0; i < graph[idx].size(); i++){
            int temp = graph[idx].get(i);
            if(visited[temp])
                continue;

            visited[temp] = true;
            output.append(temp + " ");
            dfs(temp);
        }
    }
    static void bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int temp = graph[now].get(i);
                if (visited[temp])
                    continue;

                visited[temp] = true;
                output.append(temp + " ");
                queue.add(temp);
            }
        }
    }
}
