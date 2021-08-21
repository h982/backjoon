import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = Integer.MAX_VALUE;
        int sum = arr[0];
        int left = 0;
        int right = 0;

        while(left <= right && right < N){
            if(sum < S){
                sum += arr[++right];
                continue;
            }
            if(sum == S){
                length = Math.min(length, right - left + 1);
                sum += arr[++right];
                continue;
            }
            if(sum > S){
                length = Math.min(length, right - left + 1);
                sum -= arr[left++];
                continue;
            }
        }
        System.out.println(length==Integer.MAX_VALUE?0:length);
    }
}
