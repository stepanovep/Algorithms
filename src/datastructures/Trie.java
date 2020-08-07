package datastructures;

class Trie {

    static class TrieNode {
        // R links to node children
        private final TrieNode[] links;

        private static final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private final TrieNode root;

    Trie(TrieNode root) {
        this.root = root;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }

            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (node.containsKey(cur)) {
                node = node.get(cur);
            } else {
                return null;
            }
        }

        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie(new TrieNode());

        trie.insert("le");
        trie.insert("leet");
        trie.insert("code");

        System.out.println(trie.search("leet"));
        System.out.println(trie.startsWith("lee"));
    }
}

//https://leetcode.com/problems/implement-trie-prefix-tree/
//https://leetcode.com/problems/add-and-search-word-data-structure-design/
