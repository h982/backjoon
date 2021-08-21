import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어수학 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        lines = new String[N];
        int maxSize = 0;
        for(int i = 0; i < N; i++){
            lines[i] = input.readLine();
        }

        for(String line : lines){
            if(maxSize < line.length()){
                maxSize = line.length();
            }
        }
        alpha = new int['Z' - 'A' + 1];
        calc();
        boolean[] isUsed= new boolean[26];
        int num = 9;
        int sum = 0;
        for(int i = 0; i < 26; i++){
            if(num == -1){
                break;
            }
            boolean flag = true;
            int max_val = 0;
            int idx = 0;
            for(int j = 0; j < 26; j++){
                if(isUsed[j])
                    continue;
                if(alpha[j] > max_val){
                    max_val = alpha[j];
                    idx = j;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
            isUsed[idx] = true;
            sum += max_val * num--;
        }
        System.out.println(sum);
    }
    static int N;
    static String[] lines;
    static int[] alpha;

    static void calc(){
        for(String line : lines){
            int temp = 1;
            int size = line.length() - 1;
            for(int i = size; i >= 0; i--){
                alpha[line.charAt(i) - 'A'] += temp;
                temp *= 10;
            }
        }
    }
}