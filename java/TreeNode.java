import java.util.LinkedList;

public class TreeNode {

    int value;

    public TreeNode(int value) {
        this.value = value;
    }

    TreeNode left = null;
    TreeNode right = null;
}

class BinaryTreeErgodic {

    /**
     * 层次优先遍历
     */
    public static void lavelOrderTraverse(TreeNode root) {
        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
    }
    /**
     * 先序遍历
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.value + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     */
    public static void postOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.value + " ");
    }




    /**
     在二叉查找树中：
     (01) 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     (02) 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     (03) 任意节点的左、右子树也分别为二叉查找树。
     (04) 没有键值相等的节点（no duplicate nodes）。
     */

    class Node {
        int data;
        Node left;
        Node right;
    }


    public class BSTChecker {
        private  int lastVisit = Integer.MIN_VALUE;

        public  boolean isBST(Node root) {
            if(root == null) return true;

            boolean judgeLeft = isBST(root.left); // 先判断左子树

            if(root.data >= lastVisit && judgeLeft) { // 当前节点比上次访问的数值要大
                lastVisit = root.data;
            } else {
                return false;
            }

            boolean judgeRight = isBST(root.right); // 后判断右子树

            return judgeRight;
        }
    }
}

