package Tree.BST;

import Tree.TreeNode;

/**
 * @ClassName 二叉搜索树的最近公共祖先easy
 * @Author Chen Langtao
 * @Date 2021/7/15 23:27
 * @Description 235
 * @Version 1.0
 */
public class 二叉搜索树的最近公共祖先easy {
    //一次遍历
    //1.若p,q的值小于root的值，则p,q一定位于root的左子树
    //2.若p,q的值大于root的值，则p,q一定位于root的右子树
    //3.若以上都不满足则root即是p,q的分界点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (true) {
            if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }

}
