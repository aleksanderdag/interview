package org.example.DSA.Graph.Tree.Binary;

import org.example.Cheatsheets.Solver.TreeNode.DFS;
import org.example.DS.Pair;
import org.example.DS.Graph.Tree.TreeNode;

public class Recurse {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return root.maximum_depth();
    }

    // TODO: make iterative
    public boolean isSymmetric(TreeNode root) {
        var test = new DFS<TreeNode, Boolean>() {
            @Override
            public Boolean leaf(TreeNode input) {
                return input == null;
            }

            @Override
            public Pair<TreeNode, TreeNode> travel(TreeNode node, TreeNode input) {
                if(input == null || node.val != input.val) {
                    found = true;
                    return new Pair<>(null, null);
                }
                return new Pair<>(input.right, input.left);
            }

            @Override
            public Boolean combine(TreeNode node, Boolean leftVal, Boolean rightVal) {
                return leftVal && rightVal;
            }
        };

        test.solve(root.left, root.right);
        return !test.found;
    }

    // TODO: add short-circuit based on:
    // 1) paths > targetSum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        var test = new DFS<Integer, Integer>() {
            @Override
            public Integer leaf(Integer input) {
                return 0;
            }

            @Override
            public Pair<Integer, Integer> travel(TreeNode node, Integer input) {
                int newInput = input - node.val;
                if (node.left == null && node.right == null && newInput == 0) found = true;
                return new Pair<>(newInput, newInput);
            }

            @Override
            public Integer combine(TreeNode node, Integer leftVal, Integer rightVal) {
                return 0;
            }
        };

        test.solve(root, targetSum);
        return test.found;
    }
}
