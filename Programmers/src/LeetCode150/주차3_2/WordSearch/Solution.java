package LeetCode150.주차3_2.WordSearch;

import java.util.*;

class Solution {
    int R;
    int C;
    boolean[][] checked;
    char[][] board;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    Trie trie = new Trie();
    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        R = board.length;
        C = board[0].length;
        checked = new boolean[R][C];

        for (String word : words) {
            trie.insert(word);
        }


        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                checked[r][c] = true;
                sb.append(board[r][c]);
                bt(r, c, trie.root);
                checked[r][c] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return ans;
    }

    public void bt(int r, int c, Node node) {
        char ch = board[r][c];

        if (!node.children.containsKey(ch)) {
            return;
        }

        Node child = node.children.get(ch);

        if (child.isEndOfWord) {
            ans.add(sb.toString());
            child.isEndOfWord = false;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (0 <= nr && nr < R && 0 <= nc && nc < C && !checked[nr][nc]) {
                checked[nr][nc] = true;
                sb.append(board[nr][nc]);
                bt(nr, nc, child);
                checked[nr][nc] = false;
                sb.deleteCharAt(sb.length() - 1);

            }
        }

    }


}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        insert(this.root, word);
    }

    private void insert(Node node, String word) {
        if (word.length() == 0) {
            node.isEndOfWord = true;
            return;
        }

        char ch = word.charAt(0);
        Node child;
        if (!node.children.containsKey(ch)) {
            child = new Node();
            node.children.put(ch, child);
        } else {
            child = node.children.get(ch);
        }

        insert(child, word.substring(1));

    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    private boolean search(Node node, String word) {
        if (word.length() == 0) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(0);

        if (!node.children.containsKey(ch)) {
            return false;
        }

        return search(node.children.get(ch), word.substring(1));
    }
}

class Node {
    Map<Character, Node> children;
    boolean isEndOfWord;

    public Node() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}