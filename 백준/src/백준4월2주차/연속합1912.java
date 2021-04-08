package 백준4월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합1912 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5\n" +
            "-1 -2 -3 -4 -5";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int[] ans = new int[N];
        ans[0] = arr[0];
        for(int i = 1; i < N; i++){
            int temp = ans[i-1] + arr[i];
            if(temp > arr[i]){
                ans[i] = temp;
                continue;
            }
            ans[i] = arr[i];
        }
        Arrays.sort(ans);
        System.out.println(ans[N-1]);
    }
}
