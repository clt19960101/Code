package Tree.BST;

import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName �������ľ���β������
 * @Description 103
 * @Author Langtao
 * @Date 2021/5/11 23:27
 * @Version V1.0
 */

public class �������ľ���β������ {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //1.ͨ����������ż�����ж��Ǵ����һ��Ǵ��ҵ���
        //2.�ö���ά����ǰ������Ԫ��,�����в�Ϊ��ʱ����ö��г��ȣ�ÿ�δӶ�����ȡ��size��Ԫ�ؽ�����չ��
        //3.Ȼ�������һ�ε���
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        //���У�ά����ǰ������Ľڵ�
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        //������Ϊtrue
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            //��ǰ��Ľ��
            //˫�˶��нṹ�����Դ�����һ�˲���Ԫ�صĶ���
            Deque<Integer> levleList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                //������
                if (isOrderLeft) {
                    //����ÿ�ν�����������Ԫ�ز�����˫�˶��е�ĩβ
                    levleList.addLast(curNode.val);
                } else {
                    //����ÿ�ν�����������Ԫ�ز�����˫�˶��е�ͷ����
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
