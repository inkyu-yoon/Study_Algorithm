package LeetCode150.주차3_2.ImplementTie;

import java.util.HashMap;
import java.util.Map;

class Trie {

    static class Node {
        Map<Character, Node> children;
        boolean isEndOfWord;

        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

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

        char c = word.charAt(0);
        Node child;
        if (!node.children.containsKey(c)) {
            child = new Node();
            node.children.put(c, child);
        } else {
            child = node.children.get(c);
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

        char c = word.charAt(0);
        if (!node.children.containsKey(c)) {
            return false;
        }

        return search(node.children.get(c), word.substring(1));
    }

    public boolean startsWith(String prefix) {
        Node currentNode = this.root;
        for (char c : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }

        return true;
    }


}
