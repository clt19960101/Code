package Tree.TrieTree;

/**
 * @ClassName TrieTree_Code1
 * @Description ǰ׺��
 * @Author Langtao
 * @Date 2021/3/2 21:27
 * @Version V1.0
 */
public class Trie {

    //���ڵ�
    TrieNode root;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * 1.�ڵ��Ѵ���,����ָ��ָ����һ���ӽڵ�
     * 2.�ڵ㲻����,����TrieNode�ڵ�
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
        //����ַ�����β
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
     * TrieNode�ڵ�
     */
    static class TrieNode{
        //��ǰ�ڵ��Ƿ�Ϊ���ַ����Ľ�β
        boolean isEnd;
        //��ǰ�ڵ���ӽڵ�
        TrieNode[] children;


        /**
         * ��ʼ��
         */
        public TrieNode(){
            children= new TrieNode[26];
        }
    }

}
