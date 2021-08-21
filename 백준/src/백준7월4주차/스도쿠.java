import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 스도쿠 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();


    public static void main(String[] args) throws IOException {

        sudoku = new int[9][];
        StringTokenizer st;
        for(int i = 0; i < 9; i++){
            int[] temp = new int[9];
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < 9; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            sudoku[i] = temp;
        }
        makeSudoku(0,0);

        for(int[] sudo:sudoku){
            for(int su: sudo)
                output.append(su +" ");
            output.append("\n");
        }
        System.out.println(output);
    }
    static int[][] sudoku;
    static boolean makeSudoku(int r, int c){
        int[] loc = nextZero(r, c);
        int row = loc[0];
        int col = loc[1];
        if(row == 9)
            return true;

        for(int i = 1; i <= 9; i++){
            if(checkRow(loc[0], i) && checkCol(loc[1], i) && checkBox(loc[0], loc[1], i)){
                sudoku[row][col] = i;
                if(makeSudoku(row, col))
                    return true;
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    static int[] nextZero(int row, int col){
        while(row<9 && sudoku[row][col] != 0){
            if(++col >= 9){
                col %= 9;
                row++;
            }
        }
        return new int[]{row, col};
    }
    static boolean checkRow(int row, int value){
        for(int i = 0; i < 9; i++){
            if(sudoku[row][i] == value)
                return false;
        }
        return true;
    }
    static boolean checkCol(int col, int value){
        for(int i = 0; i < 9; i++){
            if(sudoku[i][col] == value)
                return false;
        }
        return true;
    }
    static boolean checkBox(int row, int col, int value){
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        int ro,co;
        for(int i = 0; i < 9; i++){
            ro = r + (i/3);
            co = c + (i%3);
            if(sudoku[ro][co] == value)
                return false;
        }
        return true;
    }
}

