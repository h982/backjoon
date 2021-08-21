package 백준8월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class 카드정렬하기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(input.readLine()));
        }
        int chk = 0;
        while(cards.size() > 1){
            int newDeck = cards.poll() + cards.poll();
            chk += newDeck;
            cards.add(newDeck);
        }
        System.out.println(chk);
    }
}
