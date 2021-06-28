package Tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName �����������������й��������
 * @Description TODO
 * @Author Langtao
 * @Date 2021/6/1 21:52
 * @Version V1.0
 */

public class �����������������й�������� {
    /**
     * �ݹ�ⷨ
     */
    private Map<Integer,Integer> map;
    public TreeNode buildTree_�ݹ�(int[] inorder, int[] postorder) {
        int in_len = inorder.length;
        int post_len = postorder.length;
        map = new HashMap<Integer,Integer>();
        for(int i=0;i<in_len;i++){
            map.put(inorder[i],i);
        }

        return buildTree(inorder,0,in_len-1,postorder,0,post_len-1);


    }

    TreeNode buildTree(int[] inorder,int inLeft,int inRight, int[] postorder,int poLeft,int poRight){
        if(inLeft>inRight||poLeft>poRight){
            return null;
        }

        TreeNode root = new TreeNode(postorder[poRight]);
        //����������ڵ�����λ��
        int inIndex = map.get(postorder[poRight]);
        //�ҽڵ����
        int right_node_count = inRight - inIndex;

        root.left = buildTree(inorder,inLeft,inIndex-1,postorder,poLeft,poRight-right_node_count-1);

        root.right = buildTree(inorder,inIndex+1,inRight,postorder,poRight-right_node_count,poRight-1);

        return root;

    }


    public TreeNode buildTree_����(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }
}
