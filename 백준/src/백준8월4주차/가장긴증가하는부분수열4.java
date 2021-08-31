package 백준8월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열4 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1];

        int max = 0;
        int maxIdx = 0;
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                maxIdx = i;
            }
        }
        int[] ans = new int[max];
        int idx = maxIdx;
        for(int i = max-1; i >= 0; i--){
            ans[i] = arr[idx];
            idx = prev[idx];
        }
        output.append(max).append("\n");
        for(int i = 0; i < max; i++)
            output.append(ans[i]).append(" ");

        System.out.println(output);
    }
    static void copy(List dest, List src){
        dest.removeAll(dest);
        for(Object object : src)
            dest.add(object);
    }
}
