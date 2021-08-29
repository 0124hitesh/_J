import java.util.Map;
import java.util.HashMap;

public class Trie {
    class Node{
        char val;
        Map<Character, Node> hm;
        boolean isMark;
        int freq;

        Node(char c){
            val = c;
            hm = new HashMap<>();
            isMark = false;
            freq = 0;
        }
    }

    Node root;

    Trie(){
        this.root = new Node('*');
    } 

    void insert(String s){

        Node cur = root;

        for(char c : s.toCharArray()){
            if(cur.hm.containsKey(c)){
                cur = cur.hm.get(c);
            }
            else{
                Node n = new Node(c);
                cur.hm.put(c, n);
                cur = n;
            }

            cur.freq++;
        }

        cur.isMark = true;
    }

    boolean search(String s){
        Node cur = root;

        for(char c : s.toCharArray()){
            if(cur.hm.containsKey(c)){
                cur = cur.hm.get(c);
            }
            else
                return false;
        }

        return cur.isMark;        
    }

    int prefixCount(String s){
        Node cur = root;

        for(char c : s.toCharArray()){
            if(cur.hm.containsKey(c)){
                cur = cur.hm.get(c);
            }
            else
                return 0;
        }

        return cur.freq;
    }

    boolean checkPrefix(String s){
        Node cur = root;

        for(char c : s.toCharArray()){
            if(cur.hm.containsKey(c)){
                cur = cur.hm.get(c);
            }
            else
                return false;
        }

        return true;
    }

    public static void main(String...args){
        Trie trie = new Trie();

        trie.insert("hitesh");
        trie.insert("hite");
        trie.insert("sharma");

        System.out.println(trie.search("hit") + " " + trie.search("sharma"));
        System.out.println(trie.checkPrefix("hit"));
        System.out.println(trie.prefixCount("hit"));
    }
}
