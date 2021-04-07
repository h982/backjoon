package 백준3월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class RGB거리 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "26 40 83\n" +
            "49 60 57\n" +
            "13 89 99";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        int[][] house = new int[N+1][];
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[3];
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            temp[2] = Integer.parseInt(st.nextToken());
            house[i] = temp;
        }
        int[][] minColored = new int[N+1][3];
        int idx = 1;
        while (idx <= N){
            for(int i = 0; i < 3; i++){
                int diff1 = (i+1)%3;
                int diff2 = (i+2)%3;
                if(minColored[idx-1][diff1] < minColored[idx-1][diff2]){
                    minColored[idx][i] = minColored[idx-1][diff1] + house[idx][i];
                }else{
                    minColored[idx][i] = minColored[idx-1][diff2] + house[idx][i];
                }
            }
            idx++;
        }
        int min = Math.min(Math.min(minColored[N][0], minColored[N][1]) , minColored[N][2]);
        System.out.println(min);
    }
}
