import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 검문 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        numbers = new int[N];
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(numbers);
        boolean isflag = true;
        int M = 2;
        while(isflag){
            boolean isOk = true;
            int extra = numbers[0] % M;
            for(int i = 1; i < N; i++){
                if(numbers[i] % M != extra){
                    isOk = false;
                    if(numbers[i] % M == numbers[i]){
                        isflag = false;
                    }
                    break;
                }
            }
            if(isOk)
                output.append(M + " ");
            M++;
        }
        System.out.println(output);
    }
    static int N;
    static int[] numbers;
}
