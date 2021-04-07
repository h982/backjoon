package 백준2월1주차;
import java.util.Scanner;

public class 파스칼삼각형 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int W = sc.nextInt();

        int[][]pascal = new int[R+W][];
        pascal[0] = new int[]{1};
        for(int i = 1; i < R+W; i++){
            int[] row_pascal = new int[i+1];
            row_pascal[0] = 1;
            row_pascal[i] = 1;
            for(int j = 1; j < i; j++){
                row_pascal[j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
            pascal[i] =row_pascal;
        }
        int sum = 0;
        for(int i = R-1, k = 0; i < R + W -1; i++, k++){
            for(int j = C-1; j < C + k; j++){
                sum += pascal[i][j];
            }
        }
        System.out.println(sum);
    }
}
