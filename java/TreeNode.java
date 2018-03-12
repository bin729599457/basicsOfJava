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

}

