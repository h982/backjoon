import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        H = Integer.parseInt(input.readLine());

        st = new StringTokenizer(input.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        junior = 0;
        senior = 0;
        for(int i = 0; i < H; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp >= 65)
                senior++;
            else
                junior++;
        }
        System.out.println(simulation());
    }
    static int H, M, N, K;
    static int junior, senior;
//    static Queue<Integer> pfizer;
//    static Queue<Integer> moderna;
    static int simulation(){
        int result = 0;
        int moderna = 0;
        if(senior > M/2)
            moderna += senior - M/2;
        if(junior > K)
            moderna += junior - K;

        if(moderna > N)
            return -1;

        int moderna_start = 1;
        int moderna_end = moderna_start + moderna / 10;
        int moderna_start_count = 10;
        if(moderna < 10)
            moderna_start_count = moderna;
        int moderna_end_count = moderna % 10;
        if(moderna > 0 && moderna % 10 == 0)
            moderna_end_count = 10;

        int remain_senior = senior;
        if(senior > M/2)
            remain_senior = M/2;
        int pfizer_start = moderna_end;
        int pfizer_start_count = 10;
        int pfizer_end = pfizer_start;
        if(moderna_end_count != 10) {
            if(remain_senior < 10 - moderna_end_count) {
                remain_senior -= (10 - moderna_end_count);
                pfizer_start_count = 10 - moderna_end_count;
                pfizer_end++;
            }else{
                pfizer_start_count = remain_senior;
                remain_senior = 0;
            }
        }else{
            pfizer_start++;
            pfizer_end++;
        }
        if(remain_senior < 10)
            pfizer_start_count = remain_senior;
        pfizer_end += remain_senior/10;
        int pfizer_end_count = remain_senior % 10;
        if(remain_senior > 0 && remain_senior % 10 == 0)
            pfizer_end_count = 10;

        int pfizer_2_start = pfizer_start + 5;
        int pfizer_2_end = pfizer_end + 5;
        int moderna_2_start = moderna_start + 7;
        int moderna_2_end = moderna_end + 7;

        int remain_junior = junior;
        if(junior > K)
            remain_junior = K;

        int available_moderna = 0;
        int available_pfizer = 0;
        int available_janssen = K;

        int moderna_2 = moderna;
        int pfizer_2 = remain_senior;

        int result_date = pfizer_end;
        while(remain_junior > 0 || moderna_2 > 0 || pfizer_2 > 0){
            if(result_date > moderna_2_start)
//            int limit = 10;
            if(remain_junior > 0 && available_janssen > 0){

            }
        }

        return result;
    }
}
