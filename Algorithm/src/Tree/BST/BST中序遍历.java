package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BST中序遍历
 * @Author Chen Langtao
 * @Date 2021/3/28 11:45
 * @Description 94
 * @Version 1.0
 */
public class BST中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;

    }

    //递归实现
    public void inorder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
