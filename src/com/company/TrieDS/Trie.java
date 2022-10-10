package com.company.TrieDS;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] dictionary = {"apple", "car", "abcd", "app"};
        for (String s : dictionary) {
            trie.insert(s);
        }
        System.out.println(trie.search("abc"));
        System.out.println(trie.delete("abcd"));
        System.out.println(trie.search("abcd"));
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    void insert(String s) {
        if (s == null || s.length() == 0) return;
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!current.map.containsKey(letter)) {
                current.map.put(letter, new TrieNode());
            }
            current = current.map.get(letter);
        }
        current.isEndOfWord = true;
    }

    boolean search(String s) {
        if (s == null || s.length() == 0) return false;
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!current.map.containsKey(letter)) {
                return false;
            }
            current = current.map.get(letter);
        }
        return current.isEndOfWord;
    }

    boolean delete(String s) {
        if (s == null || s.length() == 0) return false;
        TrieNode current = root;
        TrieNode nodeToDelete = null;
        char charToDelete = '\0';
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!current.map.containsKey(letter)) {
                return false;
            }
            if (current.map.size() > 1 || current.isEndOfWord) {
                nodeToDelete = current;
                charToDelete = letter;
            }
            current = current.map.get(letter);
        }

        if (!current.isEndOfWord) return false;

        if (current.map.isEmpty()) {
            nodeToDelete.map.remove(charToDelete);
        }else {
            current.isEndOfWord = false;
        }
        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> map;
    boolean isEndOfWord;
    public TrieNode() {
        map = new HashMap<>();
    }
}
