package datastructures;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class TrieNode {
        private final Map<Character, TrieNode> links = new HashMap<>();
        private boolean isWord = false;
    }

    private final TrieNode root;

    public Trie(TrieNode root) {
        this.root = root;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (!node.links.containsKey(ch)) {
                node.links.put(ch, new TrieNode());
            }
            node = node.links.get(ch);
        }
        node.isWord = true;
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char ch: prefix.toCharArray()) {
            if (node.links.containsKey(ch)) {
                node = node.links.get(ch);
            } else {
                return null;
            }
        }

        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie(new TrieNode());

        trie.insert("asdf");
        trie.insert("fff");
        trie.insert("ffsdf");

        System.out.println(trie.startsWith("ff"));

        System.out.println(trie.search("asd"));
        System.out.println(trie.search("asdf"));
    }
}

//https://leetcode.com/problems/implement-trie-prefix-tree/
//https://leetcode.com/problems/add-and-search-word-data-structure-design/
