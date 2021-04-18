package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;

/**
 * @ClassName �����������ڵ���С����
 * @Description 783
 * @Author Langtao
 * @Date 2021/4/13 23:21
 * @Version V1.0
 */

public class �����������ڵ���С���� {
    public int minDiffInBST1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder1(root, list);

        int ans = Integer.MAX_VALUE;
        //i��1��ʼ
        for (int i = 1; i < list.size(); i++) {
            ans = Math.min(list.get(i) - list.get(i - 1), ans);
        }
        return ans;

    }

    private void inOrder1(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder1(root.left, list);
        list.add(root.val);
        inOrder1(root.right, list);
    }


//    pre:Ϊǰһ���ڵ��ֵ
    private int pre;
    private int ans;
    /**
     * �߱����߱Ƚ�
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {

        //��Ϊ��Ŀ˵���ڵ�ֵ������
        pre=-1;
        ans = Integer.MAX_VALUE;
        inOrder2(root);
        return ans;

    }

    private void inOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder2(root.left);
        //��һ���ڵ�
        if (pre == -1) {
            pre = root.val;
        }else{
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        inOrder2(root.right);
    }
}
