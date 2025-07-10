package org.example.Cheatsheets.Solver.TreeNode;

import org.example.DS.Graph.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public abstract class BFS {
    public int currentLength = 0;
    public Queue<TreeNode> queue = new LinkedList<>();
    public int i = 0;

    public abstract void levelLogic();

    public abstract void consume(int val);

    public void solve(TreeNode root) {
        queue.add(root);

        while(!queue.isEmpty()) {
            currentLength = queue.size();
            levelLogic();

            for (i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                consume(root.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }
}
