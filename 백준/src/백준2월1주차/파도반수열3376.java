package 백준2월1주차;
import java.util.Scanner;

public class 파도반수열3376 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();

            Long length;
            if(N <= 3)
                length = 1l;
            else if(N <= 5)
                length = 2l;
            else{
                long[] arr = new long[N];
                for(int i = 0; i < 3; i++)
                    arr[i] = 1l;
                for(int i = 3; i < 5; i++)
                    arr[i] = 2l;

                for(int i = 5; i < N; i++)
                    arr[i] = arr[i-1] + arr[i - 5];
                length = arr[N-1];
            }
            System.out.println("#" + test_case + " " + length);

        }
    }
}
