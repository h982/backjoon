package 백준2월1주차;
import java.util.Scanner;

public class 설탕배달2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for(int N = 1; N < 5000; N++ ) {
            int result = 5000;
            for (int i = 0; i <= N / 5; i++) {
                for (int j = 0; j <= N / 3; j++) {
                    if ((i * 5 + j * 3) == N) {
                        if ((i + j) < result)
                            result = i + j;
                    }
                }
            }
            if(result == 5000)
                result = -1;

            int ans = 0;
            if (N % 5 == 0) {
                ans = N / 5;
            } else if ((N-3) >= 0 && (N - 3) % 5 == 0) {
                ans = ((N - 3) / 5) + 1;
            } else if ((N - 6) >= 0 && (N - 6) % 5 == 0) {
                ans = ((N - 6) / 5) + 2;
            } else if ((N - 9) >= 0 && (N - 9) % 5 == 0) {
                ans = ((N - 9) / 5) + 3;
            } else if ((N - 12) >= 0 && (N - 12) % 5 == 0) {
                ans = ((N - 12) / 5) + 4;
            } else {
                ans = -1;
            }

            if(result != ans){
                System.out.println(N + " : " + result + " , " + ans);
            }
        }
    }
}
