package 백준8월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열폭발 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = input.readLine();
        String boom = input.readLine();

        StringBuilder sb = new StringBuilder();
        char last = boom.charAt(boom.length()-1);
        String chkBoom = boom.substring(0, boom.length()-1);
        for(int i = 0; i < line.length(); i++) {
            char temp = line.charAt(i);
            if(sb.length() >= chkBoom.length() && temp == last){
                String inspect = sb.substring(sb.length() - chkBoom.length());
                if(inspect.equals(chkBoom)){
                    sb.delete(sb.length() - chkBoom.length(), sb.length());
                    continue;
                }
            }
            sb.append(temp);
        }
        line = sb.toString();

        if(line.length() > 0)
            System.out.println(line);
        else
            System.out.println("FRULA");
    }
}
