package 백준9월1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수묶기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(arr);
        int minus = -1;
        int sum = 0;
        for(int i = N-1; i >= 0; i--){
            if(i > 0){
                int big = arr[i];
                int small = arr[i-1];
                if(big <= 0){
                    minus = i;
                    break;
                }
                if(small <= 0){
                    sum += big;
                    minus = i-1;
                    break;
                }
                i--;
                if(small == 1){
                    sum += big + small;
                    continue;
                }
                sum += big * small;
                continue;
            }
            sum += arr[i];
        }
        for(int i = 0; i <= minus; i++){
            if(i < minus){
                sum += arr[i] * arr[i+1];
                i++;
                continue;
            }
            sum += arr[i];
        }
        System.out.println(sum);
    }
    static int N;
    static int[] arr;
}
