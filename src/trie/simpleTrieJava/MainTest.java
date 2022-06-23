package trie.simpleTrieJava;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void construct(){
        List<String> strList = new ArrayList();
        strList.add("Batman");
        TrieNode root = TrieNode.construct(strList);
        assertTrue(root.hasChild('B'));
    }

    @Test
    void emptyConstruct(){
        List<String> strList = new ArrayList();
        TrieNode root = TrieNode.construct(strList);
        assertEquals(0, root.getChildCount());
    }

    @Test
    void identicalStrings(){
        List<String> strList = new ArrayList();
        String BATMAN = "Batman";
        strList.add(BATMAN);
        strList.add(BATMAN);
        TrieNode currentNode = TrieNode.construct(strList);
        for(Character c: BATMAN.toCharArray()){
            assertEquals(1, currentNode.getChildCount());
            currentNode = currentNode.getChildNode(c);
        }

    }

    @Test
    void countTest(){
        List<String> strList = new ArrayList();
        strList.add("Batman");
        strList.add("Batgirl");
        strList.add("Gordon");
        TrieNode root = TrieNode.construct(strList);
        assertEquals(2, root.getChildNode('B').getChildNode('a').getChildNode('t').getChildCount());

    }

    @Test
    void queryTrue(){
        List<String> strList = new ArrayList();
        strList.add("Bat");
        strList.add("Family");
        strList.add("Bruce");
        TrieNode root = TrieNode.construct(strList);
        root.query("Family");
    }

    @Test
    void queryFalse(){
        List<String> strList = new ArrayList();
        strList.add("Robin");
        TrieNode root = TrieNode.construct(strList);
        root.query("powers");
    }

    @Test
    void queryIdenticalPrefix(){
        List<String> strList = new ArrayList();
        strList.add("Red");
        TrieNode root = TrieNode.construct(strList);
        assertFalse(root.query("Redhood"));

    }

    @Test
    void queryIdenticalPrefixReversed(){
        List<String> strList = new ArrayList();
        strList.add("Redhood");
        TrieNode root = TrieNode.construct(strList);
        assertFalse(root.query("Red"));
    }

    @Test
    void queryEmptyList(){
        List<String> strList = new ArrayList();
        TrieNode root = TrieNode.construct(strList);
        assertFalse(root.query("Nightwing"));
    }
}
