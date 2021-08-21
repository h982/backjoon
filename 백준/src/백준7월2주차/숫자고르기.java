import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 숫자고르기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }
        selected = new boolean[N+1];
        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(!selected[i]) {
                visited = new boolean[N + 1];
                ans += dfs(i, i, 1);
            }
        }
        System.out.println(ans);
        for(int i = 1; i <= N; i++){
            if(selected[i])
                System.out.println(i);
        }
    }
    static int N;
    static int[] arr;
    static boolean[] selected;
    static boolean[] visited;
    static int dfs(int start, int next, int num){
        if(arr[next] == start){
            selected[next] = true;
            return num;
        }else if(arr[next] == next){
            return 0;
        }
        if(!visited[arr[next]]) {
            visited[arr[next]] = true;
            int ret = dfs(start, arr[next], num + 1);
            if (ret > 0) {
                selected[next] = true;
                return ret;
            }
            ;
        }
        return 0;
    }
}
