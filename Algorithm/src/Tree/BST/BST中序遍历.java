package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BST�������
 * @Author Chen Langtao
 * @Date 2021/3/28 11:45
 * @Description 94
 * @Version 1.0
 */
public class BST������� {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;

    }

    //�ݹ�ʵ��
    public void inorder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
