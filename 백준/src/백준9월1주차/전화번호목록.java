package 백준9월1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(input.readLine());
            String[] numbers = new String[N];
            for(int i = 0; i < N; i++)
                numbers[i] = input.readLine();
            Arrays.sort(numbers, (o1, o2) -> o2.length()-o1.length());
            Trie trie = new Trie();
            boolean flag = true;
            for(int i = 0; i < N; i++){
                if(trie.contains(numbers[i])){
                    flag = false;
                    break;
                }
                trie.insert(numbers[i]);
            }
            if(flag){
                output.append("YES\n");
                continue;
            }
            output.append("NO\n");
        }
        System.out.println(output);
    }
}
class TrieNode {
    // 자식 노드맵.
    private Map<Character, TrieNode> childeNodes = new HashMap<>();
    // 마지막 글자인지 여부.
    private boolean isLastChar;

    public Map<Character, TrieNode> getChildNodes() {
        return childeNodes;
    }

    public boolean isLastChar() {
        return this.isLastChar;
    }

    public void setLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}

class Trie {
    // 루트 노드.
    private TrieNode rootNode;

    Trie() {
        rootNode = new TrieNode();
    }

    void insert(String word) {
        TrieNode thisNode = this.rootNode;

        // word 문자열의 각 단어를 확인한다.
        // thisNode 가 word 문자열의 각 단어를 key 로 하는 자식 노드가 존재하지 않을 때만 자식 노드를 생성해준다.
        for (int i = 0; i < word.length(); i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setLastChar(true);
    }

    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            // TrieNode 가 가지고 있는 자식 노드 중에서 해당 문자를 가진 노드를 가져온다.
            TrieNode node = thisNode.getChildNodes().get(character);

            // rootNode 의 자식 노드 중 해당 문자를 가진 노드가 없다면 null 이므로 false 를 반환한다.
            // 즉, word 라는 문자가 없음을 뜻한다.
            if (node == null) {
                return false;
            }

            // 문자가 존재하면 문자열의 모든 단어가 trie 에 존재하는지 확인하기 위해서
            // thisNode 를 자식 노드로 바꾸면서 반복한다.
            thisNode = node;
        }
        return true;
    }
}