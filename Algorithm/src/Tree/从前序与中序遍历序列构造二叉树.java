package Tree;

import java.util.*;

/**
 * @ClassName 从前序与中序遍历序列构造二叉树
 * @Description 105
 * @Author Langtao
 * @Date 2021/5/27 22:27
 * @Version V1.0
 */

public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
    }

    //用空间换时间
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree_递归(int[] preorder, int[] inorder) {
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
        //前序遍历中第一个节点就是根节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        //根节点再中序遍历的位置
        Integer pIndex = indexMap.get(root.val);
        //计算出左子树节点的个数
        int left_tree_size = pIndex - inLeft;

        //构造左子树
        root.left = buildTree(preorder, preLeft + 1, preLeft + left_tree_size, inorder, inLeft, pIndex - 1);
        //构造右子树
        root.right = buildTree(preorder, preLeft + left_tree_size + 1, preRight, inorder, pIndex + 1, inRight);

        return root;

    }

    /**
     * 迭代解法
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_迭代(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        //当前节点的所有还没有考虑过右儿子的祖先节点，栈顶是当前节点
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        //当前节点不断往二叉树左走达到的最终节点
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                //栈顶元素的左子节点
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
