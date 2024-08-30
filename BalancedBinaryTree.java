public class BalancedBinaryTree {
    // TODO: Can be made simpler by avoiding object initialization and encode false
    // as some negative height it simple by avoiding object initialization.
    public boolean isBalanced(TreeNode root) {
        return balancedHelper(root, 0).isBalanced;

    }

    public BalancedResponse balancedHelper(TreeNode root, int height) {
        if (root.right == null && root.left == null) {
            return new BalancedResponse(true, height);
        } else {

            BalancedResponse rightHeight = new BalancedResponse(false, height);
            BalancedResponse leftHeight = new BalancedResponse(false, height);

            if (root.left != null) {
                leftHeight = balancedHelper(root.left, height + 1);
                if (!leftHeight.isBalanced) {
                    return leftHeight;
                }
            }

            if (root.right != null) {
                rightHeight = balancedHelper(root.right, height + 1);
                if (!rightHeight.isBalanced) {
                    return rightHeight;
                }
            }

            int nodeHeight = Math.max(leftHeight.height, rightHeight.height);
            return new BalancedResponse(Math.abs(leftHeight.height - rightHeight.height) <= 1, nodeHeight);

        }

    }

    static class BalancedResponse {
        boolean isBalanced;
        int height;

        BalancedResponse(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    };
}
