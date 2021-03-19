package Tree.TrieTree;

import List.Node;

/**
 * @ClassName TrieTree_Code1
 * @Description 前缀树
 * 1)单个字符串中，字符从前到后的加到一棵多叉树中
 * 2)字符放在边上（路径上），节点上有专属的数据项（常见的是pass和end值）
 * 3)所有样本都这样添加，如果没有路径就先建路径，如果有路径就复用
 * 4)经过节点pass值加一，每个字符串结束时来到的节点end值加1
 * @Author Langtao
 * @Date 2021/3/2 21:27
 * @Version V1.0
 */
public class TrieTree_Code1 {
    public static void main(String[] args) {
        String[] strings = {"abc", "abcd", "asded", "fdsd"};
        TrieTree1 trieTree1 = new TrieTree1();
        for (int i = 0; i < strings.length; i++) {
            trieTree1.insert(strings[i]);
        }
        System.out.println("字符串加入几次=================");
        System.out.println(trieTree1.search("asded"));//1
        System.out.println("以ab字符串为前缀的字符串有几个=================");
        System.out.println(trieTree1.prefixNumber("ab"));//2
        System.out.println("删除已加入字符串abcd=================");
        trieTree1.delete("abcd");
        System.out.println("以ab字符串为前缀的字符串有几个=================");
        System.out.println(trieTree1.prefixNumber("ab"));//1

    }
    public static class Node1 {
        private int pass;
        private int end;
        public Node1[] nexts;

        public Node1() {
            this.pass = 0;
            this.end = 0;
            //假设26个小写字母或大写字母
            //0 表示 a 方向上的路
            //1 表示 a 方向上的路
            //...
            //25 表示 z 方向上的路
            //如果nexts[i] == null 则i方向上的路不存在
            this.nexts = new Node1[26];
        }
    }

    public static class TrieTree1 {
        //只留头节点
        private Node1 root;

        public TrieTree1() {
            this.root = new Node1();
        }

        /**
         * @return void
         * @Author Langtao
         * @Description 插入方法
         * @Date 22:06 2021/3/2
         * @Param [word]
         */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            //从头节点开始
            Node1 node = root;
            node.pass++;
            //字符的路径
            int path = 0;
            //i字符数组的索引 从左往右遍历字符
            for (int i = 0; i < chars.length; i++) {
                //字符对应路径
                path = chars[i] - 'a';
                //判断存不存在该路径
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node1();
                }
                node = node.nexts[path];
                node.pass++;
            }
            //字符串结尾
            node.end++;
        }

        /**
         * @return int
         * @Author Langtao
         * @Description word 这个单词之前加入过几次 这个是看end值
         * @Date 22:05 2021/3/2
         * @Param [word]
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            //同理插入，只是不更新pass和end值
            char[] chars = word.toCharArray();
            //从头节点开始
            Node1 node = root;
            //字符经过路径
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    //字符未加入过
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }

        /**
         * @return int
         * @Author Langtao
         * @Description 查找以pre为前缀的字符串有几个 这个是看pass值
         * @Date 22:06 2021/3/2
         * @Param [pre]
         */
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            Node1 node = root;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }

        /**
         * @return void
         * @Author Langtao
         * @Description 沿途pass--,end--
         * @Date 22:18 2021/3/2
         * @Param [word]
         */
        public void delete(String word) {
            //先查该字符串是否加入过
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                Node1 node = root;
                int path = 0;
                node.pass--;
                for (int i = 0; i < chars.length; i++) {
                    path = chars[i] - 'a';
                    //如果节点的pass值为0，则放弃节点后的路径-->null
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;

            }
        }
    }

}
