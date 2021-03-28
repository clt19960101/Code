package Tree;

/**
 * @ClassName TreeNode
 * @Author Chen Langtao
 * @Date 2021/3/28 11:44
 * @Description TODO
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
