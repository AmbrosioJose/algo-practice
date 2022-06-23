package trie.simpleTrieJava;
import java.util.HashMap;
import java.util.List;

public class TrieNode {
    private Character current;
    private HashMap<Character, TrieNode> children;

    // Character symbolizing the start
    private static Character START = '*';
    // Character symbolizing the end of a String
    private static Character END = '$';

    public TrieNode(Character c){
        current = c;
        children = new HashMap<>();
    }

    public int getChildCount(){
        return children.size();
    }

    public void addChild(TrieNode child){
        if(!hasChild(child.current)){
            children.put(child.current, child);
        }
    }

    public boolean hasChild(Character c){
        return children.containsKey(c);
    }

    public TrieNode getChildNode(Character c){
        return children.get(c);
    }

    // Cat
    public static TrieNode construct(List<String> stringList){
        // root *
        TrieNode root = new TrieNode(START);
        for(String s: stringList){
            TrieNode currentNode = root;
            s = s.concat(TrieNode.END.toString());
            // s = Cat$
            for(Character c: s.toCharArray()){
                if(!currentNode.hasChild(c)){
                    // C
                    TrieNode newNode = new TrieNode(c);
                    // * -> C
                    currentNode.addChild(newNode);
                }
                // C
                currentNode = currentNode.getChildNode(c);
            }
        }
        return root;
    }


    // Cat
    public boolean query(String str){
        TrieNode currentNode = this;

        // Cat$
        str = str.concat(END.toString());
        for(Character c: str.toCharArray()){
            if(currentNode.hasChild(c)){
                currentNode = currentNode.getChildNode(c);
            } else
                return false;
        }
        return currentNode.current.equals(TrieNode.END);
    }




}
