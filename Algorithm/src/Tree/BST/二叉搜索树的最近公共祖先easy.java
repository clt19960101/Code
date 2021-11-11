package Tree.BST;

import Tree.TreeNode;

/**
 * @ClassName �����������������������easy
 * @Author Chen Langtao
 * @Date 2021/7/15 23:27
 * @Description 235
 * @Version 1.0
 */
public class �����������������������easy {
    //һ�α���
    //1.��p,q��ֵС��root��ֵ����p,qһ��λ��root��������
    //2.��p,q��ֵ����root��ֵ����p,qһ��λ��root��������
    //3.�����϶���������root����p,q�ķֽ��
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
