package org.example.DSA.Graph.Tree.Binary;

import org.example.DS.Graph.Tree.TreeNode;

import java.util.Stack;

public class Conclusion {

    // TODO: use array utils?
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        var stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        TreeNode curr = root;

        int j = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            var pVal = postorder[i];
            var iVal = inorder[j];
            stack.add(curr);
            curr.right = new TreeNode(pVal);
            curr = curr.right;
            if (pVal == iVal) {
                var diff = j - i - 1;
                while (diff-- > 0) {
                    curr = stack.pop();
                }
                curr.left = new TreeNode(pVal);
                curr = curr.left;
            }
        }

        return root;
    }
}
