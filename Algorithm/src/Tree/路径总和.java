package Tree;

import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName 路径总和
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/27 0:16
 * @Version V1.0
 */

public class 路径总和 {
    //BFS
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        //节点队列
        Queue<TreeNode> queue_node = new LinkedList<>();
        //值队列
        Queue<Integer> queue_val = new LinkedList<>();

        queue_node.offer(root);
        queue_val.offer(root.val);
        while (!queue_node.isEmpty()) {
            TreeNode node = queue_node.poll();
            Integer temp = queue_val.poll();
            if (node.left == null && node.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queue_node.offer(node.left);
                queue_val.offer(temp + node.left.val);
            }
            if (node.right != null) {
                queue_node.offer(node.right);
                queue_val.offer(temp + node.right.val);
            }
        }
        return false;
    }
}
