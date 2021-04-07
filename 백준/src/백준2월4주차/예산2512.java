package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산2512 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "120 110 140 150\n" +
            "11";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        int[] arr = new int[N];
        StringTokenizer str = new StringTokenizer(input.readLine());
        long sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
            sum += arr[i];
        }
        long limit = Long.parseLong(input.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = arr[N-1];
        int middle, ans = 0;
        while(true){
            if(left > right)
                break;

            middle = (left + right) / 2;
            sum = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] < middle)
                    sum += arr[i];
                else{
                    sum += (long)middle * (N-i);
                    break;
                }
            }
            if(sum > limit){
                right = middle - 1;
                continue;
            }
            else if(sum < limit){
                ans = Math.max(ans, middle);
                left = middle + 1;
                continue;
            }else{
                ans = middle;
                break;
            }
        }
        System.out.println(ans);
    }
}
