import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 집합의표현 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(input.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(op == 0){
                union(a, b);
                continue;
            }
            if(op == 1){
                if(find(a) == find(b)){
                    output.append("YES\n");
                }else{
                    output.append("NO\n");
                }
            }
        }
        System.out.println(output);
    }
    static int N, M;
    static int[] parent;
    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA != parentB){
            parent[parentB] = parentA;
        }
    }
}
