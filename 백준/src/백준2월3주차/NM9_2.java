package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NM9_2 {
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
        before_selected = new int[M];
        permu(0);

        System.out.println(output);
    }

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] selected;
    static int[] before_selected;
    static void permu(int cnt) {
        if (cnt == M) {
            if(checkArr(cnt)) {
                return;
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < M; i++) {
                ans.append(selected[i] + " ");
            }
            ans.setLength(ans.length() - 1);
            String an = ans.toString();
            System.arraycopy(selected, 0, before_selected, 0, M);

            output.append(an + "\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                selected[cnt] = arr[i];
                if(checkArr(cnt + 1))
                    continue;

                visited[i] = true;
                permu(cnt + 1);
                visited[i] = false;
            }
        }
    }

    static boolean checkArr(int idx){

        for(int i = 0; i < idx; i++){
            if(selected[i] != before_selected[i])
                return false;
        }
        return true;
    }
}
