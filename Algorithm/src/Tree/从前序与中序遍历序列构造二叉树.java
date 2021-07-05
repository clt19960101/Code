package Tree;

import java.util.*;

/**
 * @ClassName ��ǰ��������������й��������
 * @Description 105
 * @Author Langtao
 * @Date 2021/5/27 22:27
 * @Version V1.0
 */

public class ��ǰ��������������й�������� {
    public static void main(String[] args) {
    }

    //�ÿռ任ʱ��
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree_�ݹ�(int[] preorder, int[] inorder) {
        int pre_len = preorder.length;
        int in_len = preorder.length;

        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, pre_len - 1, inorder, 0, in_len - 1);


    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        //ǰ������е�һ���ڵ���Ǹ��ڵ�
        TreeNode root = new TreeNode(preorder[preLeft]);
        //���ڵ������������λ��
        Integer pIndex = indexMap.get(root.val);
        //������������ڵ�ĸ���
        int left_tree_size = pIndex - inLeft;

        //����������
        root.left = buildTree(preorder, preLeft + 1, preLeft + left_tree_size, inorder, inLeft, pIndex - 1);
        //����������
        root.right = buildTree(preorder, preLeft + left_tree_size + 1, preRight, inorder, pIndex + 1, inRight);

        return root;

    }

    /**
     * �����ⷨ
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_����(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        //��ǰ�ڵ�����л�û�п��ǹ��Ҷ��ӵ����Ƚڵ㣬ջ���ǵ�ǰ�ڵ�
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        //��ǰ�ڵ㲻�������������ߴﵽ�����սڵ�
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                //ջ��Ԫ�ص����ӽڵ�
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
