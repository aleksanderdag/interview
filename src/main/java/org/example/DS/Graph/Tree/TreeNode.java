package org.example.DS.Graph.Tree;

import java.util.ArrayDeque;
import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //    0
    //  1   2
    // 3 4 5 6 [=parent*2+1 & +2] // NOT TRUE - null
    // TODO: clean up
    public static TreeNode fromArray(Integer[] arr) {
        var queue = new ArrayDeque<TreeNode>();

        if (arr.length == 0) return null;

        int i = 0;
        var mine = new TreeNode(arr[i]);
        queue.add(mine);

        while(!queue.isEmpty()) {
            var curr = queue.remove();
//            var left = arr[i++];
//            var right = arr[i++];
            if(++i < arr.length && arr[i] != null) {
                var leftNode = new TreeNode(arr[i]);
                curr.left = leftNode;
                queue.add(leftNode);
            }
            if(++i < arr.length && arr[i] != null) {
                var rightNode = new TreeNode(arr[i]);
                curr.right = rightNode;
                queue.add(rightNode);
            }
        }

        return mine;

//        // TODO: do without array?
//        var temp = new TreeNode[arr.length];
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (arr[i] != null) {
//                var curr = new TreeNode(arr[i]);
//                temp[i] = curr;
//                int leftIndex = i * 2 + 1;
//                int rightIndex = i * 2 + 2;
//                if (leftIndex < arr.length) curr.left = temp[leftIndex];
//                if (rightIndex < arr.length) curr.right = temp[rightIndex];
//            }
//        }
//
//        this.val = arr[0];
//        this.left = temp[0].left;
//        this.right = temp[0].right;
    }

    public int maximum_depth() {
        return Math.max(left != null ? left.maximum_depth() : 0, right != null ? right.maximum_depth() : 0) + 1;
    }

    // bottom-up
    public static int maximum_depth(TreeNode root) {
        if (root == null) {
            return 0;                                   // return 0 for null node
        }
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);
        return Math.max(left_depth, right_depth) + 1;   // return depth of the subtree rooted at root
    }

    // top-down
    private static int answer; // remember to initialize the answer before calling maximum_depth
    private static void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public String toString() {
//        return "TreeNode{" +
//                "val=" + val +
//                ", left=" + left +
//                ", right=" + right +
//                '}';
        if (left == null && right == null) return val+"";
        return val + "("+left+"," +right+")";
    }
}
