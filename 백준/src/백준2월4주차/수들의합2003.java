package 백준2월4주차;
import java.io.*;
import java.util.StringTokenizer;

public class 수들의합2003 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 2\n" +
            "1 1 1 1";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        arr = new int[N];
        str = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        count = 0;
        end_idx = 0;
        long end_sum = 0;
        for(int i = 0; i < N; i++){
            if(end_idx < 0)
                break;
            end_sum = check(i, end_sum);
        }
        System.out.println(count);
    }
    static int N, count, end_idx;
    static long M;
    static int[] arr;
    static long check(int start_idx, long end_sum){
        long sum = end_sum;
        int idx = end_idx;
        while(idx < N && sum < M){
            sum += arr[idx++];
        }
        if(sum == M) {
            count++;
            end_idx = idx;
            return M - arr[start_idx];
        } else if(sum < M){
            return -1;
        } else{
            end_idx = idx - 1;
            if(start_idx == end_idx) {
                end_idx++;
                return 0;
            }
            return sum - arr[start_idx] - arr[end_idx];
        }
    }
}
