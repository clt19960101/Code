package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName �������Ĳ������
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/19 21:12
 * @Version V1.0
 */

public class �������Ĳ������ {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodes.poll();
                temp.add(poll.val);
                if (poll.left != null) {
                    nodes.offer(poll.left);
                }
                if (poll.right != null) {
                    nodes.offer(poll.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    List<List<Integer>> res;
    public List<List<Integer>> levelOrder_DFS(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        //����ڵ���Ϊ�գ�return��������ǰ�ݹ��֧����
        if (node == null) {
            return;
        }
        //���res�ĳ����Ѿ��͵�ǰ����level��ȣ�˵��res��Ҫ��Ӹ�λ���ˣ�
        //��Ϊlevel��res�����������������һ���ȳ���ҪС�ģ�������˵�����鳤�Ȳ������ˣ�������
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }


}
