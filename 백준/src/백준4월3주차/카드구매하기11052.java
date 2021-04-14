package 백준4월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기11052 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        int[] cardPack = new int[N+1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 1; i <= N; i++)
            cardPack[i] = Integer.parseInt(st.nextToken());

        int[] maxPrice = new int[N+1];
        for(int i = 1; i <= N; i++){
            maxPrice[i] = cardPack[i];
            for(int j = 1; j <= i/2; j++){
                int temp = maxPrice[j] + maxPrice[i-j];
                if(temp > maxPrice[i])
                    maxPrice[i] = temp;
            }
        }
        System.out.println(maxPrice[N]);
    }
}
