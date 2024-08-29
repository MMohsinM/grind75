
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        } else {
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}