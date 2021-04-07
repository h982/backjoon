package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NM9 {
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
        permu(0);

        System.out.println(output);
    }

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] selected;
    static HashSet<String> answer;

    static void permu(int cnt) {
        if (cnt == M) {
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

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cnt] = arr[i];
                permu(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
//    static boolean checkList(int[] check){
//        int[] ans;
//        boolean hasSame;
//        for (int i = 0; i < answer.size(); i++){
//
//            hasSame = true;
//            for(int j = 0; j < M; j++){
//                if(ans[j] != check[j]){
//                    hasSame = false;
//                    break;
//                }
//            }
//            if (hasSame){
//                return true;
//            }
//        }
//        return false;
//    }
//}
