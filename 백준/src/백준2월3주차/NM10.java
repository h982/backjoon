package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NM10 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(input.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(str.nextToken());
        Arrays.sort(arr);
        visited = new boolean[N];
        selected = new int[M];
        answer = new HashSet<>();
        comb(0,0);

        System.out.println(output);
    }

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] selected;
    static HashSet<String> answer;
    static void comb(int cnt, int idx){
        if(cnt == M){
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < M; i++) {
                ans.append(selected[i] + " ");
            }
            ans.setLength(ans.length() - 1);
            String an = ans.toString();
            if (!answer.contains(an)) {
                answer.add(an);
                output.append(an + "\n");
            }
            return;
        }
        for(int i = idx; i < N; i++){
            selected[cnt] = arr[i];
            comb(cnt+1, i+1);
        }
    }
}