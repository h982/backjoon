package 백준2월1주차;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기2 {
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++){
            Queue<Integer> queue = new LinkedList<>();
            sc.nextInt();
            int[] codes = new int[8];
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 8; i++) {
                codes[i] = sc.nextInt();
                if(codes[i] < min)
                    min = codes[i];
            }
            // 15 * 8
            int sub = (min/(15*8)) * 15 * 8;
            for(int i = 0; i < 8; i++){
                queue.add(codes[i] - sub);
            }
            int temp = 0;
            int minus = 1;
            while (true){
                temp = queue.poll() - minus;
                if(temp <= 0) {
                    queue.add(0);
                    break;
                }
                queue.add(temp);
                minus = minus % 5 + 1;
            }
            output.append("#" + test_case + " ");
            for(int a : queue){
                output.append(a + " ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}
