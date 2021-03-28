package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName BST后续遍历
 * @Author Chen Langtao
 * @Date 2021/3/28 12:10
 * @Description 145
 * @Version 1.0
 */
public class BST后续遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;

    }

    //递归实现
    public void postOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }
}
