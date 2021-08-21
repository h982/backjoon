import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[N];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0, arr[0]});
        int min = arr[0];
        for(int i = 1; i < N; i++){
            int temp = arr[i];
            if(temp > min) {
                while (!stack.isEmpty()) {
                    if(temp > stack.peek()[1]) {
                        int[] small = stack.pop();
                        ans[small[0]] = temp;
                        continue;
                    }
                    break;
                }
            }
            stack.add(new int[]{i, temp});
            min = temp;
        }
        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            ans[temp[0]] = -1;
        }
        for(int an : ans){
            output.append(an + " ");
        }
        System.out.println(output);
    }
    static int N;
}
