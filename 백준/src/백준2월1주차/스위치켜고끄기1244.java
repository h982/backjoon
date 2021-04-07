package 백준2월1주차;
import java.util.Arrays;
import java.util.Scanner;

public class 스위치켜고끄기1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] switches = new int[N];
        for(int i = 0; i < N; i++)
            switches[i] = sc.nextInt();

        int P = sc.nextInt();
        for(int p = 0; p < P; p++){
            int sex = sc.nextInt();
            int number = sc.nextInt();

            if(sex == 2){
                if(switches[number - 1] == 1)
                    switches[number-1] = 0;
                else
                    switches[number-1] = 1;
                for(int i = number - 2, j = number; i >= 0 && j < N; i--, j++ ){
                    if(!(switches[i] == switches[j]))
                        break;
                    else{
                        if(switches[i] == 1){
                            switches[i] = 0;
                            switches[j] = 0;
                        }
                        else{
                            switches[i] = 1;
                            switches[j] = 1;
                        }
                    }
                }
            }
            else if(sex == 1){
                for(int i = number-1 ; i < N; i+=number){
                    if(switches[i] == 1)
                        switches[i] = 0;
                    else{
                        switches[i] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < switches.length; i++) {
            if ((i-20) % 20 == 0)
                System.out.println();
            System.out.print(switches[i] + " ");
        }
    }
}
