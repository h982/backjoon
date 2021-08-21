package 백준8월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        int[][] layers = new int[N+1][];
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[3];
            for(int j = 0; j < 3; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            layers[i] = temp;
        }
        int[] minDp = new int[3];
        int[] maxDp = new int[3];
        for(int i = 1; i <= N; i++){
            int[] tempMin = new int[3];
            tempMin[0] = Math.min(minDp[0], minDp[1]) + layers[i][0];
            tempMin[1] = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]) + layers[i][1];
            tempMin[2] = Math.min(minDp[1], minDp[2]) + layers[i][2];
            minDp = tempMin;

            int[] tempMax = new int[3];
            tempMax[0] = Math.max(maxDp[0], maxDp[1]) + layers[i][0];
            tempMax[1] = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + layers[i][1];
            tempMax[2] = Math.max(maxDp[1], maxDp[2]) + layers[i][2];
            maxDp = tempMax;
        }
        output.append(Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) +" ");
        output.append(Math.min(Math.min(minDp[0], minDp[1]), minDp[2]) );
        System.out.println(output);
    }
}
