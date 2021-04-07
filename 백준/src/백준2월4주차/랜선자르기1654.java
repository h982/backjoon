package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기1654 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 11\n" +
            "802\n" +
            "743\n" +
            "457\n" +
            "539";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        K = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());

        wires = new int[K];
        for(int i = 0; i < K; i++)
            wires[i] = Integer.parseInt(input.readLine());
        Arrays.sort(wires);
        long ans = makeLan();
        System.out.println(ans);
    }
    static int K, N;
    static int[] wires;
    static long makeLan(){

        long left = 1;
        long right = wires[K-1];
        int count;
        long answer = 0;
        while(left <= right){
            count = 0;
            long mid = (left + right) / 2;
            for(int i = 0; i < K; i++){
                int wire = wires[i];
                count += wire / mid;
            }
            if(count >= N){
                answer = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return answer;
    }
}
