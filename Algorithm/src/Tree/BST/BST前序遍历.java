package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BSTǰ�����
 * @Author Chen Langtao
 * @Date 2021/3/28 12:09
 * @Description 144
 * @Version 1.0
 */
public class BSTǰ����� {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;

    }

    //�ݹ�ʵ��
    public void preOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
}
