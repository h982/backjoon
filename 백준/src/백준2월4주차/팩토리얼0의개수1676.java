package 백준2월4주차;
import java.util.Scanner;

public class 팩토리얼0의개수1676 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt_2 = 0, cnt_5 = 0;
        for(int i = 1; i <= N; i++){
            int temp = i;
            while(temp%2 == 0){
                cnt_2++;
                temp /= 2;
            }
            while (temp%5 == 0){
                cnt_5++;
                temp /= 5;
            }
        }
        int answer = Math.min(cnt_2, cnt_5);
        System.out.println(answer);
    }
}
