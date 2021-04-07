package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 냉장고 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "-15 5\n" +
            "-10 36\n" +
            "10 73\n" +
            "27 44";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        int[][] temper = new int[N][];
        StringTokenizer str;
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(input.readLine());
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(str.nextToken());
            temp[1] = Integer.parseInt(str.nextToken());
            temper[i] = temp;
        }
        Arrays.sort(temper, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o1[0] - o2[0];
                return diff != 0 ? diff: o1[1] - o2[1];
            }
        });

        int end_temp = temper[0][1];
        int refr_count = 1;
        for(int i = 1; i < N; i++){
            if(temper[i][0] > end_temp){
                refr_count++;
                end_temp = temper[i][1];
            }
            else if(temper[i][1] < end_temp)
                end_temp = temper[i][1];
        }

        System.out.println(refr_count);
    }
}
