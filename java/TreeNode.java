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
}

