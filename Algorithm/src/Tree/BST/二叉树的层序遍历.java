package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName 二叉树的层序遍历
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/19 21:12
 * @Version V1.0
 */

public class 二叉树的层序遍历 {
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
        //如果节点已为空，return，结束当前递归分支即可
        if (node == null) {
            return;
        }
        //如果res的长度已经和当前层数level相等，说明res需要多加个位置了，
        //因为level是res数组的索引，索引是一定比长度要小的，如果相等说明数组长度不够长了，得扩容
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }


}
