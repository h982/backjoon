package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM5 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(input.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(str.nextToken());
        Arrays.sort(arr);
        visited = new boolean[N];
        selected = new int[M];
        permu(0);
        System.out.println(output);
    }
    static int N, M;
    static int[]arr;
    static boolean[] visited;
    static int[] selected;
    static void permu(int cnt){
        if(cnt == M){
            for(int sel : selected)
                output.append(sel + " ");
            output.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = arr[i];
                permu(cnt+1);
                visited[i] = false;
            }
        }
    }
}