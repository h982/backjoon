package 백준2월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class ByteCoint17521 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static String src = "7 54\n" +
            "7\n" +
            "5\n" +
            "5\n" +
            "4\n" +
            "2\n" +
            "2\n" +
            "1";
    public static void main(String[] args)throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        long W = Integer.parseInt(str.nextToken());

        long[]arr = new long[N];
        long coin_count = 0;
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input.readLine());
        for(int i = 1; i < N; i++){
            if(arr[i] > arr[i-1]){
                coin_count += W / arr[i-1];
                W = W % arr[i-1];
            }
            else if(arr[i] < arr[i-1]){
                W += coin_count * arr[i-1];
                coin_count = 0;
            }
        }
        W += coin_count * arr[N-1];
        output.append(W);
        System.out.println(output);
    }
}
