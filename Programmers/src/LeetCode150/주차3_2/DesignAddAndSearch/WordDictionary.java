package LeetCode150.주차3_2.DesignAddAndSearch;

import java.util.*;

class WordDictionary {

    static class Node {
        Map<Character, Node> children;
        boolean isEndOfWord;

        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;

        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        addWord(this.root, word);
    }

    private void addWord(Node node, String word) {
        if (word.length() == 0) {
            node.isEndOfWord = true;
            return;
        }

        char ch = word.charAt(0);
        Node child;
        if (node.children.containsKey(ch)) {
            child = node.children.get(ch);
        } else {
            child = new Node();
            node.children.put(ch, child);
        }

        addWord(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    private boolean search(Node node, String word) {
        if (word.length() == 0) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(0);
        if (ch == '.') {

            for (Node child : node.children.values()) {
                if (search(child, word.substring(1))) {
                    return true;
                }
            }
            return false;
        }

        if (!node.children.containsKey(ch)) {
            return false;
        } else {
            return search(node.children.get(ch), word.substring(1));
        }

    }
}

