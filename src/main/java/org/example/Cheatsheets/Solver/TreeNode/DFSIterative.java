package org.example.Cheatsheets.Solver.TreeNode;

import org.example.DS.Graph.Tree.TreeNode;

import java.util.Stack;

public abstract class DFSIterative {
    Stack<TreeNode> stack = new Stack<>();

    public abstract void consume(TreeNode node);

    public void solve(TreeNode root) {
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            consume(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }
}
