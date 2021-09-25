package learn.dsa;

import java.util.Arrays;

public class Trie {
    private final TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    private static class TrieNode {
        private TrieNode [] child;
        private boolean isWord;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isWord = false;
        }

    }
    public void insert(String word){
        if(word==null||word.isEmpty()){
            return;
        }
        word=word.toLowerCase();
        TrieNode current=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i) - 'a';
            if(current.child[index]==null){
                TrieNode node = new TrieNode();
                current.child[index]=node;
                current=node;
            }else {
                current=current.child[index];
            }
        }
        current.isWord=true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        System.out.println(trie);
    }
}
