package Tree.BST;

import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName 二叉树的锯齿形层序遍历
 * @Description 103
 * @Author Langtao
 * @Date 2021/5/11 23:27
 * @Version V1.0
 */

public class 二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //1.通过层数的奇偶性来判断是从左到右还是从右到左
        //2.用队列维护当前层所有元素,当队列不为空时，求得队列长度，每次从队列中取出size个元素进行拓展，
        //3.然后进行下一次迭代
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        //队列；维护当前层的树的节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        //从左到右为true
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            //当前层的结果
            //双端队列结构：可以从任意一端插入元素的队列
            Deque<Integer> levleList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                //从左到右
                if (isOrderLeft) {
                    //我们每次将被遍历到的元素插入至双端队列的末尾
                    levleList.addLast(curNode.val);
                } else {
                    //我们每次将被遍历到的元素插入至双端队列的头部。
                    levleList.addFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levleList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
