package Tree.TrieTree;

/**
 * @ClassName TrieTree_Code1
 * @Description 前缀树
 * @Author Langtao
 * @Date 2021/3/2 21:27
 * @Version V1.0
 */
public class Trie {

    //根节点
    TrieNode root;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * 1.节点已存在,沿着指针指向下一个子节点
     * 2.节点不存在,创建TrieNode节点
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        //标记字符串结尾
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    /**
     * TrieNode节点
     */
    static class TrieNode{
        //当前节点是否为该字符串的结尾
        boolean isEnd;
        //当前节点的子节点
        TrieNode[] children;


        /**
         * 初始化
         */
        public TrieNode(){
            children= new TrieNode[26];
        }
    }

}
