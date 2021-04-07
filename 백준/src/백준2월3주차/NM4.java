package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM4 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        visited = new boolean[N+1];
        selected = new int[M];
        comb(0, 1);
        System.out.println(output);
    }
    static int N, M;
    static boolean[] visited;
    static int[] selected;
    static void comb(int cnt, int idx){
        if(cnt == M){
            for(int sel : selected)
                output.append(sel + " ");
            output.append("\n");
            return;
        }

        for(int i = idx; i <= N; i++){
            selected[cnt] = i;
            comb(cnt+1, i);
        }
    }
}
