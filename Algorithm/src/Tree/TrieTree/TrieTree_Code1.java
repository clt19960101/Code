package Tree.TrieTree;

import List.Node;

/**
 * @ClassName TrieTree_Code1
 * @Description ǰ׺��
 * 1)�����ַ����У��ַ���ǰ����ļӵ�һ�ö������
 * 2)�ַ����ڱ��ϣ�·���ϣ����ڵ�����ר�����������������pass��endֵ��
 * 3)����������������ӣ����û��·�����Ƚ�·���������·���͸���
 * 4)�����ڵ�passֵ��һ��ÿ���ַ�������ʱ�����Ľڵ�endֵ��1
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
        System.out.println("�ַ������뼸��=================");
        System.out.println(trieTree1.search("asded"));//1
        System.out.println("��ab�ַ���Ϊǰ׺���ַ����м���=================");
        System.out.println(trieTree1.prefixNumber("ab"));//2
        System.out.println("ɾ���Ѽ����ַ���abcd=================");
        trieTree1.delete("abcd");
        System.out.println("��ab�ַ���Ϊǰ׺���ַ����м���=================");
        System.out.println(trieTree1.prefixNumber("ab"));//1

    }
    public static class Node1 {
        private int pass;
        private int end;
        public Node1[] nexts;

        public Node1() {
            this.pass = 0;
            this.end = 0;
            //����26��Сд��ĸ���д��ĸ
            //0 ��ʾ a �����ϵ�·
            //1 ��ʾ a �����ϵ�·
            //...
            //25 ��ʾ z �����ϵ�·
            //���nexts[i] == null ��i�����ϵ�·������
            this.nexts = new Node1[26];
        }
    }

    public static class TrieTree1 {
        //ֻ��ͷ�ڵ�
        private Node1 root;

        public TrieTree1() {
            this.root = new Node1();
        }

        /**
         * @return void
         * @Author Langtao
         * @Description ���뷽��
         * @Date 22:06 2021/3/2
         * @Param [word]
         */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            //��ͷ�ڵ㿪ʼ
            Node1 node = root;
            node.pass++;
            //�ַ���·��
            int path = 0;
            //i�ַ���������� �������ұ����ַ�
            for (int i = 0; i < chars.length; i++) {
                //�ַ���Ӧ·��
                path = chars[i] - 'a';
                //�жϴ治���ڸ�·��
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node1();
                }
                node = node.nexts[path];
                node.pass++;
            }
            //�ַ�����β
            node.end++;
        }

        /**
         * @return int
         * @Author Langtao
         * @Description word �������֮ǰ��������� ����ǿ�endֵ
         * @Date 22:05 2021/3/2
         * @Param [word]
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            //ͬ����룬ֻ�ǲ�����pass��endֵ
            char[] chars = word.toCharArray();
            //��ͷ�ڵ㿪ʼ
            Node1 node = root;
            //�ַ�����·��
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    //�ַ�δ�����
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }

        /**
         * @return int
         * @Author Langtao
         * @Description ������preΪǰ׺���ַ����м��� ����ǿ�passֵ
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
         * @Description ��;pass--,end--
         * @Date 22:18 2021/3/2
         * @Param [word]
         */
        public void delete(String word) {
            //�Ȳ���ַ����Ƿ�����
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                Node1 node = root;
                int path = 0;
                node.pass--;
                for (int i = 0; i < chars.length; i++) {
                    path = chars[i] - 'a';
                    //����ڵ��passֵΪ0��������ڵ���·��-->null
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
