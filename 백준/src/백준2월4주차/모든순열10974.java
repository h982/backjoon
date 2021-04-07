package 백준2월4주차;
import java.util.Arrays;
import java.util.Scanner;

public class 모든순열10974 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        N = sc.nextInt();
        visited = new boolean[N+1];
        selected = new int[N];
        permu(0);
        System.out.println(output);
    }
    static int N;
    static boolean[] visited;
    static int[] selected;

    static void permu(int cnt){
        if(cnt == N){
            for(int i : selected)
                output.append(i + " ");
            output.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = i;
                permu(cnt+1);
                visited[i] = false;
            }
        }
    }
}
