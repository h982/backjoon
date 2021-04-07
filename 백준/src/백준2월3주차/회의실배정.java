package 백준2월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class 회의실배정 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "12\n" +
            "1 4\n" +
            "4 4\n" +
            "5 9\n" +
            "0 6\n" +
            "5 7\n" +
            "4 5\n" +
            "3 8\n" +
            "6 10\n" +
            "8 11\n" +
            "8 12\n" +
            "2 13\n" +
            "12 14";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        int[][] times = new int[N][];
        StringTokenizer str;
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(input.readLine());
            int[] time = new int[2];
            time[0] = Integer.parseInt(str.nextToken());
            time[1] = Integer.parseInt(str.nextToken());
            times[i] = time;
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int now_time = 0;
        int count = 0;
        for(int i = 0; i < N; i++){
            if(times[i][0] >= now_time){
                now_time = times[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
