package 백준3월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 이전순열10973 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "1 2 3 4";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        int[] arr = new int[N];
        StringTokenizer str = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        int idx = N - 1;
        boolean isOk = true;
        while(true){
            if(idx == 0){
                isOk = false;
                break;
            }
            if(arr[idx-1] > arr[idx]){
                idx = idx - 1;
                break;
            }
            idx--;
        }
        if(!isOk) {
            System.out.println(-1);
            return;
        }

        int f_idx = N - 1;
        while(true){
            if(arr[f_idx] < arr[idx]){
                int temp = arr[idx];
                arr[idx] = arr[f_idx];
                arr[f_idx] = temp;
                break;
            }
            f_idx--;
        }

        int left = idx + 1;
        int right = N - 1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for(int a : arr){
            output.append(a + " ");
        }
        System.out.println(output);
    }
}
