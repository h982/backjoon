import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 무인도 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(input.readLine());
            boxes = new ArrayList<>();
            StringTokenizer st;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(input.readLine());
                int[] temp = new int[3];
                for(int j = 0; j < 3; j++){
                    temp[j] = Integer.parseInt(st.nextToken());
                }
                boxes.add(temp);
            }
            max_height = 0;
            isUsed = new boolean[N];
            for(int i = 0; i < N; i++){
                int[] temp = boxes.get(i);
                isUsed[i] = true;
                for(int j = 0; j < 3; j++){
                    permu(1, temp[j], temp[(j+1)%3], temp[(j+2)%3]);
                }
                isUsed[i] = false;
            }
            output.append("#" + test_case + " " + max_height +"\n");
        }
        System.out.println(output);
    }
    static int N, max_height;
    static List<int[]> boxes;
    static boolean[] isUsed;
    static void permu(int cnt, int x, int y, int height){
        if(cnt == N){
            if(height > max_height)
                max_height = height;
            return;
        }
        for(int i = 0; i < N; i++){
            if(!isUsed[i]){
                int[] temp = boxes.get(i);
                isUsed[i] =  true;
                boolean isNo = false;
                if((temp[0] <= x && temp[1] <= y) || (temp[1] <= x && temp[0] <= y)){
                    permu(cnt+1, temp[0], temp[1], height + temp[2]);
                    isNo = true;
                }
                if((temp[0] <= x && temp[2] <= y) || (temp[0] <= y && temp[2] <= x)){
                    permu(cnt+1, temp[0], temp[2], height + temp[1]);
                    isNo = true;
                }
                if((temp[1] <= x && temp[2] <= y) || (temp[1] <= y && temp[2] <= x)){
                    permu(cnt+1, temp[1], temp[2], height + temp[0]);
                    isNo = true;
                }
                if(!isNo)
                    permu(cnt+1, x, y, height);
                isUsed[i] = false;
            }
        }
    }
}
