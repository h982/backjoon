package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM3 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        selected = new int[M];
        permu(0);
        System.out.println(output);
    }
    static int N, M;
    static int[] selected;
    static void permu(int cnt){
        if(cnt == M){
            for(int sel : selected)
                output.append(sel + " ");
            output.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            selected[cnt] = i;
            permu(cnt+1);
        }
    }
}
