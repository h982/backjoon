package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 구간합구하기11659 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5 3\n" +
            "5 4 3 2 1\n" +
            "1 3\n" +
            "2 4\n" +
            "5 5";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        int[] nums = new int[N];
        str = new StringTokenizer(input.readLine());
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += Integer.parseInt(str.nextToken());
            nums[i] = sum;
        }
        int[][]start_end = new int[M][];
        for(int i = 0; i < M; i++){
            str = new StringTokenizer(input.readLine());
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(str.nextToken());
            temp[1] = Integer.parseInt(str.nextToken());
            start_end[i] = temp;
        }

        for(int i = 0; i < M; i++){
            sum = nums[start_end[i][1] -1];
            if(start_end[i][0] != 1){
                sum -= nums[start_end[i][0] - 2];
            }
            output.append(sum + "\n");
        }
        System.out.println(output);
    }
}
