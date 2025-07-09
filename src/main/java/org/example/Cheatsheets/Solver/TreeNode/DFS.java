package org.example.Cheatsheets.Solver.TreeNode;

import org.example.DS.Pair;
import org.example.DS.Graph.Tree.TreeNode;

public abstract class DFS<I, O> {
    public boolean found = false;

    public abstract O leaf(I input);

    public abstract Pair<I,I> travel(TreeNode node, I input);

    public abstract O combine(TreeNode node, O leftVal, O rightVal);

    public O solve(TreeNode root, I input) {
        if (root == null || found) {
            return leaf(input);
        } else {
            var pair = travel(root, input);
            return combine(root, solve(root.left, pair.left()), solve(root.right, pair.right()));
        }
    }
}
