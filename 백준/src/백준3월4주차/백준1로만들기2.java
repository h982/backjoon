package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class 백준1로만들기2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "999";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        int[] arr = new int[N+1];
        arr[1] = 0;
        int[] prev = new int[N+1];
        int idx = 2;
        while(idx <= N){
            int case1 = Integer.MAX_VALUE;
            int case2 = Integer.MAX_VALUE;
            int case3 = Integer.MAX_VALUE;
            if(idx % 3 == 0){
                case1 = arr[idx/3] + 1;
            }
            if(idx % 2 == 0){
                case2 = arr[idx/2] + 1;
            }
            case3 = arr[idx-1] + 1;
            arr[idx] = Math.min(Math.min(case1, case2), case3);
            if(arr[idx] == case1)
                prev[idx] = idx / 3;
            else if(arr[idx] == case2)
                prev[idx] = idx / 2;
            else
                prev[idx] = idx - 1;
            idx++;
        }
        System.out.println(arr[N]);
        idx = N;
        while (idx >= 1){
            System.out.print(idx+ " ");
            idx = prev[idx];
        }
    }
}
